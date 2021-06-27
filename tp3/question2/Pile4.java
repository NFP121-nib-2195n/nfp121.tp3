package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.LinkedList;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private LinkedList<Object> list;
    
    /** la capacité de la pile */
    private int capacite;
    
    /** le nombre */
    private int nombre;

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
            
        this.list = new LinkedList<Object>();
        this.capacite = taille;
        nombre = 0;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            {throw new PilePleineException();}
        nombre ++;
        this.list.add(o);
    }

    public Object depiler() throws PileVideException {
        // a completer        
        if (estVide())
            {throw new PileVideException();}
        Object o = this.list.getLast();
        this.list.removeLast();
        nombre --;
        return o;
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide()){
            throw new PileVideException();
        }
        
        return list.getLast();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return list.size() == 0;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return list.size() == capacite();
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
                
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i).toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        
        return sb.toString();
    }

    public boolean equals(Object o) {
        // a completer
        if(o == null) { return false; }
        if(! (o instanceof PileI) ) {return false;}
        
        Pile4 p1 = (Pile4)o;
        if( (p1.taille() != this.taille()) 
                || (p1.capacite() != this.capacite()) )
            { return false; }
        
        for(int i=0; i<this.taille(); i++){
            if( !p1.list.get(i).equals( this.list.get(i) ) ){
                return false;
            }
        }
            
        return true;
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}