package hr.devetibit.givemeblood;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashScreen extends Activity {
	TextView splash;
	Typeface font_splash_screen;
	int trajanje_splasha_u_sekundama = 1;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        
        getActionBar().hide();
        
        splash = (TextView) findViewById(R.id.splash_tekst);
        // inicijaliziramo font
        font_splash_screen = Typeface.createFromAsset(getAssets(), "fonts/MahrpedigSans.otf");
        // postavljamo font na tekst na ekranu
        splash.setTypeface(font_splash_screen);
        
        // radimo "neki" zadatak u zadanom vremenu  i po zavrsetku zatvaramo tekucu aktivnost
        new Handler().postDelayed(new Runnable() {
        	public void run() {
        		// otvaramo novu aktivnost
        		startActivity(new Intent(SplashScreen.this, MainActivity.class));  
                // zatvaramo trenutnu aktivnost (splash ekran)
                finish();
            }
        }, trajanje_splasha_u_sekundama * 1000);
	}
}
