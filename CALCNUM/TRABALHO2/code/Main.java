public class Main
{
    public static void main(String args[])
    {
        System.out.println("Exercício 2");
        ex2();
        System.out.println("Exercício 4");
        ex4();
        System.out.println("Exercício 6");
        ex6();
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

    public static void ex6(){

        double a = 0;
        double b = 1;
        int n = 6;
        double h = (b-a)/n;
        double[] x = new double[n+1];
        double[][] A = new double[n+1][n+1];
        double[] y = new double[n+1];

        for(int i = 0; i < n+1; i++){
            x[i] =  a + i*h;
        }
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < n+1; j++){
                A[i][j] = (double) Math.pow(x[j], i);
            }
        }
        for(int i = 0; i < n+1; i++){
            y[i] = (double) n/(i+1);
        }
        double[] w = gauss(A, y, n+1);
        for(int linha = 0; linha < n + 1; linha++)
        {
	    System.out.print("w["+ n +"," + linha + "] = " + w[linha]);
            System.out.print("\n");
        }
        
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

    public static double[] gauss(double[][] A, double[] y, int n){
        boolean troca = true;
        double m = 0;
        double temp;
        double determinante = 1;
        int sgn = 1;
        int l = 0;
        boolean erro = false;
        for (int j = 0; j < n; j++){
            troca = true;
            l = j;
            while(l < n){
                if(A[l][j] == 0 && l != n - 1){
                    l = l + 1;
                    sgn = -sgn;

                }else if(A[l][j] == 0 && l == n - 1){
                    l = l + 1;
                    sgn = -sgn;
                    troca = false;

                }else if(A[l][j] != 0){
                    break;
                }
            }
            if(troca == false && A[j][j] == 0){
                erro = true;
                break;
            }
            else if(troca == true && A[j][j] == 0){
                for(int k = j; k < n; k++){
                    temp = A[j][k];
                    A[j][k] = A[l][k];
                    A[l][k] = temp;
                }
                temp = y[j];
                y[j] = y[l];
                y[l] = temp;
                
            }
            for (int i = j+1; i < n; i++){
                m = - A[i][j]/A[j][j];
                for(int k = j; k < n; k++){
                    A[i][k] = A[i][k] + m*A[j][k];
                }
                y[i] = y[i] + m*y[j];
            }
        }
        for(int i = 0; i < n; i++){
            determinante = determinante*A[i][i];
        }        
        
        if(erro == false){
            determinante = determinante*sgn;
        }
        else{
            determinante = 0;
        }

        double[] x = new double[n];
        x[n-1] = y[n-1]/A[n-1][n-1];
    
        for(int i = n - 2; i >= 0; i--){ 
            x[i] = y[i];
            for (int k = i+1; k < n; k++){
                x[i] = x[i] - A[i][k]*x[k];
            }
            x[i] = x[i]/A[i][i];
        }

        return x;
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

