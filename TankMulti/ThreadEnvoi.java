package thread;

import client.*;

import java.io.PrintWriter;
import java.util.Scanner;

public class ThreadEnvoi implements Runnable
{
    Thread thread=new Thread(this);
    PrintWriter out;
    Scanner sc;
    Joueur jojo;

    public Thread getthread()
    {
        return this.thread;
    }
    public void setout(PrintWriter out)
    {
        this.out=out;
    }
    public PrintWriter getout()
    {
        return this.out;
    }
    public void setsc(Scanner sc)
    {
        this.sc=sc;
    }
    public Scanner getsc()
    {
        return this.sc;
    }
    public void setjojo(Joueur jojo)
    {
        this.jojo=jojo;
    }
    public Joueur getjojo()
    {
        return this.jojo;
    }

    public ThreadEnvoi(PrintWriter out,Scanner sc,Joueur jojo)
    {
        setout(out);
        setsc(sc);
        setjojo(jojo);
    }

    public void run()
    {
        String msg;
        while(true) 
        {
            try
            {
                msg=this.getjojo().getmessageToSend();
                out.println(msg);
                out.flush();
                Thread.sleep(20);
            }
            catch(Exception e)
            {
                
            }
            /*msg = sc.nextLine();
            this.getout().println(msg);
            this.getout().flush();*/
        }
    }
}