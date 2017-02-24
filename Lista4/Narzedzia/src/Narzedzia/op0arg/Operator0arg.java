package Narzedzia.op0arg;

import Narzedzia.Calc.Function;

/**
 * Klasa reprezentujaca funkcje zero-argumentowe
 * @author Kamil
 */
public abstract class Operator0arg extends Function{
     /**
     * Zwraca arnosc funkcji
     * @return Arnosc 
     */
    @Override
    public int arity (){
        return 0;
    }
};


