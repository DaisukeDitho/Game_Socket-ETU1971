package serveur;

import tools.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Serveur {
	Vector<Socket> clients = new Vector<Socket>();
	Vector<Avatar> avatars = new Vector<Avatar>();
	
	int nombreClients = 0;
	public static void main(String[] args) {
		Serveur server = new Serveur();
		
		final ServerSocket serverSocket;
		
		
		try {
			serverSocket = new ServerSocket(5000);
			
			while (true) {
				new ServeurMultiThread(serverSocket.accept(), server);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setavatars(Vector<Avatar>ava)
	{
		this.avatars=ava;
	}
	public Vector<Avatar> getavatars()
	{
		return this.avatars;
	}
	
	public int addClient(Socket client) {
		nombreClients++;
		
		clients.add(client);
		
		return clients.size() - 1;
	}
	
	public void deleteClientAt(int i) {
		nombreClients--;
		
		clients.removeElementAt(i);
	}
	
	public void sendToAll(String message) {
		for (int i = 0; i < clients.size(); i++) {
			try {
				PrintWriter out = new PrintWriter(clients.get(i).getOutputStream());
				out.println(message);
				
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void sendToAllExpectMe(String message,int idClient) {
		for (int i = 0; i < clients.size(); i++) {
            if(i!=idClient)
            {
                try {
                    PrintWriter out = new PrintWriter(clients.get(i).getOutputStream());
                    out.println(message);
                    
                    out.flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
		}
	}

	public void sendUnique(String message,int idClient)
	{
		try{
			PrintWriter out=new PrintWriter(clients.get(idClient).getOutputStream());
			out.println(message);

			out.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public int getnombreClients()
	{
		return this.nombreClients;
	}
}