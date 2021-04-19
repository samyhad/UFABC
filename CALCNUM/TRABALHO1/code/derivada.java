import java.util.Scanner; 
public class derivada{

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in); 
   
        double lambda; 
        int n=11; 
        int contador=7; 
        double derivada; 
        int i; 
         
       double vetor[] = new double [7]; 
       
      vetor[0]=-1.9; 
      vetor[1]=-1.7; 
      vetor[2]=-1.4; 
      vetor[3]=0; 
      vetor[4]=1; 
      vetor[5]=1.5; 
      vetor[6]=2; 
      
    
      for (i=0; i<7;i++) {
        lambda=vetor[i]; 
       
        double z=lambda/2; 

     
        //variaveis para cada item do calculo da segunda condicao 
        double c = Math.acos(z); 
        double x = 12*Math.cos(11*c); 
        double y = Math.sin(11*c); 
        double j=Math.sin(c); 
        double conta = (y/j)*-z; 
        double fin = (x+conta)/(z*z-1); 
      
        if (lambda==-2) {
            derivada= Math.pow(-1, n+1)*((Math.pow((n + 1),5) - Math.pow((n+1),3))/3); 
            System.out.println("A derivada eh "+derivada);
        }
        else if (lambda==2) {
            derivada=(Math.pow((n + 1),5) - Math.pow((n+1),3))/3;
            System.out.println("A derivada eh "+derivada);
        }
        
        else if(Math.abs(lambda)<2){ 
                derivada = ((n + 1)*Math.cos((n+1)*Math.acos(z)) - z*(Math.sin((n+1)*Math.acos(z)))/(Math.sin(Math.acos(z))))/(2*(Math.pow(z,2) - 1));
                                     
                System.out.println("A derivada eh "+derivada);
             }
        else {
            System.out.println("Lambda fora do intervalo");
        }
       
        z=0; 
        derivada=0; 
       
     }
    }    
   
}


