package hr.devetibit.givemeblood.fragments;

import org.json.JSONException;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

import com.devetibit.givemeblood.serviceinteraction.API1;
import com.devetibit.givemeblood.serviceinteraction.JsonHandler;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hr.devetibit.givemeblood.R;
import hr.devetibit.givemeblood.adapteri.Adapter_za_drawer_listu2;
import hr.devetibit.givemeblood.entiteti.Donor;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Profile extends Fragment {
	Context context;
	Typeface custom_font;
	ImageView user, medal;
	TextView ime, prezime, email, note;
	TextView krvna_grupa, broj_donacija, share;
	ListView l;
	Adapter_za_drawer_listu2 adapter2;
	JsonHandler json;
	Donor d;
	
	public Profile(Context context, Typeface custom_font) {
		this.context = context;
		this.custom_font = custom_font;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.profil, container, false);
		
		user = (ImageView) rootView.findViewById(R.id.slika_user);
		user.setImageResource(R.drawable.profilna_demonstracija);
		medal = (ImageView) rootView.findViewById(R.id.slika_medal);
		medal.setImageResource(R.drawable.golda);
		// ime = (TextView) rootView.findViewById(R.id.ime);
		// prezime = (TextView) rootView.findViewById(R.id.prezime);
		// email = (TextView) rootView.findViewById(R.id.email);
		// note = (TextView) rootView.findViewById(R.id.note);
		
		krvna_grupa = (TextView) rootView.findViewById(R.id.ime);
		krvna_grupa.setText("Krvna grupa:			AB+");
		krvna_grupa.setTextColor(Color.parseColor("#222222"));
		krvna_grupa.setTypeface(custom_font);
		broj_donacija = (TextView) rootView.findViewById(R.id.prezime);
		broj_donacija.setText("Broj_donacija:			24");
		broj_donacija.setTextColor(Color.parseColor("#222222"));
		broj_donacija.setTypeface(custom_font);
		share = (TextView) rootView.findViewById(R.id.email);
		share.setText("Share achievement!			");
		share.setTextColor(Color.parseColor("#222222"));
		share.setTypeface(custom_font);
		l = (ListView) rootView.findViewById(R.id.lista1);
		adapter2 = new Adapter_za_drawer_listu2(context);
		l.setAdapter(adapter2);
		
		
		// kako smo vec na LOGIN aktivnosti, saljemo direktno podatke na json
		//json = new JsonHandler(0, email.getText().toString(),
		//		password.getText().toString());
		
		
		
		return rootView;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		
		/*
		try {
			d = JsonHandler.getUserUponLogin("http://ernestfoi.herokuapp.com/donor/1.json");
			ime.setText(d.getIme());
			prezime.setText(d.getPrezime());
			email.setText(d.getEmail());
			note.setText(d.getNote());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		//getDonor();
	}
	
	private Callback<Donor> callbackDonorResponseDonor = new Callback<Donor>() {
		@Override
		public void success(Donor responseSignIn, Response response) {
			Log.i("success", "msg: " + responseSignIn.getPrezime());
		}
		@Override
		public void failure(RetrofitError error) {
			Log.i("failure", "msg: " + error.getMessage());
		}
	};
	
	private void getDonor() {
		RestAdapter restAdapter = new RestAdapter.Builder().setConverter(new GsonConverter(createGson()))
	    	.setEndpoint(API1.API_LOCATION)
	    	.build();
		
		restAdapter.create(API1.class).signIn(1);
	}
	
	public static Gson createGson() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		}
}
