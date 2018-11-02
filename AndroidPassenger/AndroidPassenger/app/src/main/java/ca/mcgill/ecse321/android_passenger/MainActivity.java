package ca.mcgill.ecse321.android_passenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }


    public void login(View view){

        Intent intent = new Intent(this, passengerHomepage.class);
        startActivity(intent);

    }

    public void signup(View view){
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

}


