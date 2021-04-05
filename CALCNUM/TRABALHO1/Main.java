import java.util.ArrayList;

public class Main
{
    public static void main(String args[])
    {
        //System.out.println("~~~~~~> EXERCÍCIO 1");
        //exerc1();
        //System.out.println("~~~~~~> EXERCÍCIO 3");
        //exerc3();
        //System.out.println("~~~~~~> EXERCÍCIO 6");
        //exerc6();
    }

    public static void exerc1(){

        int x = 4;
        int n = 7;
        double det = 0;
        boolean debug  = true;
        
        for(int lambda = 0; lambda <= x; lambda++){

            det = fTGn(lambda, n, debug);
            System.out.println("fT"+n+"("+ lambda +") vale " + det);
            
        }

    }

    public static void exerc3(){
        Double intervalos[][] = {
            {-2.0, -1.8787879},
            {-1.7575758, -1.6363636},
            {-1.5151515, -1.3939394},
            {-1.030303, -0.9090909},
            {-0.5454545, -0.42424238},
            {-0.060606003, 0.060606003},
            {0.4242425, 0.5454545},
            {0.909091, 1.030303},
            {1.3939395, 1.5151515},
            {1.6363637, 1.757576},
            {1.878788, 2.0}
        };
        int tamanho_intervalo = intervalos.length;
        double precisao = Math.pow(10,-12);
        double raiz_aprox_bissec = 0;
        double menor, maior = 0;
        int n_max = 50;
        int n = 11;
        
        for(int j = 0; j < tamanho_intervalo; j++){
            
            if(j <= tamanho_intervalo - 1){

                menor = intervalos[j][0];
                maior = intervalos[j][1];
                
                raiz_aprox_bissec = bisseccao(menor,maior,n_max,precisao, n);
                
                System.out.println("~> intervalo: [" + menor +","+ maior+"]");
                System.out.println("~~~> raiz aprox (bissec): " + raiz_aprox_bissec);
                System.out.println("");
                
            }
        }

    }

    public static void exerc6(){

        Double intervalos[][] = {
            {-2.0, -1.8787879},
            {-1.7575758, -1.6363636},
            {-1.5151515, -1.3939394},
            {-1.030303, -0.9090909},
            {-0.5454545, -0.42424238},
            {-0.060606003, 0.060606003},
            {0.4242425, 0.5454545},
            {0.909091, 1.030303},
            {1.3939395, 1.5151515},
            {1.6363637, 1.757576},
            {1.878788, 2.0}
        };
        int tamanho_intervalo = intervalos.length;
        double precisao = Math.pow(10,-12);
        double menor = 0, maior = 0, x0 = 0;
        double raiz_exata = 0;
        double raiz_aprox_newton = 0;
        double raiz_aprox_bissec = 0;
        int n_max = 50;
        int n = 11;
        int k = 11;
        
        for(int j = 0; j < tamanho_intervalo; j++){
            
            if(j <= tamanho_intervalo - 1){

                menor = intervalos[j][0];
                maior = intervalos[j][1];
                x0 = (maior+menor)/2;
                
                raiz_exata = 2*Math.cos(k*Math.PI/12);
                raiz_aprox_newton = newton(menor,maior, precisao, n_max, x0, n);
                raiz_aprox_bissec = bisseccao(menor,maior,n_max,precisao, n);

                System.out.println("~> intervalo: [" + menor +","+ maior+"]");
                System.out.println("~~~> raiz exata: " + raiz_exata);
                System.out.println("~~~> raiz aprox. (newton): " + raiz_aprox_newton);
                System.out.println("~~~> raiz aprox. (bissec): " + raiz_aprox_bissec);
                System.out.println("~~~> erro (newton): " + Math.abs(raiz_exata - raiz_aprox_newton));
                System.out.println("~~~> erro (bissec): " + Math.abs(raiz_exata - raiz_aprox_bissec));
                
            }
            k = k - 1;
        
        }
    
    }

    public static Double[][] TGn(double lambda, int n){

        Double A[][] = new Double[n][n];

        for(int linha = 0; linha < n; linha++){
            for(int coluna = 0; coluna < n; coluna++){
                A[linha][coluna] = 0d;
            }
        }

        for(int i = 0; i < n; i++){
            if(i < n-1){
                A[i][i+1] = -1d;
                A[i+1][i] = -1d;
            }
            
            A[i][i] = Double.valueOf(lambda);
            
        }
        return A;
    }

    public static double fTGn(double lambda, int n, boolean debug){

        boolean troca = true;
        double m = 0;
        double temp;
        double determinante = 1;
        Double [][] A = TGn(lambda, n);
        Double [][] A_original = TGn(lambda, n);
        int sgn = 1;
        int l = 0;
        int[] t = new int[2];
        boolean erro = false;

        ArrayList<int[]> changeLine = new ArrayList<int[]>();
        
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
                // System.err.println("Erro: sistema singular");
                erro = true;
                break;
            }
            else if(troca == true && A[j][j] == 0){
                for(int k = j; k < n; k++){
                    temp = A[j][k];
                    A[j][k] = A[l][k];
                    A[l][k] = temp;
                }
                t[0] = j + 1;
                t[1] = l + 1;
                changeLine.add(t.clone());
            }
            for (int i = j+1; i < n; i++){
                m = - A[i][j]/A[j][j];
                for(int k = j; k < n; k++){
                    A[i][k] = A[i][k] + m*A[j][k];
                }
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

        if(lambda == 0 && debug){
            System.out.println("V: ");
            printArray(A_original);
            System.out.println("V': ");
            printArray(A);

            if(changeLine.size() == 0){
                System.out.println("trocaLinhas: Não houveram trocas");
            }else{
                System.out.println("trocaLinhas:");
                changeLine.forEach((d) -> printArray(d));
            }
        }
        return determinante;
    }

    public static double fLinha(double lambda, int n){
    
        double derivada = 1;
        double z;
        
        if (lambda == 2){
            
            derivada = (Math.pow((n + 1),5) - Math.pow((n+1),3))/3;
            
        }else if(lambda == -2){
        
            derivada = Math.pow(-1, n+1)*((Math.pow((n + 1),5) - Math.pow((n+1),3))/3);
        
        }else{
            z = lambda/2;
            derivada = ((n + 1)*Math.cos((n+1)*Math.acos(z)) - z*(Math.sin((n+1)*Math.acos(z)))/(math.sin(math.acos(z))))/(2*(math.pow(z,2) - 1));
        }

        return derivada;
    }

    public static double newton(double a, double b, double prec, int n_max, double x0, int n){

        double alpha = x0;
        int i = 0;
        
        while(fTGn(alpha - prec, n, false)*fTGn(alpha + prec, n, false) > 0 && i <= n_max){
            
            i = i + 1;
            
            if(a >= alpha && alpha <= b){
                alpha = alpha - fTGn(alpha, n, false)/fLinha(alpha, n);
            }

        }
        
        return alpha;
    }

    public static double  bisseccao(double m, double M, int n_max, double prec, int n){
    
        double alpha = 0.5*(m+M); // x que será testado
        int count = 0; // número de interações
        boolean debug = false;
        
        while((fTGn(alpha-prec, n, debug)*fTGn(alpha+prec, n, debug)) > 0 && count < n_max){
            
            count = count + 1;
            alpha = 0.5*(m+M);
            
            // verifica se a raíz está no intervalo [m, alpha]
            if(fTGn(alpha, n, debug)*fTGn(m, n, debug) < 0 || fTGn(alpha, n, debug)*fTGn(m, n, debug) == 0 ){
                M = alpha;
            }
            // verifica se a raíz está no intervalo [alpha, M]
            if(fTGn(alpha, n, debug)*fTGn(m, n, debug) > 0){
                m = alpha;
            }
        }
        return alpha;
    }

    public static void printArray(Double A[][])
    {
        int n = A.length;
        for(int linha = 0; linha < n; linha = linha + 1)
        {
            for(int coluna = 0; coluna < n; coluna = coluna + 1)
            {
                System.out.print("[" + A[linha][coluna] + "]");
            }
            System.out.print("\n");
        }
        
    }
    
    public static void printArray(int A[])
    {
        int n = A.length;
        
        for(int i = 0; i < n; i = i + 1)
        {
            System.out.print("[" + A[i] + "]");
        }
        System.out.print("\n");
        
    }
}
