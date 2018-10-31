package ca.mcgill.ecse321.android_driver;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class createJourneyActivity extends AppCompatActivity {

    private String error = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_journey);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Intent intent = getIntent();
        refreshErrorMessage();

    }

    public void postTrip(View view){

        error = "";
        int price;
        final EditText editText = (EditText) findViewById(R.id.journeyPrice);
        final EditText editText1= (EditText) findViewById(R.id.journeySeats);

        String value = editText.getText().toString();
        String value1 = editText1.getText().toString();

        if(!(value.toString().equals("")) && !(value1.toString().equals(""))) {
            price = Integer.parseInt(value);
            error = "";

            createJourneyActivity.this.finish();


        }

        else{
            error="You must enter a price and a number of seats";
        }

        refreshErrorMessage();


    }

    private void refreshErrorMessage(){
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
