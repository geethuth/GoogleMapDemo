package com.example.googlemapdemo;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    Marker pattom1;
    public static Marker marker_list[];
    private LatLngBounds.Builder builder;
    private LatLngBounds bounds;
    public Context thisContext;
    int i = 0;
    public static Double[] lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        lat = new Double[]{8.529535,
                8.522359,
                8.518448,
                8.513492,
                8.512261,
                8.509205,
                8.502966,
                8.494774,
                8.488111,
                8.487049
        };
        lng = new Double[]{76.93843,
                76.940983,
                76.942267,
                76.946672,
                76.948344,
                76.94916,
                76.950747,
                76.948001,
                76.948001,
                76.952633
        };
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Pattom
//        LatLng pattom = new LatLng(8.520929
//                , 76.941200);
//        Double lat_avg = 0.0, lng_avg = 0.0, lat_sum = 0.0, lng_sum = 0.0;
//        for (int i = 0; i < lat.length; i++) {
//            lat_sum += lat[i];
//            lng_sum += lng[i];
//        }
//        lat_avg = (lat_sum / lat.length);
//        lng_avg = (lng_sum / lat.length);
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat_avg, lng_avg), 14));
//        pattom1 = mMap.addMarker(new MarkerOptions().position(pattom).title("Pattom"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(pattom));
//        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
//                                              @Override
//                                              public void onInfoWindowClick(Marker marker) {
//                                                  pattom1.showInfoWindow();
//                                              }
//                                          }
//        );
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat[0], lng[0]), 14));
//        mMap.addMarker(new MarkerOptions().position(new LatLng(lat[0], lng[0])));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat[0], lng[0])));

        getLocations();
    }

    private void getLocations() {
//        for (int i = 1; i < lat.length; i++) {
        // final int finalI = i;
        new CountDownTimer(10 * 3000, 3000) {

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onTick(long millisUntilFinished) {

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat[i], lng[i]), 14));
                mMap.addMarker(new MarkerOptions().position(new LatLng(lat[i], lng[i])));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat[i], lng[i])));
                i++;
            }

            @Override
            public void onFinish() {

            }
        }.start();

//        }
    }
}
