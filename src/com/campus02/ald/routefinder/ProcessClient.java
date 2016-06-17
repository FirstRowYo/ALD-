package com.campus02.ald.routefinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ProcessClient implements Runnable {

	private Socket client;
	
	public ProcessClient(Socket client) {
		super();
		this.client = client;
	}

	@Override
	public void run() {
		try (
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
			PrintWriter pwPrintWriter = new PrintWriter(osw);
			) {
			String line;
			while((line=br.readLine()) != null) {
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
