package com.campus02.ald.routefinder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) 
	{
		try (ServerSocket ssock = new ServerSocket(8888);)
		{
			Socket client;
			while (true)
			{
				client = ssock.accept();
				dosomething(); //geil
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
