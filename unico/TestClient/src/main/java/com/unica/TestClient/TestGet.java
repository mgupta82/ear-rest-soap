package com.unica.TestClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Hello world!
 *
 */
public class TestGet 
{
    public static void main( String[] args )
    {
	       try
	        {
	            URL url = new URL("http://localhost:8081/web/rest/input");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");
	 
	            if (conn.getResponseCode() != 200)
	            {
	                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	            }
	 
	            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	            String apiOutput = br.readLine();
	            System.out.println(apiOutput);
	            conn.disconnect();
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    }
}
