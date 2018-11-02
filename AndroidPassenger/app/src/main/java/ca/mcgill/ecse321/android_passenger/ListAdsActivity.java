package ca.mcgill.ecse321.android_passenger;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ListAdsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adsAdapter;
    private String error = null;
    private List<ListItem> activeAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ads);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); //every item of recycler view has a fixed size
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        activeAds = new ArrayList<>();

        for (int i = 0; i <= 10; i++){
            ListItem listItem = new ListItem(150, 2, "Rogue");
            activeAds.add(listItem);
        }

        adsAdapter = new MyAdapter(activeAds, this);
        recyclerView.setAdapter(adsAdapter);

        //for spinner object
        Spinner spinner = findViewById(R.id.spinner_filters);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListAdsActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.filters));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

//    public void refreshLists(View view) {
//        refreshList("ads");
//
//
//    }
//
//    private void refreshList(String restFunctionName) {
//
//        HttpUtils.get(restFunctionName, new RequestParams(), new JsonHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//                activeAds.clear();
//                for( int i = 0; i < response.length(); i++){
//                    try {
//                        activeAds.add(response.getJSONObject(i).getString("name"));
//                    } catch (Exception e) {
//                        error += e.getMessage();
//                    }
//                    refreshErrorMessage();
//                }
//                adsAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                try {
//                    error += errorResponse.get("message").toString();
//                } catch (JSONException e) {
//                    error += e.getMessage();
//                }
//                refreshErrorMessage();
//            }
//        });
//    }
//
    public void refreshLists(View view) {
        refreshList("ads");


    }

    private void refreshList(String restFunctionName) {

        HttpUtils.get(restFunctionName, new RequestParams(), new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                activeAds.clear();
                for( int i = 0; i < response.length(); i++){
                    try {
                        ListItem adJourney = new ListItem(Double.parseDouble(response.getJSONObject(i).getString("id")), Double.parseDouble(response.getJSONObject(i).getString("Price")), "Rogue");
                        activeAds.add(adJourney);
                    } catch (Exception e) {
                        error += e.getMessage();
                    }
                    refreshErrorMessage();
                }
                adsAdapter.notifyDataSetChanged();
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
