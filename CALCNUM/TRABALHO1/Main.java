import java.util.Scanner;


public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int linhas = 0;
        int colunas = linhas;        
        
        System.out.println("Digite o número de linhas da matriz: ");
        linhas = 11; //sc.nextInt();

        System.out.println("Digite o número de colunas da matriz: ");
        colunas = 11; //sc.nextInt();
    
        
        Matriz matriz = new Matriz(linhas, colunas);
        int vetor[] = new int[linhas];

        matriz.gerarMatriz(matriz);
        matriz.mostrarMatriz(matriz);
        
    }
}
