import java.util.ArrayList;

public class Main
{
    public static void main(String args[])
    {
        System.out.println("~~~~~~> EXERCÍCIO 2");
        exerc2();
        System.out.println("~~~~~~> EXERCÍCIO 6");
        exerc6();
    }

    public static void exerc2(){

        int x = 4;
        int n = 6;
        double det = 0;
        
        for(int lambda = 0; lambda <= x; lambda++){

            det = fTGn(lambda, n);
            if(det != 0){
                System.out.println("Determinante:" + det);
            }
        }

    }

    public static void exerc6(){

        double [] intervalos = {2, 1.8, 1.5, 1.4, 1, 0.5, 0, -0.6, -1, -1.5, -1.8, -2};
        int tamanho_intervalo = intervalos.length;
        double precisao = Math.pow(10,-12);
        double menor = 0, maior = 0, x0 = 0;
        double raiz_exata = 0;
        double raiz_aprox = 0;
        int n_max = 50;
        int n = 11;
        int k = 1;
        
        for(int j = 0; j < tamanho_intervalo; j++){
            
            if(j + 1 <= tamanho_intervalo - 1){

                menor = intervalos[j];
                maior = intervalos[j + 1];
                x0 = (maior+menor)/2;
                
                raiz_exata = 2*Math.cos(k*Math.PI/12);
                raiz_aprox = newton(menor,maior, precisao, n_max, x0, n);

                System.out.println("~> intervalo: [" + menor +","+ maior+"]");
                System.out.println("~~~> raiz exata: " + raiz_exata);
                System.out.println("~~~> raiz aprox: " + raiz_aprox);
                System.out.println("~~~> erro: " + Math.abs(raiz_exata - raiz_aprox));
                
            }
            k = k + 1;
        
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

    public static double fTGn(double lambda, int n){

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
                System.out.println("Erro: sistema singular");
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
        for(int i = 0; i < n && erro == false; i++){
            determinante = determinante*A[i][i];
        }        
        
        if(erro == false){

            determinante = determinante*sgn;

            if(lambda == 0){
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
        }
        else{
            determinante = 0;
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
        
        while(fTGn(alpha - prec, n)*fTGn(alpha + prec, n) > 0 && i <= n_max){
            
            i = i + 1;
            
            if(a >= alpha && alpha <= b){
                alpha = alpha - fTGn(alpha, n)/fLinha(alpha, n);
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
