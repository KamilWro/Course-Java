package obliczenia;
public class TrojkatPascala {
    private final static int MAX=67;
    private static long[][] trojkat=new long[MAX][];
    
    public static int getMAX(){
	return MAX;    	
    }


    static {
        for (int i=0;i<MAX;i++) trojkat[i] = new long[i+1];
        trojkat[0][0]=1;
        trojkat[1][0]=1;
        trojkat[1][1]=1;
        for (int i=2; i<MAX; i++){
            for(int j=0; j<=i; j++ ){
                if(i==j) trojkat[j][i] = 1;
                else if(j==0) trojkat[i][j] = 1;            
                else trojkat[i][j]=trojkat[i-1][j-1]+trojkat[i-1][j];
            }
        }       
    }
    
    public String toString(){
        String napis="";
        for(int i=0; i<MAX; i++){
            for(int j=0; j<=i; j++){
                napis=napis+trojkat[i][j]+" ";
            }
        napis=napis+'\n';
        }
        return napis;   
    }

    public static long czytaj (int n, int k){
        return trojkat[n][k];
    }

}
