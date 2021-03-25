import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int linhas = 0;
        int colunas = 0;
        
        int n = 7;
        int x = 0;
        
        //System.out.println("Digite o número de linhas da matriz: ");
        //linhas = sc.nextInt();
        //System.out.println("Digite o número de colunas da matriz: ");
        //colunas = sc.nextInt();
        
        colunas = linhas = n;
        
        Matriz matriz = new Matriz(linhas, colunas);
        int vetor[] = new int[linhas];

        matriz.gerarMatriz(matriz);
        matriz.preencherTn(matriz, x);
        matriz.mostrarMatriz(matriz);

        //Matriz matriz_escalonada = matriz.eliminacaoDeGauss(matriz);
        //matriz_escalonada.mostrarMatriz(matriz_escalonada);
        //matriz.trocaLinhas(matriz);
        //matriz.encontrarDeterminante(matriz);
        

        
    }
}
