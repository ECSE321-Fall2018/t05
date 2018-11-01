package ca.mcgill.ecse321.android_passenger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class passengerHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_homepage);
        Intent intent = getIntent();

    }

    public void searchRide(View view){
        Intent intent = new Intent(this, ListAdsActivity.class);
        startActivity(intent);
    }


    public void viewMyRides(View view){
        Intent intent = new Intent(this, MyJourneys.class);
        startActivity(intent);
    }

}
