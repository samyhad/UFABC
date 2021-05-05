import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main
{
    public static void main(String args[])
    {
        //System.out.println("Exercício 1");
        //ex1();
        //System.out.println("Exercício 2");
        //ex2();
        //System.out.println("Exercício 4");
        //ex4();
        System.out.println("Exercício 7");
        ex7();
        
    }

    public static void ex1()
    {
        int x = 2;
        int n = 3;
        double a = 0;
        double b = 1;
        double h = (b - a)/n;
        double result = 0;

        for (int index = 0; index < n+1; index++){

            result = li(x, h, index, a, n);
            System.out.println("l[" + index + "] = " + result);
        }

    }

    public static void ex2(){

        double a = 0;
        double b = 1;
        int m = 100000;
        int n = 3;
        double h = (b - a)/n;
        double result = 0;

        for (int i = 0; i < n+1; i++){
            result = trapezio(a, b, m, n, i)/h;
            System.out.println("w["+n+","+i+"] = " + result);
        }
    }

    public static void ex4(){
        double a = 0;
        double b = 1;
        int m = 100000;
        int n = 6;
        double h = (b - a)/n;
        double result = 0;
        
        for (int i = 0; i < n + 1; i++){
            result = simpson(a, b, m, n, i)/h;
            System.out.println("w["+n+","+i+"] = " + result);
        }
    }

    public static void ex7(){
        double a = 0;
        double b = 1;
        int m = 6;
        double ETm = 0;
        double ESm = 0;

        while(m<=60)  {
            
            ETm = trapezio_f(a, b, m) - integral_f(a, b);
            ESm = simpson_f(a, b, m) - integral_f(a, b);
            
            System.out.println("Para m: "+ m);
            System.out.println("    log(m): " + Math.log(m));
            System.out.println("    log(ETm): " + Math.log(ETm));
            System.out.println("    log(ESm): " + Math.log(ESm));
            m = m + 6;
        }
    }

    public static void ex8(){

        double r = 0;
    }

    public static double li(double x, double h, int i, double a, int n){

        double x_i = a + i*h;
        double x_j = 0;
        double y = 1;

        for(int j = 0; j < n+1; j++){
            if(i != j){
                x_j = a + j*h;
                y = y*((x - x_j)/(x_i - x_j));
            }
        }

        return y;
    }

    public static double trapezio(double a, double b, int m, int n, int i_li){

        double h = (b - a)/m;
        double h_li = (b - a)/n;
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
            soma = soma + c*li(x, h_li, i_li, a, n);
        }   
    
        double integral = soma*0.5*h;
        return integral;     
    }

    public static double simpson(double a, double b, int m, int n, int i_li){

        double h = (b - a)/m;
        double h_li = (b - a)/n;
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
            soma = soma + c*li(x, h_li, i_li, a, n);
        }

        double integral = (h*soma)/3;
        return integral;

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

    public static double f(double x){
        int p = 9;
        return Math.pow(x, p);
    }

    public static double integral_f(double a, double b){

        double i_a = Math.pow(a, 10)/10;
        double i_b = Math.pow(b, 10)/10;
        return i_b - i_a;
    }

}

