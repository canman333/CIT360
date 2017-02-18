package com.example.casey.urlconnectproject;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Casey on 11/2/2016.
 */

public class threadConnect implements Runnable {

    //variable to be accessed from class
    public static String textInput;


    public void run() {
        // These two need to be declared outside the try/catch
        // so that they can be closed in the finally block.
        HttpURLConnection openConnection = null;
        BufferedReader read = null;

        //initialize variable to be used
        String stringInput = null;

        try {
            //Nasty Path: Pass an empty string for the construction of the URL
            //URL url = new URL("");

            //Nasty Path: URL that does not exist
            //URL url = new URL("http://www.dontExist.com");

            //Happy Path: Construct the URL
            URL url = new URL("https://www.facebook.com/");

            //Nasty Path: Pass null to the url connection
            //openConnection = (HttpURLConnection) url.openConnection(null);

            //Happy Path: Create the http request, and open the connection
            openConnection = (HttpURLConnection) url.openConnection();
            openConnection.setRequestMethod("GET");
            openConnection.setDoOutput(true);
            openConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = openConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            read = new BufferedReader(new InputStreamReader(inputStream));

            //declare variable to store each line from the http request
            String line;
            while ((line = read.readLine()) != null) {
                //format the input to be on new lines
                buffer.append(line + "\n");
            }

            //store string input in stringInput variable
            stringInput = buffer.toString();

            //store string in textInput
            textInput = stringInput.toString();

        } catch (IOException e) {
            Log.e("PlaceholderFragment", "Error ", e);
            // If the code didn't successfully get the data, there's no point in attempting
            // to parse it.
        } finally{
            if (openConnection != null) {
                //Nasty Path: Not to disconnect the connection

                //Happy Path
                openConnection.disconnect();
            }
            if (read != null) {
                try {
                    read.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }
    }

}




