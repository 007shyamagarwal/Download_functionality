package com.example.htl.downloadpaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by htl on 14/6/16.
 */
public class Documentactivity extends AppCompatActivity{





        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);


            new RestClient(getApplicationContext()).getDataService().downloadFile1(new Callback<DocumentBean>() {
                @Override
                public void success(DocumentBean staffResultBean, Response response) {

                    if (staffResultBean.getStatus().equals("success")) {

                        List<Datum> staffResultBeanDetails = (ArrayList<Datum>) staffResultBean.getData();
//                        adapter = new StaffListAdapter(StaffListActivityForTask.this, staffResultBeanDetails);
//                        listView.setAdapter(adapter);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("imagepath", staffResultBeanDetails.get(0).getImagepath());
                        startActivity(intent);
//
                    } else if (staffResultBean.getStatus().equalsIgnoreCase("unsuccess"))
                        Toast.makeText(getApplicationContext(), "data Not Found ", Toast.LENGTH_SHORT).show();


                }


                @Override
                public void failure(RetrofitError error) {
                    Log.d("error", error.toString());
                    Toast.makeText(getApplicationContext(), "Error occurs...Try again ", Toast.LENGTH_SHORT).show();
                }

            });

        }
}
