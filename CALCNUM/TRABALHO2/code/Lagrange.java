
public class Lagrange {

    public static void main(String[] args) {
    //declaração de variáveis
    int i,j;   
    int p1=2; 
    double p2= 0.523598775; 
    int a=0; 
    int b=1;
    double h; 
    double p;
    int n=6; 
    
    //calculo de xi
   
    h= 0.166666666666667;
     //h=0.333333333333333;

    double vetor []=new double [n+1]; 
    
    for (i=0;i<n+1;i++) {
        vetor[i]= a+i*h; 
      }

   
         //calcula imprime os resultados para x=pi\6
   System.out.print("x=pi/6  ");
   p=1;
    for(j=0;j<n+1;j++) {
       p=1; 
        for(i=0;i<n+1;i++) {
            if (j!=i) {
            p=p*((p2-vetor[i])/(vetor[j]-vetor[i]));
          }
           
        }
        
           System.out.print(p+"    ");          
        }
        System.out.println();
    
    
        //calcula e imprime os resultados para x=2
        System.out.print("x=2  ");
         p=1;
     for(j=0;j<n+1;j++) {
       p=1; 
        for(i=0;i<n+1;i++) {
            if (j!=i) {
            p=p*((p1-vetor[i])/(vetor[j]-vetor[i]));
          }
           
        }
        
           System.out.print(p+"    ");          
        }
  
    }
}
    
