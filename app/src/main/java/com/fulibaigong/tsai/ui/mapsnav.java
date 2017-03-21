package com.fulibaigong.tsai.ui;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mapsnav extends AppCompatActivity implements OnMapReadyCallback {
    SupportMapFragment mapFragment;
    GoogleMap map;
    static final LatLng NKUT = new LatLng(24.2321570, 120.6454390);
    static final LatLng f = new LatLng(23.4653640, 120.4836330);
    ArrayList<LatLng> markerPoints;
    int t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapsnav);
        IndexActivity.mContext = this;
        LatLng target = new LatLng(24.2321570, 120.6454390);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        map = mapFragment.getMap();
        markerPoints = new ArrayList<LatLng>();
        // Enable MyLocation Button in the Map
        map.setMyLocationEnabled(true);
        MarkerOptions markerOpt3 = new MarkerOptions();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Intent it = getIntent();
        t = it.getIntExtra("testt",0);
        if(t == 1)
        {
            target = new LatLng(24.2321570, 120.6454390);
            markerOpt3.title("趙家窯工藝坊");
        }
        else if(t==2)
        {
            target = new LatLng(24.1684150,120.6451980);
            markerOpt3.title("陳光國 怡陶居工作室");
        }
        else if(t==3)
        {
            target = new LatLng(24.1436280,120.6762500);
            markerOpt3.title("陳銘堂 觀竹堂");
        }
        else if(t==4)
        {
            target = new LatLng(24.1744040,120.6800980);
            markerOpt3.title("陳遠芳 遠芳金屬工藝坊");
        }
        else if(t==5)
        {
            target = new LatLng(24.2508020,120.55546700);
            markerOpt3.title("周妙文 陶妍藝術創作坊");
        }
        else if(t==6)
        {
            target = new LatLng(24.2603170,120.7226020);
            markerOpt3.title("黃吉正 士口一止陶藝工作室");
        }
        else if(t==7)
        {
            target = new LatLng(24.3608930,120.6383870);
            markerOpt3.title("廖勝文 鐵山漆坊");
        }
        else if(t==8)
        {
            target = new LatLng(24.2518210,120.7501270);
            markerOpt3.title("史嘉祥 憶林舍工作室");
        }
        else if(t==9)
        {
            target = new LatLng(24.0600260,120.6972850);
            markerOpt3.title("蔡榮祐 廣達藝苑");
        }
        markerOpt3.position(target);
        markerOpt3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        map.addMarker(markerOpt3);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(target, 15.0f));
        // MarkerOptions markerOpt = new MarkerOptions();
        //  markerOpt.position(nkut);
        //  markerOpt.title("目前位置");
        //  markerOpt.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        //   map.addMarker(markerOpt);


    }

    @Override
    public void onMapReady(GoogleMap map) {
       // map.moveCamera(CameraUpdateFactory.zoomTo(16));
        //   map.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(23.4653640, 120.4836330)));
    }

    public void onGoplace(View v)
    {
      /*  // Getting URL to the Google Directions API
        String url = getDirectionsUrl(f, NKUT);
        DownloadTask downloadTask = new DownloadTask();
        // Start downloading json data from Google Directions
        // API
        downloadTask.execute(url);
        map.moveCamera(CameraUpdateFactory.zoomTo(6));*/
        String saddr="";
        String daddr="";
        if(t==1)
        {
            daddr = "daddr=" + 24.2321570 + "," + 120.6454390;
        }
        else if(t==2)
        {
            daddr = "daddr=" + 24.1684150 + "," + 120.6451980;
        }
        else if(t==3)
        {
            daddr = "daddr=" + 24.1436280 + "," + 120.6762500;
        }
        else if(t==4)
        {
            daddr = "daddr=" + 24.1744040 + "," + 120.6800980;
        }
        else if(t==5)
        {
            daddr = "daddr=" + 24.2508020 + "," + 120.55546700;
        }
        else if(t==6)
        {
            daddr = "daddr=" + 24.2603170 + "," + 120.7226020;
        }
        else if(t==7)
        {
            daddr = "daddr=" + 24.3608930 + "," + 120.6383870;
        }
        else if(t==8)
        {
            daddr = "daddr=" + 24.2518210 + "," + 120.7501270;
        }
        else if(t==9)
        {
            daddr = "daddr=" + 24.0600260 + "," + 120.6972850;
        }
        String uriString = "http://maps.google.com/maps?" + saddr + "&" + daddr;
        Uri uri = Uri.parse(uriString);
        Intent it = new Intent(android.content.Intent.ACTION_VIEW, uri);
        startActivity(it);

    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + ","
                + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + output + "?" + parameters;

        return url;
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception while downloading url", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
    }

    /** 解析JSON格式 **/
    private class ParserTask extends
            AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(
                String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(5);  //導航路徑寬度
                lineOptions.color(Color.RED); //導航路徑顏色

            }

            // Drawing polyline in the Google Map for the i-th route
            map.addPolyline(lineOptions);
        }
    }

}

