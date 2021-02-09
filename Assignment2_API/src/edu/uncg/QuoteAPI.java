package edu.uncg;
/*
 02/4/2021
 The purpose of this class is to establish a connection to a api and retrieve the data provided.
 After it will parse through the data and display the desired result.
 John Iacoucci
 */

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class QuoteAPI {

    // The Purpose of this method is get a quote from a random quote API.
    public static void getQuote() {
        //Creating a HTTP connection.
        String urlString = "https://zenquotes.io/api/random";
        URL url;
        try {
            // Making a connection to API.
            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Receiving a response code.
            int status = con.getResponseCode();
            if (status != 200) {
                System.out.println("Could not retrieve" + status);
            } else {
                // Parsing input stream.
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                // Taking the input stream to find "{" to handle JSON Exception for JSON Objects needing to start with "{".
                int i = content.indexOf("{");
                String jsonString = content.toString();
                jsonString = jsonString.substring(i);
                // Closing the connection.
                in.close();
                con.disconnect();
                // Printing the complete JSON.
                // System.out.println("Output: " + content.toString());
                // Parse the string into a JSON object.
                JSONObject obj = new JSONObject(jsonString);
                // Extracting the quote and author from the JSON object then printing.
                Object quote = obj.get("q");
                Object author = obj.get("a");
                System.out.println(quote + " -" + author);
              }
          // Handling and printing any exceptions.
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return;
          }
    }
}