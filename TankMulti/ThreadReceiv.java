package thread;

import client.*;
import affichage.*;
import tools.*;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;

public class ThreadReceiv implements Runnable
{
    Thread thread=new Thread(this);
    Joueur jojo;
    String message;
    BufferedReader in;
    Map map;

    public Thread getthread()
    {
        return this.thread;
    }
    public void setjojo(Joueur jojo)
    {
        this.jojo=jojo;
    }
    public Joueur getjojo()
    {
        return this.jojo;
    }
    public void setin(BufferedReader in)
    {
        this.in=in;
    }
    public BufferedReader getin()
    {
        return this.in;
    }
    public void setmap(Map map)
    {
        this.map=map;
    }
    public Map getmap()
    {
        return this.map;
    }

    public ThreadReceiv(BufferedReader in,Joueur jojo,Map map)
    {
        setin(in);
        setjojo(jojo);
        setmap(map);
    }

    public void run()
    {
        String msg;
        try {
				msg = getin().readLine();
                
                while (msg != null) {
                    if(msg.contains("Joueur++")==true) 
                    {
                        String[]haha=msg.split(" ");
                        for(int i=getmap().getavatars().size();i<Integer.parseInt(haha[1]);i++)
                        {
                            getmap().getavatars().add(new Avatar(i));
                        }
                        System.out.println("okay anie , dia ity ny nombre de joueur : "+getmap().getavatars().size());
                    }
                    else if(msg.contains("votreID")==true)
                    {
                        String[]haha=msg.split(" ");
                        getjojo().setID(Integer.parseInt(haha[1]));
                        System.out.println(getjojo().getID());
                    }
                    else if(msg.contains("deplacement")==true)
                    {
                        String[]haha=msg.split("`");
                       // System.out.println(haha[1]+" "+haha[2]+" "+haha[3]);
                       // System.out.println("ity ilay ID :"+getjojo().getID());
                        getmap().getavatars().get(getmap().getavatars().size()-1).setX(Integer.parseInt(haha[2]));
                        getmap().getavatars().get(getmap().getavatars().size()-1).setY(Integer.parseInt(haha[3]));
                        for(int o=0;o<getmap().getavatars().size();o++)
                        {
                            System.out.println("BABE : "+getmap().getavatars().get(o).getID());
                        }
                    }
                    else if(msg.contains("grandeur")==true)
                    {
                        String[]haha=msg.split("`");
                        getmap().getavatars().get(getmap().getavatars().size()-1).setgrandeurX(Integer.parseInt(haha[2]));
                        getmap().getavatars().get(getmap().getavatars().size()-1).setgrandeurY(Integer.parseInt(haha[3]));
                    }
                    msg = getin().readLine();
                }
                
                System.out.println("Serveur déconnecter");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}