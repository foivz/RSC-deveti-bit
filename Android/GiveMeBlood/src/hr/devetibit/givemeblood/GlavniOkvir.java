package hr.devetibit.givemeblood;

import hr.devetibit.givemeblood.adapteri.Adapter_za_drawer_listu;
import hr.devetibit.givemeblood.fragments.Institutions;
import hr.devetibit.givemeblood.fragments.Profile;
import hr.devetibit.givemeblood.fragments.Settings;
import hr.devetibit.givemeblood.fragments.Share;
import hr.devetibit.givemeblood.fragments.Statistics;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

@SuppressWarnings("deprecation")
public class GlavniOkvir extends Activity {
	String naslov;
	Typeface custom_font;
	ListView list_for_drawer;
	Adapter_za_drawer_listu adapter;
	DrawerLayout drawer_layout;
	ActionBarDrawerToggle drawerListener;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.glavni_okvir);
        
        naslov = getTitle().toString();
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/Hotel Oriental.ttf");
        list_for_drawer = (ListView) findViewById(R.id.drawer_list);
        // inicijaliziramo adapter koji smo napravili u svrhu modifikacije zasebnog elementa liste
        adapter = new Adapter_za_drawer_listu(this);
        // kontroli ListView pridodjeljujemo popis elemenata iz string resursa zapisanih sada u adapter
        list_for_drawer.setAdapter(adapter);
        // osluskujemo stanje elemenata na navigaciji zbog promjene izgleda pozadine i naslova
        list_for_drawer.setOnItemClickListener(new DrawerItemClickListener());
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerListener = new ActionBarDrawerToggle(
        		this, 
        		drawer_layout, 
        		R.drawable.givemeblood_ic_navigation_drawer, 
        		R.string.drawer_open, 
        		R.string.drawer_close
        		) {
        	@Override
        	public void onDrawerClosed(View drawerView) {
        		super.onDrawerClosed(drawerView);
        		postaviNaslov(naslov);
                // pokrece se kada se sakrije izbornik
                // metoda invalidateOptionsMenu() u ovom slucaju opet pokazuje ikone akcijske trake
                invalidateOptionsMenu();
            }
        	@Override
            public void onDrawerOpened(View drawerView) {
        		super.onDrawerOpened(drawerView);
        		postaviNaslov(naslov);
                // pokrece se kada se otkrije izbornik
                // metoda invalidateOptionsMenu() u ovom slucaju sakriva ikone akcijske trake zbog menija
                invalidateOptionsMenu();
            }
        };
        drawer_layout.setDrawerListener(drawerListener);
        
        // ikonu aplikacije na akcijskoj traci možemo koristiti kao botun za otkrivanje i sakrivanje menija
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        
        /* na ulazu u aplikaciju æe nam stati prvi izbor, no uvjet ispod je tu
         * kako bi preko metode selectItem() uredno postavili naslov i spremili stanje liste
         */
        if (savedInstanceState == null) {
        	selectItem(0);
        }
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (drawerListener.onOptionsItemSelected(item)) {
            return true;
        }
        
        // Handle action bar actions click
        switch (item.getItemId()) {
        	case R.id.action_settings:
        		return true;
        	default:
        		return super.onOptionsItemSelected(item);
        }
    }
	
	// zove se kada se pozove invalidateOptionsMenu kod promjene stanja navigacije (otvoreno, zatvoreno)
	@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = drawer_layout.isDrawerOpen(list_for_drawer);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
	
	// 2 metode ispod su potrebne kada koristimo ActionBarDrawerToogle zbog sinkronizacije
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerListener.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggle
        drawerListener.onConfigurationChanged(newConfig);
    }
    
	
	
	// dio ispod je bitan da bismo podržali dogaðaje liste, tj. što uèiniti kada kliknemo nešto na njoj...
    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    
    private void selectItem(int position) {
    	Fragment fragment = null;
    	
    	// logika za prijenos iz jednog fragmenta u drugi
    	switch (position) {
    		case 0:
    			fragment = new Profile(this, custom_font);
    			break;
    		case 1:
    			fragment = new Institutions(this, custom_font);
    			break;
    		case 2:
    			fragment = new Statistics(this, custom_font);
    			break;
    		case 3:
    			fragment = new Settings(this, custom_font);
    			break;
    		case 4:
    			fragment = new Share(this, custom_font);
    			break;
    		case 5:
    			Intent i = new Intent(this, MainActivity.class);
    			startActivity(i);
    			finish();
    			break;
    		default:
    			break;
    	}
    	
    	if (fragment != null) {
    		// pomoæu FragmentManager klase možemo zamijeniti jedan fragment za drugi i nakaèiti na main_content
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.main_content, fragment).commit();
 
            // update selected item and title, then close the drawer
            list_for_drawer.setItemChecked(position, true);
            list_for_drawer.setSelection(position);
            //list_for_drawer.getChildAt(position).setBackgroundColor(Color.parseColor("#F01A1A"));
            postaviNaslov(adapter.getTextForListItem(position));
            drawer_layout.closeDrawer(list_for_drawer);
        } else {
            // error in creating fragment
            // Log.e("MainActivity", "Error in creating fragment");
        }
    }
    
    public void postaviNaslov(String title) {
        naslov = title;
        getActionBar().setTitle(naslov);
    }
}
