package ecouteur;

import tools.*;
import client.*;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class EcouteurMouvement implements KeyListener
{
    Joueur jojo;
    Avatar avatar;
    int ID;
    public void setjojo(Joueur jojo)
    {
        this.jojo=jojo;
    }
    public Joueur getjojo()
    {
        return this.jojo;
    }
    public void setavatar(Avatar avatar)
    {
        this.avatar=avatar;
    }
    public Avatar getavatar()
    {
        return this.avatar;
    }
    public void setID(int ii)
    {
        this.ID=ii;
    }
    public int getID()
    {
        return this.ID;
    }

    public EcouteurMouvement(Joueur jojo)
    {
        setjojo(jojo);
    }
    public EcouteurMouvement(Avatar ava)
    {
        setavatar(ava);
    }
    public EcouteurMouvement(Joueur jojo,int ID,Avatar ava)
    {
        setjojo(jojo);
        setID(ID);
        setavatar(ava);
    }

    public void keyPressed(KeyEvent e)
    {
        try
        {
            if(e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                System.out.println(getavatar().getID());
                getavatar().setX(getavatar().getX()-5);
                getjojo().setmessageToSend("deplacement`"+getavatar().getID()+"`"+getavatar().getX()+"`"+getavatar().getY());
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                System.out.println(getjojo().getID());
                getavatar().setX(getavatar().getX()+5);
                getjojo().setmessageToSend("deplacement`"+getavatar().getID()+"`"+getavatar().getX()+"`"+getavatar().getY());
            }
            if(e.getKeyCode()==KeyEvent.VK_UP)
            {
                System.out.println(getjojo().getID());
                getavatar().setY(getavatar().getY()-5);
                getjojo().setmessageToSend("deplacement`"+getavatar().getID()+"`"+getavatar().getX()+"`"+getavatar().getY());
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN)
            {
                System.out.println(getjojo().getID());
                getavatar().setY(getavatar().getY()+5);
                getjojo().setmessageToSend("deplacement`"+getavatar().getID()+"`"+getavatar().getX()+"`"+getavatar().getY());
            }
            if(e.getKeyCode()==KeyEvent.VK_P)
            {
                try
                {
                    System.out.println("++");
                    getavatar().setgrandeurX((int)(getavatar().getgrandeurX()*2));
                    getavatar().setgrandeurY((int)(getavatar().getgrandeurY()*2));
                    getjojo().setmessageToSend("grandeur`"+getavatar().getID()+"`"+getavatar().getgrandeurX()+"`"+getavatar().getgrandeurY());
                }
                catch(Exception ess)
                {
                    JOptionPane.showMessageDialog(getjojo().getmap(),ess.getMessage());
                }
            }
        }
        catch(Exception ej)
        {
            ej.printStackTrace();
        }
    }

    public void keyReleased(KeyEvent e)
    {
        try
        {
            getjojo().setmessageToSend("haha");
        }
        catch(Exception ef)
        {
            ef.printStackTrace();
        }
    }

    public void keyTyped(KeyEvent e)
    {

    }
}