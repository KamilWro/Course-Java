package Wyrazenie.op1arg;

import Wyrazenie.Wyrazenie;

/**
 * Klasa WartBezwzgl reprezentuje wyrazenie wartosci bezwzglednej
 * @author Kamil
 * 
 */
public class WartBewzgl extends Operator1arg{    
    /**
     * Oblicza wyrazenie dla podanej klasy
     * @return Wynik wyrazenia
     */    
    @Override
    public double oblicz(){
        return Math.abs(x.oblicz());
    }
    
    public WartBewzgl (Wyrazenie x){
        super(x);
    };

     /**
     * 
     * @return Reprezentacja wyrazenia 
     */       
    @Override
    public String toString() {
        return "(|"+x+"|)";
    }
}
