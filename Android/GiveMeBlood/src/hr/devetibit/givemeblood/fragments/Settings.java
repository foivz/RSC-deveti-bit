package hr.devetibit.givemeblood.fragments;

import hr.devetibit.givemeblood.R;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Settings extends Fragment {
	Context context;
	Typeface custom_font;
	
	public Settings(Context context, Typeface custom_font) {
		this.context = context;
		this.custom_font = custom_font;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.settings, container, false);
		
		return rootView;
	}
}
