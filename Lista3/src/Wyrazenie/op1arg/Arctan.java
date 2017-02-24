package Wyrazenie.op1arg;

import Wyrazenie.Wyrazenie;


/**
 * Klasa Arctan reprezentuje Arctangens w podanej wartosci
 * @author Kamil
 * 
 */
public class Arctan extends Operator1arg{
    /**
     * Oblicza wyrazenie dla podanej klasy
     * @return Wynik wyrazenia
     */    
    @Override
    public double oblicz(){
        return Math.atan(x.oblicz());
    }
    
    public Arctan (Wyrazenie x){
        super(x);
    };
     /**
     * 
     * @return Reprezentacja wyrazenia 
     */       
    @Override
    public String toString() {
        return "arctag("+x+")";
    }
}
