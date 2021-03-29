import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/*import org.apache.commons.lang3.ArrayUtils;*/

public class Matriz 
{
    int n;
    private double matriz[][];

    public Matriz(int linhas, int colunas)
    {
        this.n = linhas;
        this.matriz = new double[this.n][this.n];
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

    public static double ftgn(int lambda, int n){

        boolean troca = true;
        double m = 0;
        double temp;
        double determinante = 1;
        Double [][] A = TGn(lambda, n);
        Double [][] A_original = TGn(lambda, n);
        int sgn = 1;
        int l = 0;
        int[] t = new int[2];

        ArrayList<int[]> changeLine = new ArrayList<int[]>();
        
        for (int j = 0; j < n-1; j++){
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
            }
            else if(troca == true && A[j][j] == 0){
                for(int k = j; k < n; k++){
                    temp = A[j][k];
                    A[j][k] = A[l][k];
                    A[l][k] = temp;
                }
                t[0] = j + 1;
                t[1] = l + 1;
                changeLine.add(t);
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
            
        determinante = determinante*sgn;

        System.out.println("V: ");
        System.out.println(A);
        System.out.println("V': ");
        System.out.println(A_original);

        if(troca == false){
            System.out.println("trocaLinhas: Não houveram trocas");
        }else{
            System.out.println("trocaLinhas:");
            System.out.println(changeLine);
        }

        return determinante;
    }

    private Matriz inserir(Matriz matriz, int valor)
    {
        matriz.matriz[matriz.n][matriz.n] = valor;
        return matriz;
    }

    public Matriz gerarMatriz(Matriz matriz)
    {
        //Scanner sc = new Scanner(System.in);
        for(int linha = 0; linha < matriz.n; linha = linha + 1)
        {
            for(int coluna = 0; coluna < matriz.n; coluna = coluna + 1)
            {
                matriz.matriz[linha][coluna] = 0; //sc.nextInt();
            }
        }

        return matriz;
    }

    public static Matriz preencherTn(Matriz matriz, int lambda){
        //Scanner scan = new Scanner(System.in);
        
        int n = matriz.n;

        for(int i = 0; i < n; i++){
            if(i < n-1){
                matriz.matriz[i][i+1] = -1;
                matriz.matriz[i+1][i] = -1;
            }
            
            matriz.matriz[i][i] = lambda;
            
        }
        return matriz;
    }

    public void mostrarMatriz(Matriz matriz)
    {
        for(int linha = 0; linha < matriz.n; linha = linha + 1)
        {
            for(int coluna = 0; coluna < matriz.n; coluna = coluna + 1)
            {
                System.out.print("[" + matriz.matriz[linha][coluna] + "]");
            }
            System.out.print("\n");
        }
        
    }

    public boolean encontrarValor(Matriz matriz, int valor)
    {
        int count = 0;
        for(int linha = 0; linha < matriz.n; linha = linha + 1)
        {
            for(int coluna = 0; coluna < matriz.n; coluna = coluna + 1)
            {
                if(matriz.matriz[linha][coluna] == valor){
                    count = count + 1;
                }else{
                    count = count + 0;
                }
            }
        }
        
        if(count == 0 ) {
            return false;
        } else {
            return true;            
        }
    }

    public Matriz escalonamento(Matriz matriz){

        /*int n = matriz.n;
        double m;
        double temp;
        boolean validator = true;

        for(int j = 0; j < n - 1; j++){
            int l = j;
            while(matriz.matriz[l][j] == 0){
                if(l < n - 1){
                    l = l + 1;
                }else{
                    System.out.println("Erro -> Sistema singular");
                    validator = false;
                    break;
                }
                
            }
            if(validator){
                
                for(int k = j; k < n; k++){
                    temp = matriz.matriz[j][k];
                    matriz.matriz[j][k] = matriz.matriz[l][k];
                    matriz.matriz[l][k] = temp;
                }
            }
            for(int i = j + 1; i < n; i++){
                m = -matriz.matriz[i][j]/matriz.matriz[j][j];
                for(int k = j; k < n; k++){
                    matriz.matriz[i][k] = matriz.matriz[i][k] + m*matriz.matriz[j][k];
                }
            }
        }

        return matriz;*/
        /*double temp = 0;
        int n = matriz.n;
        int sgn = 1;
        int count = 0;
        double determinante = 1;
        boolean validator = false;

        for(int j = 0; j < n-1; j++){
            count = j;

            while(matriz.matriz[count][j] == 0){
                count = count +1;
                sgn = -sgn;
                if(count >= n){
                    break;
                }
                
            }
            if(count >= n){
                System.out.println("Erro -> Sistema singular");
            
            }else if(matriz.matriz[count][j] != 0){
                System.out.println("Trocando linhas na coluna "+ (j + 1));
                for (int k = j; k < n; k++){
                    temp = matriz.matriz[j][k];
                    matriz.matriz[j][k] = matriz.matriz[count][k];
                    matriz.matriz[count][k] = temp;
                }

                //double[] T = matriz.matriz[j];
                //matriz.matriz[j] = matriz.matriz[count];
                //matriz.matriz[count] = T;
            }

            double m;

            if(matriz.matriz[j][j] != 0){
                for(int i = j+1; i < n; i++){

                    m = - matriz.matriz[i][j]/matriz.matriz[j][j];
            
                    for(int k = j; k < n; k ++){
                        matriz.matriz[i][k] = matriz.matriz[i][k] + m*matriz.matriz[j][k];
                    }      
                }
            }
        }

        for(int i = 0; i < n; i++){
            determinante = determinante*matriz.matriz[i][i];
        }
        determinante = determinante*sgn;
        System.out.println("    DET: "+determinante);

        return matriz;
        */
    }

    public Matriz encontrarDeterminante(Matriz matriz)
    {

        int n = matriz.n;
        int sgn = 1;
        int count = 0;
        double determinante = 1;
        boolean validator = false;

        for(int j = 0; j < n-1; j++){
            count = j;

            while(matriz.matriz[count][j] == 0){
                System.out.println("Entrei j = "+ j);
                count = count +1;
                sgn = -sgn;
            }
            if(count > n){
                System.out.println("Erro -> Sistema singular");
            
            }
                double[] temp = matriz.matriz[j];
                matriz.matriz[j] = matriz.matriz[count];
                matriz.matriz[count] = temp;
            

            double m;

            if(matriz.matriz[j][j] != 0){
                for(int i = j+1; i < n; i++){

                    m = - matriz.matriz[i][j]/matriz.matriz[j][j];
            
                    for(int k = j; k < n; k ++){
                        matriz.matriz[i][k] = matriz.matriz[i][k] + m*matriz.matriz[j][k];
                    }      
                }
            }
        }

        for(int i = 0; i < n; i++){
            determinante = determinante*matriz.matriz[i][i];
        }
        determinante = determinante*sgn;
        System.out.println("DETERMINANTE:" +  determinante);
        return matriz;

    }

    public int encontrarAutoValor(Matriz matriz)
    {
        return 0;
    }

    public static boolean ehAutoVetor(int[]x, int tamanho){

        boolean validador = false;
        for(int i = 0; i < tamanho; i++){
          if(x[i] != 0)
          {
            validador = true;
          }
        }
        return validador;
    }

    /***
     * Troca de linhas -> eliminação de Gauss na matriz TGn (transformar a matriz TGn em uma matriz triangular superior)
     * @param matriz
     */
    public static void trocaLinhas(Matriz matriz){
        int tam = 100;
        Matriz trocas = new Matriz(tam, tam);
        double vetor1[] = new double[tam];
        double vetor2[] = new double[tam];
        double  receber_linha;
        int n = matriz.n;
        int k = 0;
        double y = 1;
        double determinante = 1;
        

        for(int i = 0; i < n/2; i++){
            for(int j=0; j<2;j++){
                trocas.matriz[i][j] = k;
                k++;
            }
        }

        int i = 0;
        int j = 0;
        int l = 0; 
        int g = 0;
        int h = 0;

		while(i < n - 2){
			for(j = 0; j < n; j++){
				l=i;
				vetor1[j] = matriz.matriz[l][j];
				vetor2[j] = matriz.matriz[l+1][j];
		
			}
			for(g = 0; g < n; g++){
			    matriz.matriz[i][g] = vetor2[g];
			    matriz.matriz[i+1][g] = vetor1[g];
			}
			
			i=i+2;
		}

        i = 0;
        j = 0;
        l = 0; 
        g = 0;

        for(i=0; i<n; i++){
			for(j=0; j<n; j++){
				if(i==j){
					for(k=i+1; k<n; k++){
						while(matriz.matriz[k][j] != 0){
						    receber_linha = -matriz.matriz[k][j]/matriz.matriz[i][j];
						    h=0;
                            for(l=j; l<n; l++){
                                vetor1[h] = matriz.matriz[k][l]*receber_linha;
                                
                            }
						}
					}
				}
			}
		}

        //começar o escalonamento
		for(i=0; i<n; i++){
			for(j=i+1; j<n; j++){
				
				y = matriz.matriz[j][i]/matriz.matriz[i][i];
				if(matriz.matriz[j][i]!=0){
                    for(k=0; k<n; k++){
                        matriz.matriz[j][k] = matriz.matriz[j][k] - y*matriz.matriz[i][k];
                    }
				}
		    }
		}

		for(i=0; i<n; i++){
			for(j=0; j<n; j++){	
				if(i==j){
				determinante=determinante*matriz.matriz[i][j];
				}
			}
		}
        
        System.out.println("Determinante" + determinante);

    }
}
