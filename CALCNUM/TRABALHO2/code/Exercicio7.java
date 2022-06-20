
public class Exercicio7 {

    public static void main(String[] args) {
        ex7(); 
        
      }
   
     public static void ex7(){
    double a = 0;
    double b = 1;
    int m = 6;
    double ETm = 0;
    double ESm = 0;

        
    double x=0; //somatorio m
    double y1=0; //somatorio Etm
    double xy1=0; //somatorio m*Etm; 
    double xquad=0; //somatorio m ao quadrado 
   
    double y2=0; //somatorio ESm
    double xy2=0; //somatorio m*ESm; 
    double angular1=0; 
    double linear1=0; 
  
    double angular2=0; 
     double linear2=0; 
  
        while(m<=60)  {
            
            ETm = trapezio_f(a, b, m) - integral_f(a, b);
            ESm = simpson_f(a, b, m) - integral_f(a, b);
            
          
       //calculo do MMQ para ETm
           
             x=x+Math.log(m);
             xquad=xquad+(Math.pow(Math.log(m),2)); 
          
            y1=y1+Math.log(ETm);
            xy1=xy1+(Math.log(m)*+Math.log(ETm)); 
            
            
          
       //calculo do MMQ para ESm 
       
          
            y2=y2+Math.log(ESm);
            xy2=xy2+(Math.log(m)*+Math.log(ESm)); 
          
            System.out.println("Para m: "+ m);
            System.out.println("    log(m): " + Math.log(m));
            System.out.println("    log(ETm): " + Math.log(ETm));
            System.out.println("    log(ESm): " + Math.log(ESm));
             m = m + 6;
        }
   
         System.out.println();
         
         System.out.println("Para Etm os coeficientes obtidos pelo MMQ são: ");
       
         angular1= (10*(xy1)-x*y1)/(10*xquad-Math.pow(x,2)); 
         System.out.println("a: "+angular1);
         
         linear1=(x*xy1-y1*xquad)/(Math.pow(x,2)-10*xquad); 
         System.out.println("b: "+linear1);
         
       System.out.println("Para ESm os coeficientes obtidos pelo MMQ são: ");
          angular2= (10*(xy2)-x*y2)/(10*xquad-Math.pow(x,2)); 
         System.out.println("a: "+angular2);
         
         linear2=(x*xy2-y2*xquad)/(Math.pow(x,2)-10*xquad); 
         System.out.println("b: "+linear2);
         
        
    }
     
     public static double integral_f(double a, double b){

        double i_a = Math.pow(a, 10)/10;
        double i_b = Math.pow(b, 10)/10;
        return i_b - i_a;
    }
     
     
     public static double trapezio_f(double a, double b, int m){

        double h = (b - a)/m;
        double soma = 0;
        double x = 0;
        int c = 0;
        int i = 0;

        for (int j = 0; j < m + 1; j++){
            i = j;
            if(i == 0 || i == m){
                c = 1;
            }else{
                c = 2;
            }
            x = a + i*h;
            soma = soma + c*f(x);
        }   
    
        double integral = soma*0.5*h;
        return integral;     
    }
     
      public static double f(double x){
        int p = 9;
        return Math.pow(x, p);
    }
      
      
    public static double simpson_f(double a, double b, int m){

        double h = (b - a)/m;
        double soma = 0;
        double x = 0;
        int c = 0;
        int i = 0;

        for(int j = 0; j < m+1; j++){
            i = j;
            if(i == 0 || i == m){
                c = 1;
            }
            else if(i%2 == 1){
                c = 4;
            }
            else if(i%2 == 0){
                c = 2;
            }

            x = a + i*h;
            soma = soma + c*f(x);
        }

        double integral = (h*soma)/3;
        return integral;

    }

}
    

