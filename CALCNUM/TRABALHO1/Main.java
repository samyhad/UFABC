import java.util.ArrayList;

public class Main
{
    public static void main(String args[])
    {
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

    public static Double[][] TGn(int lambda, int n){

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

    public static double fTGn(int lambda, int n){

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
