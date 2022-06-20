
public class FracaoIrredutivel {
     public static void main(String args[]) {
     
        int a[] = {154285560, 19285695, 194285520, 19285695, 154285560, 29285685};
        int b = 99999900;
        int i = 2;
        for(int j=0;j<a.length;j++){
            while(i<10000){
                if(a[j]%i==0 &&b%i==0){
                    a[j]=a[j]/i;
                    b=b/i;
                    i=2;
                }
                else{
                    i++;
                }
            }
            int x=j+1;
            System.out.println("w[6,"+x+"]= "+a[j]+"/"+b);
            b=99999900;
            i=2;
        }
    }
}
