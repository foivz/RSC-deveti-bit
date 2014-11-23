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

public class Adapter_za_drawer_listu2 extends BaseAdapter {
	private Context context;
	private String[] text_for_list_item;
	
	public String getTextForListItem(int position) {
		return this.text_for_list_item[position];
	}
	
	public String setItemBgColor(int position) {
		return this.text_for_list_item[position];
	}
	
	public Adapter_za_drawer_listu2(Context context) {
		this.context = context;
		this.text_for_list_item = this.context.getResources().getStringArray(R.array.lista_za_navigaciju2);
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
		row.setBackgroundResource(R.drawable.button_ordinary_selector);
		
		return row;
	}
}
