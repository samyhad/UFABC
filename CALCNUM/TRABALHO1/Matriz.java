import java.util.Scanner;

public class Matriz 
{
    public int linhas;
    public int colunas;
    private int matriz[][];

    public Matriz(int linhas, int colunas)
    {
        this.linhas = linhas;
        this.colunas= colunas;
        this.matriz = new int[this.linhas][this.colunas];
    }

    private Matriz inserir(Matriz matriz, int valor)
    {
        matriz.matriz[matriz.linhas][matriz.colunas] = valor;
        return matriz;
    }

    public Matriz gerarMatriz(Matriz matriz)
    {
        Scanner sc = new Scanner(System.in);
        for(int linha = 0; linha < matriz.linhas; linha = linha + 1)
        {
            for(int coluna = 0; coluna < matriz.colunas; coluna = coluna + 1)
            {
                matriz.matriz[linha][coluna] = sc.nextInt();
            }
        }

        return matriz;
    }

    public Matriz mostrarMatriz(Matriz matriz)
    {
        for(int linha = 0; linha < matriz.linhas; linha = linha + 1)
        {
            for(int coluna = 0; coluna < matriz.colunas; coluna = coluna + 1)
            {
                System.out.print("[" + matriz.matriz[linha][coluna] + "]");
            }
            System.out.print("\n");
        }
        return matriz;
    }

    public boolean encontrarValor(Matriz matriz, int valor)
    {
        int count = 0;
        for(int linha = 0; linha < matriz.linhas; linha = linha + 1)
        {
            for(int coluna = 0; coluna < matriz.colunas; coluna = coluna + 1)
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

    public int encontrarDeterminante(Matriz matriz)
    {
        return 0;
    }

    public int encontrarAutoValor(Matriz matriz)
    {
        return 0;
    }
}
