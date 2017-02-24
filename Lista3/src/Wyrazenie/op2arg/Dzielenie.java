package Wyrazenie.op2arg;

import Wyrazenie.Wyrazenie;

/**
 * Klasa Dzielenie reprezentuje wyrazenie dzielenia dwoch  wyrazen
 * @author Kamil
 * 
 */
public class Dzielenie extends Operator2Arg{ 
    /**
     * Oblicza wyrazenie dla podanej klasy
     * @return Wynik wyrazenia
     */
    @Override
    public double oblicz(){
        if (y.oblicz()==0) throw new  IllegalArgumentException("Dzielenie przez Zero");
        return x.oblicz()/y.oblicz();
    }
    
    public Dzielenie (Wyrazenie x,Wyrazenie y){
        super(x,y);
    };
    /**
     * 
     * @return Reprezentacja wyrazenia 
     */    
    @Override
    public String toString() {
        return "("+x+" / "+y+")";
    }
}
