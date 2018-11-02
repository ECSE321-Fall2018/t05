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

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class createJourneyActivity extends AppCompatActivity {

    private String error = null;
    String userID = MainActivity.value;
    String plate = SignupActivity.plate;

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
        final EditText start= (EditText) findViewById(R.id.startingPoint);
        final EditText destination= (EditText) findViewById(R.id.destination);

        String value = editText.getText().toString();
        String value1 = editText1.getText().toString();

        /*This counter was meant to be used to keep track of how many ads currently exist.
        * However, since this data is reinitialized everytime the ap is launched, this does
        * not work. We there for have to manually enter new Ad id everytime we want to create a new add*/
        int counter = 1;

        /*For some reason, the Http post does not go into the onSuccess, which stops
        it from creating an intent and starting another activity*/


        if(!(value.toString().equals("")) && !(value1.toString().equals("")) && !(start.getText().toString().equals("")) &&
                !(destination.getText().toString().equals(""))) {
            HttpUtils.post("ads" + counter + "/" + value+ "/" + userID+ "/" + plate , new RequestParams(), new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    refreshErrorMessage();
                    createJourneyActivity.this.finish();
                    //counter++;

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    try {
                        error += errorResponse.get("message").toString();
                    } catch (JSONException e) {
                        error += e.getMessage();
                    }
                    refreshErrorMessage();
                }
            });
        }

        else {
            error = "You must enter a price, number of seats, Start and Destination";
            refreshErrorMessage();
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
