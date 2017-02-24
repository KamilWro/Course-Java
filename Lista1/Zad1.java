public class Zad1 {
    public static void main(String[] args)  {
        int liczba = 0;
        Liczebniki x;
        
        for (int i=0; i<args.length; i++){   
            try{
                liczba=new Integer(args[i]);
                x=new Liczebniki(liczba);
                System.out.println(x);
            }catch ( NumberFormatException a){System.out.println("Nie mozna przekonwertowac liczbe"); }
            catch (IllegalArgumentException a){a.printStackTrace(); }
        }
    }
}
