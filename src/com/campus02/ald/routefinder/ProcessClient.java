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
			PrintWriter pw = new PrintWriter(osw);
			) {
			pw.println("Hallo");
			pw.println("Bitte geben Sie einen Start- und Zielpunt ein und");
			pw.println("welchen Suchalgorithmus Sie verwenden wollen:");
			pw.println("1 = Tiefensuche");
			pw.println("2 = Breitensuche");
			pw.println("3 = Dijkstra Algorithmus");
			String line;
			while((line=br.readLine()) != null) {
				String[] array = line.split(" ");
				if(array.length == 3) {
					if(Integer.parseInt(array[2]) == 1) {
						//hier wird Tiefensuche aufgerufen
					}
					if(Integer.parseInt(array[2]) == 2) {
						//hier wird Breitensuche aufgerufen
					}
					if(Integer.parseInt(array[2]) == 3) {
						//hier wird Dijkstra aufgerufen
					}
					else {
						pw.println("Falsche Eingabe!");
					}
				}
				else {
					pw.println("Falsche Eingabe!");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
