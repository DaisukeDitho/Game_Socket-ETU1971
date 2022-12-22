package serveur;

import tools.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServeurMultiThread implements Runnable {
	
	Serveur server;
	Socket client;
	
	Thread serverThread;
	
	BufferedReader in;
	PrintWriter out;
	
	int clientId = 0;
	String clientName;
	
	String message;
	
	public ServeurMultiThread(Socket client, Serveur server) {
		this.client = client;
		this.server = server;
		Avatar avatar=new Avatar();
		
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream());
			clientId = server.addClient(client);
			server.getavatars().add(new Avatar());
			server.sendUnique("votreID"+" "+clientId,clientId);
			serverThread = new Thread(this);
			serverThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		server.sendToAll("Client N:" + clientId + " connectee.");
		server.sendToAll("Joueur++"+" "+server.getnombreClients());
		
		try {
			message = in.readLine();
			clientName = message;
			
			message = in.readLine();
			while (message != null) {
				//server.sendToAllExpectMe(clientName + ": " + message,this.clientId);
				server.sendToAllExpectMe(message,this.clientId);
				message = in.readLine();
			}
			
			server.sendToAll("Client " + clientId + " s'est deconnecter");
			
			out.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				server.deleteClientAt(clientId);
				client.close();
				serverThread.join();
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
}
