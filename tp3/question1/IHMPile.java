package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;

public class IHMPile extends JFrame implements ActionListener{
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");
    private Pile p;
    private PolygoneRegulier polyReg;
    private int nCote, longCote; 
    
    public IHMPile(){
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(5);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("empiler")){
            try
            {
                nCote = Integer.parseInt(donnee.getText());
                longCote = Integer.parseInt(sommet.getText());
                polyReg = new PolygoneRegulier(nCote, longCote);
                p.empiler(polyReg);
                contenu.setText(p.toString());
            }
            catch(NumberFormatException e){
                contenu.setText("erreur: "+ e.getMessage());
            }
            catch (question1.PilePleineException ppe)
            {
                contenu.setText("la pile est Pleine !");
            }

        }else{

            try
            {
                p.depiler();
                contenu.setText(p.toString());
            }
            catch (question1.PileVideException pve)
            {
                contenu.setText("la pile est Vide !");
            }
            
        }
    }

    public static void main(String[] args){
        new IHMPile();
    }
}
