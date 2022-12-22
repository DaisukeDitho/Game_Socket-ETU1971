package tools;

import affichage.*;

import javax.swing.*;
import java.awt.*;

public class Avatar extends JPanel
{
    int ID=666;
    int x=220;
    int y=220;
    int grandeurX=10;
    int grandeurY=10;

    public void setID(int id)
    {
        System.out.println("teto no nanome ID : "+id);
        this.ID=id;
    }
    public int getID()
    {
        return this.ID;
    }
    public void setX(int x)
    {
        System.out.println("X an"+ID+" miova");
        this.x=x;
    }
    public int getX()
    {
        return this.x;
    }
    public void setY(int y)
    {
        System.out.println("Y an"+ID+" miova");
        this.y=y;
    }
    public int getY()
    {
        return this.y;
    }    
    public void setgrandeurX(int grandeurX)throws Exception
    {
        if(grandeurX<=300)
        {
            this.grandeurX=grandeurX;
        }
        else
        {
            throw new Exception("MAHARESY");
        }
    }
    public int getgrandeurX()
    {
        return this.grandeurX;
    }
    public void setgrandeurY(int grandeurY)throws Exception
    {
        if(grandeurY<=300)
        {
            this.grandeurY=grandeurY;   
        }
        else
        {
            throw new Exception("MAHARESY");
        }
    }
    public int getgrandeurY()
    {
        return this.grandeurY;
    }

    public Avatar(int ID)
    {
        setID(ID);
    }
    public Avatar()
    {
        
    }

    public void paint(Graphics g)
    {
        g.setColor(new Color(0,0,0));
        g.fillRect(getX(),getY(),getgrandeurX(),getgrandeurY()); 
    }

    public void maty(int ID,Map mapy)
    {
        mapy.getavatars().get(ID).setVisible(false);
    }
}