package com.example.chucksupreme.zoku;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {


    private Button bt;
    private Dialog dialog;
    final Context context = this;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private FusedLocationProviderClient mFusedLocationClient;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RelativeLayout rlNew = (RelativeLayout) findViewById(R.id.activity_main_new);
        final RelativeLayout rlUp = (RelativeLayout) findViewById(R.id.activity_main_upcoming);
        final RelativeLayout rlBrowse = (RelativeLayout) findViewById(R.id.activity_main_browse);
        final RelativeLayout rlFavorites = (RelativeLayout) findViewById(R.id.activity_main_favorites);

        Button drawerBtn = (Button) findViewById(R.id.drawer_btn_main);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navList);
        String[] osArray = {"Home", "New", "Upcoming", "Browse", "Favorites"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        // components from main.xml
        bt = (Button) findViewById(R.id.login_main);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(context);

                //tell the Dialog to use the dialog.xml as it's layout description
                dialog.setContentView(R.layout.dialog_login);

                dialog.setTitle("LOGIN");

                Button dialogButton = (Button) dialog.findViewById(R.id.login_btn);

                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        drawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        });

        rlNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NewActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Clicked New", Toast.LENGTH_SHORT).show();

            }
        });

        rlUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UpcomingActivity.class);
                startActivity(intent);
                Toast.makeText(view.getContext(), "Clicked Upcoming", Toast.LENGTH_SHORT).show();
            }
        });

        rlBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BrowseActivity.class);
                startActivity(intent);
                Toast.makeText(view.getContext(), "Clicked Browse", Toast.LENGTH_SHORT).show();
            }
        });

        rlFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FavoritesActivity.class);
                startActivity(intent);
                Toast.makeText(view.getContext(), "Clicked Favorites", Toast.LENGTH_SHORT).show();
            }
        });


        //Initialize location services to get last known location
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {

                        }
                    }
                });


    }
    



}