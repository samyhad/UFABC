import java.util.Scanner;


public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int linhas = 0;
        int colunas = linhas;
        
        int n = 7;
        int x = 0;
        
        System.out.println("Digite o número de linhas da matriz: ");
        linhas = n; //sc.nextInt();

        System.out.println("Digite o número de colunas da matriz: ");
        colunas = n; //sc.nextInt();
    
        
        Matriz matriz = new Matriz(linhas, colunas);
        int vetor[] = new int[linhas];

        matriz.gerarMatriz(matriz);
        matriz.mostrarMatriz(matriz);
        matriz.preencherTn(matriz, x);
        matriz.mostrarMatriz(matriz);

        
    }
}
