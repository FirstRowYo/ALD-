package com.campus02.ald.routefinder;

import java.io.IOException;
import java.net.ServerSocket;

public class RouteServer {

	public static void main(String[] args) {
		
		try (
			ServerSocket server = new ServerSocket(1111);
			) {
			while(true) {
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
