package ca.mcgill.ecse321.android_passenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class signup extends AppCompatActivity {
    private String error = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Intent intent = getIntent();
    }

    public void addPassenger(View view){
        error = "";
        int finalValue;
        final EditText editText = (EditText) findViewById(R.id.newpassenger_name);
        final EditText editText1 = (EditText) findViewById(R.id.newpassenger_birth);
        final EditText editText2 = (EditText) findViewById(R.id.newpassenger_phonenumber);
        final EditText editText3 = (EditText) findViewById(R.id.newemail_model);

        String value = editText.getText().toString();
        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        String value3 = editText3.getText().toString();

        if(!(value.toString().equals("")) && !(value1.toString().equals("")) && !(value2.toString().equals("")) && !(value3.toString().equals(""))) {

            error = "";

            Intent intent = new Intent(this, passengerHomepage.class);
            startActivity(intent);

        }

        else{
            error="You must enter your name, date of birth, phone number and email";
        }

        refreshErrorMessage();


        //ADD CODE TO USE DATA ENTERED BY SIGN UP
    }

    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = (TextView) findViewById(R.id.error);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }

    }
}