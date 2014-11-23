package hr.devetibit.givemeblood;


import org.json.JSONException;

import hr.devetibit.givemeblood.entiteti.Donor;

import com.devetibit.givemeblood.serviceinteraction.JsonHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
	TextView regen_pass;
	EditText email, password;
	Button login, new_user;
	// Button recover_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                
        // inicijalizacija kontrola
        regen_pass = (TextView) findViewById(R.id.link_to_pass);
        regen_pass.setOnClickListener(this);
        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.btn_login);
        new_user = (Button) findViewById(R.id.btn_register);
        // recover_password = (Button) findViewById(R.id.btn_forgot_password);
        
        // osluskujemo pritisak na botune unutar tekuce aktivnosti
        login.setOnClickListener(this);
        new_user.setOnClickListener(this);
        // recover_password.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i;
		
		switch(v.getId()) {
			case R.id.btn_login:
				if (!email.getText().toString().trim().equals("") && 
						!password.getText().toString().trim().equals("")) {
					i = new Intent(this, GlavniOkvir.class);
					i.putExtra("r", "0");
					startActivity(i);
					finish();
				}
				else {
					Toast.makeText(this, "Fill empty fields!", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.btn_register:
				// startamo REGISTER aktivnost
				i = new Intent(this, Register.class);
				startActivity(i);
			 	break;
			case R.id.link_to_pass:
				break;
			// case R.id.btn_forgot_password:
			// 	break;
			default:
				break;
		}
	}

}
