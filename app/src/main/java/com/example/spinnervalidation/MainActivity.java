package com.example.spinnervalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText phoneNumber;
    EditText password;
    Button login;
    boolean isphoneNumberValid, isPasswordValid;
    String[] bankNames={"BOI","SBI","HDFC","PNB","OBC"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = (EditText) findViewById(R.id.editTextPhone);
        password = (EditText) findViewById(R.id.editTextTextPassword3);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
            }
        });

//Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

//Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bankNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }

    private void SetValidation() {

            // Check for a valid email address.
            if (phoneNumber.getText().toString().isEmpty()) {
                phoneNumber.setError(getResources().getString(R.string.phoneNumber_error));
                isphoneNumberValid = false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(phoneNumber.getText().toString()).matches()) {
                phoneNumber.setError(getResources().getString(R.string.error_invalid_email));
                isphoneNumberValid = false;
            } else {
                isphoneNumberValid = true;
            }

            // Check for a valid password.
            if (password.getText().toString().isEmpty()) {
                password.setError(getResources().getString(R.string.password_error));
                isPasswordValid = false;
            } else if (password.getText().length() < 8) {
                password.setError(getResources().getString(R.string.error_invalid_password));
                isPasswordValid = false;
            } else {
                isPasswordValid = true;
            }

            if (isphoneNumberValid && isPasswordValid) {
                Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
            }

        }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), bankNames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }
}
