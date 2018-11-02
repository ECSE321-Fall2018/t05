package ca.mcgill.ecse321.android_driver;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

   // public static final String EXTRA_MESSAGE = "ca.ecse321.android_driver.userID";

    private String error = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        refreshErrorMessage();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void login(View view){
        //do something in response to button

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
                    Intent intent = new Intent(MainActivity.this, homePageActivity.class);
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

    public void signUp(View view){
        Intent intent = new Intent(this, SignupActivity.class);
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
