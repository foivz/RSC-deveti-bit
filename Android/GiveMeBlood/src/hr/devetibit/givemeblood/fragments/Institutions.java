package hr.devetibit.givemeblood.fragments;

import hr.devetibit.givemeblood.R;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Institutions extends Fragment {
	Context context;
	Typeface custom_font;
	
	public Institutions(Context context, Typeface custom_font) {
		this.context = context;
		this.custom_font = custom_font;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.institutions, container, false);
		
		return rootView;
	}
}
