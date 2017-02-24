import obliczenia.TrojkatPascala;
public class Zad2 {
    private static String x,y,znak;
    private static int liczba;

    public static void main(String[] args) {
        try{
            int p =  args[0].indexOf('+');
            if (p!=-1) 
                znak="+";
            if (p==-1){ 
                p =  args[0].indexOf('-');
                znak="-";
            }
            if(p==-1) throw new IllegalArgumentException("Brak znaku arytmetycznego");
        
            x =  args[0].substring(0,p);
            y =  args[0].substring(p+1);
        
            liczba=new Integer(args[1]);

	    if(liczba>=TrojkatPascala.getMAX()) throw new IllegalArgumentException("Za duza potega");
	    if(liczba<0) throw new IllegalArgumentException("Potega mniejsza od zera");
        
            isVar(x);
            isVar(y);
        
            System.out.print(wypisz());
        }catch ( NumberFormatException a)
            {System.out.println("Nie mozna przekonwertowac liczbe"); }
        catch (IllegalArgumentException a)
            {a.printStackTrace(); }
    }

    private static void isVar(String s){
	if (s.length()==0) throw new IllegalArgumentException("Zmienna nie jest wpisana prawidlowo");
        for (int i=0;i<s.length();i++){ 
            if((s.charAt(i)>'z')||(s.charAt(i)<'a')) throw new IllegalArgumentException("Zmienna nie jest wpisana prawidlowo");
        }
    }
    
    private static String wypisz(){
        String w="("+x+znak+y+")^"+liczba+"=";
        if(liczba==0) w=w+1;
        else 
            for(int i=0;i<=liczba;i++){
                if(i!=0){ 
                    if(znak.equals("-")){
                      if(i%2==0) w=w+"+";
                      else w=w+"-";
                    } 
                    else w=w+znak;
                }
                if(TrojkatPascala.czytaj(liczba, i)!=1)
                    w=w+TrojkatPascala.czytaj(liczba, i);
                
                if((TrojkatPascala.czytaj(liczba, i)!=1)&&(liczba-1!=0))
                    w=w+"*";
                
                if (liczba-i==1) 
                    w=w+x;
                else if(liczba-i!=0) 
                    w=w+x+"^"+(liczba-i);
                
                if((TrojkatPascala.czytaj(liczba, i)!=1)&&(i!=0))
                    w=w+"*";
                
                if(i==1) 
                    w=w+y;
                else if(i!=0) 
                    w=w+y+"^"+i;
            }
        return w;
    }
    
}
