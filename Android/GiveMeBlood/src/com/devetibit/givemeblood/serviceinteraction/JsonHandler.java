package com.devetibit.givemeblood.serviceinteraction;

import hr.devetibit.givemeblood.entiteti.Donor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonHandler {
	static int action_id;
	static String email, password, password_repeated;
	static JSONObject jobj;
	static String url_to_post = "http://ernestfoi.herokuapp.com/donors";
	static String url_to_get = "http://ernestfoi.herokuapp.com/donor/1.json";
	
	public JsonHandler(int action_id, String email, String password) {
		JsonHandler.action_id = action_id;
		JsonHandler.email = email;
		JsonHandler.password = password;
	}
	
	public JsonHandler(int action_id, String email, String password, String password_repeated) {
		JsonHandler.action_id = action_id;
		JsonHandler.email = email;
		JsonHandler.password = password;
		JsonHandler.password_repeated = password_repeated;
	}
	
	private static JSONObject ActionLogIn(JSONObject json) {
		
		return null;
	}
	
	private static JSONObject ActionRegister(JSONObject donor) {
		JSONObject jobject =new JSONObject();
		
		try {			
			donor.accumulate("email", JsonHandler.email);
			donor.accumulate("password", JsonHandler.password);
			donor.accumulate("password_confirmation", JsonHandler.password_repeated);
			jobject.accumulate("donor", donor);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.i("jobjekt..", jobject.toString());
		return jobject;
	}
	
	public static String POST(String url) {
		InputStream inputStream = null;
		String result = "";
		
		try {	
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			String json = "";
			JSONObject donor = new JSONObject();
			JSONObject j;
			
			if (JsonHandler.action_id == 0) {
				j = ActionLogIn(donor);
			}
			else {
				j = ActionRegister(donor);
			}
			saveJSONObject(j);
			
			json = j.toString();			
			StringEntity se = new StringEntity(json);

			httpPost.setEntity(se);
			
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			HttpResponse httpResponse = httpclient.execute(httpPost);
			// httpResponse ne prima nista sa servera, a salje...
			inputStream = httpResponse.getEntity().getContent();

			if(inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";
		} catch (Exception e) {
			// Log.d("InputStream", e.getLocalizedMessage());
		}

		return result;
	}
	
	public static String GET_string_format(String url) {
		InputStream inputStream = null;
        String result = "";
        
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            
            inputStream = httpResponse.getEntity().getContent();

            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
 
        } catch (Exception e) {
            // Log.d("InputStream", e.getLocalizedMessage());
        }
 
        return result;
	}
	
	public static Donor getUserUponLogin(String url) throws NumberFormatException, JSONException {
		String result = GET_string_format(url);
		JSONObject jobject = new JSONObject(result);
		
		Donor d = new Donor(Integer.parseInt(jobject.getString("id")), jobject.getString("push_reg_id"));
		d.setIme(jobject.getString("first_name"));
		d.setPrezime(jobject.getString("last_name"));
		d.setEmail(jobject.getString("email"));
		d.setNote(jobject.getString("note"));
				
		return d;
	}
	
	public static void saveJSONObject(JSONObject jobj) {
		JsonHandler.jobj = jobj;
	}
	
	public static JSONObject getJSONObject() {
		return JsonHandler.jobj;
	}
	
	private static String convertInputStreamToString(InputStream inputStream) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		
		// citamo rezultat i ako je prazno, neuspjeli prijenos...
		while((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		
		return result;
	}
}