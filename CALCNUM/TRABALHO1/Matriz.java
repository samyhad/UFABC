import java.util.Scanner;


public class Matriz 
{
    public int n;
    private float matriz[][];

    public Matriz(int linhas, int colunas)
    {
        this.n = n;
        this.matriz = new float[this.n][this.n];
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
        
        int n = matriz.linhas;

        for(int i = 0; i < n; i++){
            if(i < n-1){
                matriz.matriz[i][i+1] = -1;
                matriz.matriz[i+1][i] = -1;
            }
            
            matriz.matriz[i][i] = lambda;
            
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

    public Matriz eliminacaoDeGauss(Matriz matriz){

        int n = matriz.n;
        float m;
        float temp;
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

        return matriz;
    }

    public void encontrarDeterminante(Matriz matriz)
    {

        int n = matriz.n;
        int sgn = 1;
        int count = 0;
        float determinante = 1;
        boolean validator = false;

        for(int j = 0; j < n-1; j++){
            count = j;

            while(matriz.matriz[count][j] == 0){
                count = count +1;
                sgn = -sgn;
            }
            if(count > n){
                System.out.println("Erro -> Sistema singular");
            
            }else{
                float[] temp = matriz.matriz[j];
                matriz.matriz[j] = matriz.matriz[count];
                matriz.matriz[count] = temp;
            }

            float m;

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
        System.out.println(determinante);
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
        float vetor1[] = new float[tam];
        float vetor2[] = new float[tam];
        float  receber_linha;
        int n = matriz.n;
        int k = 0;
        float y = 1;
        float determinante = 1;
        

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
        
        System.out.println(determinante);

    }
}
