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

public class homePageActivity extends AppCompatActivity {

    private String error = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_homepage_activity);
        Intent intent = getIntent();
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
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

    public void createAd(View view){

        error = "";
        int finalValue;
        final EditText editText = (EditText) findViewById(R.id.number_of_stops);

        String value = editText.getText().toString();

        if(!(value.toString().equals(""))) {

            finalValue = Integer.parseInt(value);

            if (finalValue < 0 || finalValue > 10){
                error = "Invalid number of stops entered";
                refreshErrorMessage();
            }

            else{
                //PUT NUMBER OF STOPS SOMEWHERE
                Intent intent = new Intent(this, createJourneyActivity.class);
                startActivity(intent);

                editText.setText("");
            }
        }

        else{

            error = "Must enter number";
        }
        refreshErrorMessage();

        /*Intent intent = new Intent(this, createJourneyActivity.class);
        startActivity(intent);*/

    }

    public void modifyAd(View view){

        Intent intent = new Intent(this, ModifyJourneyActivity.class);
        startActivity(intent);

    }

    public void endAd(View view){

        //NO DEFINED TASK YET

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
