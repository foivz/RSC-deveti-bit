package hr.devetibit.givemeblood.adapteri;

import hr.devetibit.givemeblood.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_za_drawer_listu extends BaseAdapter {
	private Context context;
	private String[] text_for_list_item;
	// niz ispod sadrži ID slika koje idu pored teksta u listi. Poredak je važan...
	private int[] slike = {
			R.drawable.profile,
			R.drawable.institutions,
			R.drawable.statistics,
			R.drawable.settings,
			R.drawable.share
	};
	
	public String getTextForListItem(int position) {
		return this.text_for_list_item[position];
	}
	
	public String setItemBgColor(int position) {
		return this.text_for_list_item[position];
	}
	
	public Adapter_za_drawer_listu(Context context) {
		this.context = context;
		this.text_for_list_item = this.context.getResources().getStringArray(R.array.lista_za_navigaciju);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.text_for_list_item.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.text_for_list_item[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View row = null;
		// ako je convertView null, onda taj pogled (View) stvaramo prvi put
		if (convertView == null) {
			/* sa LayoutInflater XML objekt pretvaramo u Java objekt i to u ovom
			 * sluèaju pridjelimo objektu View koji predstavlja redak
			 */
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.custom_drawer_list_item, parent, false);
		} else {
			row = convertView;
		}
		// sada kada imamo Java objekt možemo na njega dohvatiti kontrole u ruèno izraðenom layout-u
		TextView text = (TextView) row.findViewById(R.id.text_view);
		ImageView image = (ImageView) row.findViewById(R.id.image_view);
		
		// kada smo dohvatili kontrole, postavimo im vrijednosti. Metoda getView se vrti za svaki objekt...
		text.setText(text_for_list_item[position]);
		image.setImageResource(slike[position]);
		
		// stilovi...
		text.setTextColor(Color.parseColor("#DCDDDE"));
		
		return row;
	}
}
