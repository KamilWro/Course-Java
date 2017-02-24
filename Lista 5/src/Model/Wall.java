package Model;

/**
 * Klasa reprezentująca ściane
 * @author Kamil
 */
public class Wall{
    private boolean isGone=false;

    /**
     * Czy istnieje w danym miejscu ściana
     * @return istnienie ściany
     */
    public boolean isIsGone() {
        return isGone;
    }
    /**
     * Wybuduj lub zniszcz ściane w danym miejscu
     * @param isGone budowanie/niszczenie ścian
     */
    public void setIsGone(boolean isGone) {
        this.isGone = isGone;
    }
}