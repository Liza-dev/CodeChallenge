package com.example.myapplication.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class GitHubApi {
    static Activity activity;
    public static void githubApi(final Activity context){
        activity=context;
        new Atask().execute();
    }
    static class Atask extends AsyncTask<String,Void,Void> {
        private ProgressDialog pDialog;
        boolean apiLimitExceeded = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(activity);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            HttpURLConnection urlConnection;
            URL url;
            InputStream inputStream;
            String response="";
            try{
                String URL="https://api.github.com/repos/android/sunflower/commits";
                String URL1="https://api.github.com/repos/Liza-dev/CodeChallenge/commits";
                url = new URL(URL);
                Log.e("url link", url.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
               // String basicAuth = "Basic "+ Base64.encodeToString("liza@1894:password".getBytes(), Base64.DEFAULT).replace("\n", "");
              //  urlConnection.setRequestProperty ("Authorization", basicAuth);

                //set request type
                urlConnection.setRequestMethod("GET");
                urlConnection.setDoInput(true);
                urlConnection.connect();
                //check for HTTP response
                int httpStatus = urlConnection.getResponseCode();
                Log.e("httpstatus", "The response is: " + httpStatus);

                //if HTTP response is 200 i.e. HTTP_OK read inputstream else read errorstream
                if (httpStatus != HttpURLConnection.HTTP_OK) {
                    inputStream = urlConnection.getErrorStream();
                    Map<String, List<String>> map = urlConnection.getHeaderFields();
                    System.out.println("Printing Response Header...\n");
                    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                        System.out.println(entry.getKey()
                                + " : " + entry.getValue());
                    }
                }
                else {
                    inputStream = urlConnection.getInputStream();
                }

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                while((temp = bufferedReader.readLine())!=null){
                    response+=temp;
                }
                Log.e("webapi json object",response);


                if(response.contains("API rate limit exceeded")){
                    apiLimitExceeded =true;
                }else {
                    //convert data string into JSONObject
                }

                urlConnection.disconnect();
            } catch (MalformedURLException | ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pDialog.dismiss();
        }
    }

}
