// ### Programa JAVA gerado por PortuJava --> ## Versao 2.4 - 29/03/2019 - 19h13##

//Incluindo Bibliotecas Java (fun��es utilizadas no programa) --
import java.lang.Math;

public class 2.1.8 {
	//Declarando 'fora do main' para que possa ser acessado em outro m�dulos 
	public static void main(String[] args) {
	//A instru��o abaixo obriga o programa a rodar com configura��o de PONTO DECIMAL
	java.util.Locale.setDefault(new java.util.Locale("en","US"));
		//O vetor w abriga os valores dos coeficientes W.;
		//Manter os valores em vetor facilita no somatório;
		double w[] = new double[]={;
			41.0/140.0, 54.0/35.0, 27.0/140.0, 68.0/35.0 , 27.0/140.0, 54.0/35.0, 41.0/140.0} f=0.0, x=0.0, b=1.0, m=12.0, i=0.0;
			double soma=0.0,vetor_x[] = new double[15],vetor_funcao[] = new double[15],aprox=0.0,multiw=0.0,erro=0.0;
			int a=0,j=0,c=0;
			//Calcula valores de x para aplicar na função;
			for (i=0.0;i<15.0;i++){
				x = i*( b/m);
				if (i>6){
					x= ( i-1)* ( b/m);
				}
				if (i==0 || i==6 || i==7){
					x = 0.0;
				}
				vetor_x[j]  =  x;
				j = j+1;
			}
			//Calcula a função;
			for (j=0;j<15;j++){
				vetor_funcao[j] = Math.pow( vetor_x[j], 9.0);
			}
			//Calcula a soma de todos os valores;
			c = 0;
			for (j=0;j<14;j++){
				if (c>6){
					c = 0;
				}
				multiw  =  w[c]*vetor_funcao[j];
				soma  =  soma+multiw;
				c = c+1;
			}
			aprox = ( b/m)*soma;
			erro = Math.round( 0.1-aprox, 4);
			System.out.print( aprox+" ± "+erro);
		}
	}

//Aten��o: Este conversor est� sujeito a erros dependendo do arquivo de origem (.por)
//   (a) Abra seu arquivo em um editor Java e verifique se h� erros
//   (b) use as teclas ALT+SHIFT+F para fazer o alinhamento (endenta��o) do programa gerado
