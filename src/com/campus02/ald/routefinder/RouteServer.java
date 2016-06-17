package com.campus02.ald.routefinder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RouteServer {

	public static void main(String[] args) {
		
		try (
			ServerSocket server = new ServerSocket(1111);
			) {
			while(true) {
				Socket client = server.accept();
				ProcessClient pc = new ProcessClient(client);
				
				Thread t = new Thread(pc);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
