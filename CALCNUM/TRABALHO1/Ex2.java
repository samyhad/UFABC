/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliane.assis
 */


public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.util.Locale.setDefault(new java.util.Locale("en","US"));
		float x; 
                float n=0; 
                float e,i; 
               float vet_x[] = new float[100]; 
               double cont=0.0,matriz[][] = new double[100][100],y=0.0,vet_det[] = new double[100],cont_det=1.0000000;
		int j=0,l=0,m=0,k,g,h,a,b=0,c,d;
		String ver1,ver2;
		n = 11;
                
		for (i=0;i<3*n+1;i++){
			l = 0;
			cont_det  =  1.0;
			while (l<n){
				matriz[l][l+1]  =  -1.0;
				matriz[l+1][l]  =  -1.0;
				l = l+1;
			}
                        
                        e= 4/(3*n); 
			x=(-2+(e*i));
			vet_x[m]  =  x;
			m = m+1;
			for (h=0;h<n;h++){
				matriz[h][h]  =  x;
			}
                        
                        
			for (g=0;g<n;g++){
				for (j=g+1;j<n;j++){
					y =(matriz[j][g]/matriz[g][g]);
					if (matriz[j][g]!=0){
						for (k=0;k<n;k++){
							matriz[j][k] =( matriz[j][k]-y*matriz[g][k]);
						}
					}
				}
			}
			for (a=0;a<n;a++){
				cont_det =( cont_det*matriz[a][a]);
			}
			vet_det[b]  =  cont_det;
			b = b+1;
			for (c=0;c<n;c++){
				for (d=0;d<n;d++){
					matriz[c][d] = 0;
				}
			}
		}
		for (j=0;j<3*n+1;j++){
			if ((vet_det[j]>0 && vet_det[j+1]<0) || (vet_det[j]<0 && vet_det[j+1]>0)){
				System.out.print( "["+vet_x[j]+", "+vet_x[j+1]+"]"+"\n");
			}
		}
	}
}
        

