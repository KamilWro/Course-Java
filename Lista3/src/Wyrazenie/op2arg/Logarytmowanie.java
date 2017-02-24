package Wyrazenie.op2arg;

import Wyrazenie.Wyrazenie;

/**
 * Klasa Logarytmowanie oblicza logarytm z x przy podstawie y
 * @author Kamil
 * 
 */
public class Logarytmowanie extends Operator2Arg{
    /**
     * Oblicza wyrazenie dla podanej klasy
     * @return Wynik wyrazenia
     */
    @Override
    public double oblicz(){
        double y_1=Math.log(x.oblicz());
        double x_1=Math.log(y.oblicz());
        if (y_1==0) throw new IllegalArgumentException("Dzielenie przez zero");
        return x_1/y_1;
    }
    
    public Logarytmowanie (Wyrazenie y,Wyrazenie x){
        super(x,y);
    };
     /**
     * 
     * @return Reprezentacja wyrazenia 
     */       
    @Override
    public String toString() {
        return "log("+y+","+x+")";
    }
}
