package com.source.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;

public class JSONClient {

	public static void main(String[] args)
			throws IOException, MalformedURLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String string = "";

		InputStream input = new FileInputStream("C:\\Users\\siva_\\workspace\\RESTfulExample1\\json.txt");

		InputStreamReader reader = new InputStreamReader(input);
		BufferedReader bReader = new BufferedReader(reader);
		String line = null;

		while ((line = bReader.readLine()) != null) {
			string += line + "\n";
		}
		bReader.close();
		JSONObject jsonObj = new JSONObject(string);
		System.out.println("The JSON File contents are:");
		System.out.println(jsonObj.toString());

		URL url = new URL("http://localhost:8080/RESTfulExample1/api/JSONProcessorService");
		System.out.println("connection opened at " + url.getHost());
		URLConnection connection = url.openConnection();

		connection.setDoOutput(true);
		connection.setRequestProperty("Content-type", "application/json");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write(jsonObj.toString());
		out.close();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		if (br.readLine() == null) {
			System.out.println("Read nothing terminating.....");
			return;
		}

		System.out.println("Webservice invoked successfully");

	}

}
