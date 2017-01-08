package com.source.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class JSONPProcessor {

	@Path("/JSONProcessorService")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Response processJSONRest(InputStream inputData){
			StringBuilder sb = new StringBuilder();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputData));
			String line=null;
			try {
				while((line=in.readLine())!=null){
					System.out.println("line"+line);
					sb.append(line);
				}
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Data received "+sb.toString());
			return Response.status(200).entity(sb.toString()).build();
	}
	
	@Path("/testservice")
	@GET
	public Response testService(){
		System.out.println("Test service invoked");
		return Response.status(200).entity("Service executed").build();
	}
	
}
