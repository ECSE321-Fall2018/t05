package ca.mcgill.ecse321.android_driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

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

        String value = editText.getText().toString();

        if(!(value.toString().equals(""))) {

            error = "";

            HttpUtils.post("drivers/" + "14" +"/" + value, new RequestParams(), new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    refreshErrorMessage();
                    Intent intent = new Intent(SignupActivity.this, homePageActivity.class);
                    startActivity(intent);
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

        else{
            error="You must enter your name and the make, model, year and plate number of your car";
        }

        refreshErrorMessage();


        //ADD CODE TO USE DATA ENTERED BY SIGN UP
    }

    public void addVehicle(View view){

        error = "";
        final EditText editText1 = (EditText) findViewById(R.id.newdriver_model);
        final EditText editText2 = (EditText) findViewById(R.id.newdriver_numberseats);
        final EditText editText3 = (EditText) findViewById(R.id.newdriver_year);
        final EditText editText4 = (EditText) findViewById(R.id.newdriver_platenumber);

        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        String value3 = editText3.getText().toString();
        String value4 = editText4.getText().toString();

        if( !(value1.toString().equals("")) && !(value2.toString().equals("")) && !(value3.toString().equals("")) && !(value4.toString().equals("")) ) {


            HttpUtils.post("vehicles/" + value4 + "/" + value3 + "/" + value1 + "/" +
                    value2 + "/" + "14", new RequestParams(), new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    refreshErrorMessage();
                    Intent intent = new Intent(SignupActivity.this, homePageActivity.class);
                    startActivity(intent);
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
