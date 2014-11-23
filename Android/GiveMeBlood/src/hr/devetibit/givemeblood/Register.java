package hr.devetibit.givemeblood;

import org.json.JSONObject;




import com.devetibit.givemeblood.serviceinteraction.JsonHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	EditText email, password, password_repeat;
	Button register;
	//JsonHandler json;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        
        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        password_repeat = (EditText) findViewById(R.id.password_repeat);
        register = (Button) findViewById(R.id.btn_register2);
        register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!email.getText().toString().trim().equals("") && 
						!password.getText().toString().trim().equals("") && 
						!password_repeat.getText().toString().trim().equals("")) {
					// JsonHandler json = new JsonHandler(1, email.getText().toString(),
					// 		password.getText().toString(), password_repeat.getText().toString());
					// String json_result = json.POST("http://ernestfoi.herokuapp.com/donors");
					// Toast.makeText(Register.this, json_result, Toast.LENGTH_LONG).show();
					// JSONObject json_object = json.getJSONObject();
					
					
					//if (id != null) {
						// dohvati sve propertije povratnog objekta
						
					//} else {
						//Toast.
					//}
//					new HttpAsyncTask().execute("http://ernestfoi.herokuapp.com/donors");
//					json.PostHelper();
					
					if (password.getText().toString().trim().equals(password_repeat.getText().toString().trim())) {
						Toast.makeText(Register.this, "Registration successful!", Toast.LENGTH_LONG);
						Intent i = new Intent(Register.this, GlavniOkvir.class);
						i.putExtra("r", "1");
						startActivity(i);
						finish();
					}
					else
						Toast.makeText(Register.this, "Passwords mistmatch!", Toast.LENGTH_SHORT).show();
				}
				else {
					Toast.makeText(Register.this, "Fill empty fields!", Toast.LENGTH_SHORT).show();
				}
			}
        	
        });
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        
        return true;
    }
	/*
	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			return JsonHandler.POST(urls[0]);
		}
		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
		}
	}*/
}

