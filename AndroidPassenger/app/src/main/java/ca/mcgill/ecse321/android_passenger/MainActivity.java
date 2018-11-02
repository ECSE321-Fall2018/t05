package ca.mcgill.ecse321.android_passenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    private String error = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }


    public void login(View view){

        error = "";
        int finalValue;
        final EditText editText = (EditText) findViewById(R.id.username_ID);

        String value = editText.getText().toString();

        if(!(value.toString().equals(""))) {
            finalValue = Integer.parseInt(value);
            error = "";

            HttpUtils.get("drivers/" + finalValue, new RequestParams(), new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    refreshErrorMessage();
                    editText.setText("");
                    Intent intent = new Intent(MainActivity.this, passengerHomepage.class);
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

            refreshErrorMessage();

        }

        else{

            error = "Must enter number";
            refreshErrorMessage();

        }

    }


    public void signup(View view){
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
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


