package ca.mcgill.ecse321.android_driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    private String error = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Intent intent = getIntent();
        refreshErrorMessage();
    }

    public void addDriver(View view) {

        error = "";
        int finalValue;
        final EditText editText = (EditText) findViewById(R.id.newdriver_name);
        final EditText editText1 = (EditText) findViewById(R.id.newdriver_model);
        final EditText editText2 = (EditText) findViewById(R.id.newdriver_numberseats);
        final EditText editText3 = (EditText) findViewById(R.id.newdriver_year);
        final EditText editText4 = (EditText) findViewById(R.id.newdriver_platenumber);

        String value = editText.getText().toString();
        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        String value3 = editText3.getText().toString();
        String value4 = editText4.getText().toString();

        if(!(value.toString().equals("")) && !(value1.toString().equals("")) && !(value2.toString().equals("")) && !(value3.toString().equals("")) && !(value4.toString().equals("")) ) {

            error = "";

            Intent intent = new Intent(this, homePageActivity.class);
            startActivity(intent);

        }

        else{
            error="You must enter your name and the make, model, year and plate number of your car";
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
