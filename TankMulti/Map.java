package affichage;

import client.*;
import tools.*;
import ecouteur.*;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Map extends JPanel
{
    Vector<Avatar> avatars=new Vector<Avatar>();
    JFrame jf;
    int ID;
    Joueur jojo;

	public Vector<Avatar> getavatars()
	{
		return this.avatars;
	}
    public void setjf(JFrame jf)
    {
        this.jf=jf;
    }
    public JFrame getjf()
    {
        return this.jf;
    }
    public void setID(int ii)
    {
        this.ID=ii;
    }
    public int getID()
    {
        return this.ID;
    }
    public void setjojo(Joueur jojo)
    {
        this.jojo=jojo;
    }
    public Joueur getjojo()
    {
        return this.jojo;
    }

    public Map(Joueur jojo,int ID)
    {
        this.setID(ID);
        //this.getjp().setBackground(new Color(0,124,62));
        JFrame jf=new JFrame("axaxaxa");

        jf.add(this);
        //jf.addKeyListener(new EcouteurMouvement(getavatars().get(0)));
        jf.setSize(450,450);

        this.setBackground(new Color(255,255,255));


        //this.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setjf(jf);
    }

    public void paint(Graphics g)
    {
        g.setColor(new Color(146,175,217));
        g.fillRect(0,0,450,450);
        for(int i=0;i<avatars.size();i++)
        {
            avatars.get(i).paint(g);
        }
        repaint();
    }

    public void addEcouteur()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(Exception e)
        {

        }
        getjf().addKeyListener(new EcouteurMouvement(getjojo(),ID,getavatars().get(getID())));
    }

}