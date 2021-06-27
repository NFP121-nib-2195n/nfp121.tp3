package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
        
        if (taille < 0)
        taille = PileI.CAPACITE_PAR_DEFAUT;
        
        v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter
        if (estPleine())
            {throw new PilePleineException();}
        
        this.v.add(o);
    }

    public Object depiler() throws PileVideException {
        // à compléter
        if (estVide())
            {throw new PileVideException();}
            
        Object o = v.get(v.size()-1);
        this.v.removeElementAt(v.size()-1);
        return o;
    }

    public Object sommet() throws PileVideException {
        // à compléter
        if(estVide()){
            throw new PileVideException();
        }
        
        return v.get(v.size()-1);
    }

    public int taille() {
        // à compléter
        return v.size();
    }

    public int capacite() {
        // à compléter
        return v.capacity();
    }

    public boolean estVide() {
        // à compléter
        return v.isEmpty();
    }

    public boolean estPleine() {
        // à compléter
        return v.size() == capacite();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
                
        for (int i = v.size() - 1; i >= 0; i--) {
            sb.append(v.get(i).toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        
        return sb.toString();
    }

    public boolean equals(Object o) {
        if(o == null) { return false; }
        if(! (o instanceof PileI) ) {return false;}
        
        Pile3 p1 = (Pile3)o;
        if( (p1.taille() != this.taille()) 
                || (p1.capacite() != this.capacite()) )
            { return false; }
        
        for(int i=0; i<this.taille(); i++){
            if( !p1.v.get(i).equals( this.v.get(i) ) ){
                return false;
            }
        }
            
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
