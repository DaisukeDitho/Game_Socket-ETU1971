package client;

import affichage.*;
import thread.*;
import tools.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Joueur {
	Socket clientSocket;
	BufferedReader in;
	PrintWriter out;
    String messageToSend="Tsy mihetsika";
	Map map;
	static int ID;
	
	public void setmap(Map map)
	{
		this.map=map;
	}
	public Map getmap()
	{
		return this.map;
	}

    public void setmessageToSend(String mess)
    {
        this.messageToSend=mess;
    }
    public String getmessageToSend()
    {
        return this.messageToSend;
    }
	public void setID(int a)
	{
		this.ID=a;
	}
	public int getID()
	{
		return this.ID;
	}

	static Scanner sc = new Scanner(System.in);
	
	String serverIp = "localhost";
	int port = 5000;
	String clientName = "NULL";
	
	public Joueur(String serverIp, int port, String name) {
		this.serverIp = serverIp;
		this.port = port;
		this.clientName = name;
	}
	
	public void initClient(Map map) {
		try {
			clientSocket = new Socket(this.serverIp, this.port);
			
			out = new PrintWriter(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			out.println(this.clientName);
			
			/*Thread envoi = new Thread(new Runnable() {				
				String msg;
				@Override
				public void run() {
					while(true) {
                        /*msg=this.getmessageToSend();
                        out.println(msg);
                        out.flush();*/
						/*msg = sc.nextLine();
						out.println(msg);
						out.flush();
					}
				}
			});*/
			
            ThreadEnvoi envoi=new ThreadEnvoi(out,sc,this);
			envoi.getthread().start();

			ThreadReceiv recevoir=new ThreadReceiv(in,this,map);
			recevoir.getthread().start(); 
			

			
			/*Thread recevoir = new Thread(new Runnable() {
				String msg;
				@Override
				public void run() {
					try {
						
						msg = in.readLine();
						
						while (msg != null) {
							if(msg.contains("Joueur++")==true)
							{
								String[]haha=msg.split(" ");
								for(int i=0;i<Integer.parseInt(haha[1]);i++)
								{
									map.getavatars().add(new Avatar());
								}
								System.out.println("okay anie");
							}
							else if(msg.contains("votreID")==true)
							{
								String[]haha=msg.split(" ");
								this.setID(Integer.parseInt(haha[1]));
								System.out.println(ID);
							}
							//else if(msg.contains("deplacement"))
							else
							{
								System.out.println("Serveur: " + msg);
							}
							msg = in.readLine();
						}
						
						System.out.println("Serveur déconnecter");
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
        System.out.println("Entrer votre Name :");
        String name=sc.nextLine();
        //Map map=new Map(this);
        Joueur jojo=new Joueur("localhost", 5000, name);
		Map map=new Map(jojo,ID);
		jojo.initClient(map);
		map.setjojo(jojo);
		map.addEcouteur();
		System.out.println("ny ID ako dia :"+ ID);
	}
}
