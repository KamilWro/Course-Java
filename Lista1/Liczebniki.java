public class Liczebniki {
    private static String[] jed_glowne = {"zero", "one", "two","three","four","five","six","seven","eight","nine"};
    private static String[] jed_porzad = {"zeroth", "first", "second", "third","fourth", "fifth", "sixth", "seventh", "eighth", "ninth"};
    private static String[] nast_glowne = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] nast_porzad = {"tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth"};
    private static String[] dzies_glowne = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static String[] dzies_porzad = {"zeroth", "tenth", "twentieth", "thirtieth", "fortieth", "fiftieth", "sixtieth", "seventieth", "eightieth", "ninetieth"};
    private static String[] inne_glowne = {"houndred","thousand", "milion", "bilion"};
    private static String[] inne_porzad = {"hundredth","thousandth", "milionth", "bilionth"};
    int x;
    
    @Override
    public String toString(){
        String liczba="";
        if (x==0) liczba=jed_porzad[0];
        else{
            int tmp=x;
            int koniec;
            int kolejka=0;
            int wielkosc=0;
            int poprzednia_liczba=0;
            boolean is=false;
            
            while(tmp>0){    
                koniec=tmp%10;
                tmp/=10;
                                                
                switch (kolejka) {
                    case 0:
                        if (((tmp%100!=0)||(koniec!=0))&&(is==true)&&(wielkosc>0)) liczba = inne_glowne[wielkosc]+ " " + liczba;
                        else if (((tmp%100!=0)||(tmp%10!=0))&&(is==false)&&(wielkosc>0)){
                            liczba = inne_porzad[wielkosc]+liczba;
                            is=true;
                        }
                        if((wielkosc==0)&&(tmp%10!=1)&&(koniec!=0)){                           
                            liczba=jed_porzad[koniec]+liczba;
                            is=true;                           
                        }
                        else if ((is==true)&&(tmp%10!=1)){ 
                            liczba=jed_glowne[koniec]+" "+liczba;
                        }   
                        poprzednia_liczba=koniec;
                        break;
                    case 1:
                        if ((is==false)&&(koniec!=0)){
                            if(koniec==1)
                                liczba=nast_porzad[poprzednia_liczba]+liczba;
                            else 
                                liczba=dzies_porzad[koniec]+liczba;
                            is=true;
                        }
                        else if ((is==true)&&(koniec!=0)){
                            if(koniec==1){
                                liczba=nast_glowne[poprzednia_liczba]+" "+liczba;
                            }
                            else{
                                if(poprzednia_liczba!=0)
                                    liczba=" - "+liczba;                           
                                liczba=dzies_glowne[koniec]+liczba;
                            }
                        }
                        if ((poprzednia_liczba!=0)&&(koniec!=0)&&(tmp%10!=0)) liczba=" and "+liczba;
                        break;
                    case 2:
                        if ((koniec!=0)&&(is==false)){
                            liczba = inne_porzad[0] + liczba;
                            is=true;
                        }
                        else if ((koniec!=0)&&(is==true)) liczba = inne_glowne[0]+ " " + liczba;
                        if (koniec!=0) liczba=jed_glowne[koniec]+" "+liczba;
                        wielkosc++;
                        kolejka=-1;
                        break;
                    default:
                        break;
                }
                
                kolejka++;
            }
        }
        liczba=liczba+" ("+x+liczba.substring(liczba.length()-2)+")";
        return liczba;

    }
    public Liczebniki(int x){
        this.x=x;
        if (x<0) throw new IllegalArgumentException("liczba ujemna " + x + " jest b³êdem");
    }
    

}
