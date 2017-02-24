package Wyrazenie.op1arg;

import Wyrazenie.Wyrazenie;

/**
 * Klasa abstrakcyjna reprezentujaca wyrazenia z jednym argumentem
 * @author Kamil
 * 
 */
public abstract class Operator1arg extends Wyrazenie{
    protected final Wyrazenie x;

    public Operator1arg (Wyrazenie arg1) {
        if (arg1==null) throw new IllegalArgumentException();
        x = arg1;
    }
}
