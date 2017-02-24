package Wyrazenie.op2arg;

import Wyrazenie.Wyrazenie;
import Wyrazenie.op1arg.Operator1arg;

/**
 * Klasa abstrakcyjna reprezentujaca wyrazenia z dwoma argumentami
 * @author Kamil
 * 
 */
public abstract class Operator2Arg extends Operator1arg {
    protected final Wyrazenie y;

    public Operator2Arg (Wyrazenie a1, Wyrazenie a2) {
        super(a1);
        if (a2==null) throw new IllegalArgumentException();
        y = a2;
    }
}
