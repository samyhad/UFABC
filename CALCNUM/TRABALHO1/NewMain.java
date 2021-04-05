import java.util.Scanner; 
public class NewMain {

    public static void main(String[] args) {
        
       Scanner entrada = new Scanner(System.in); 
       
       float prec =(float) 0.00001;
       float x;  
       float n=11; 
       float e,i; 
       float vet_x[] = new float[100]; 
       double cont=0.0,matriz[][] = new double[100][100],y=0.0,vet_det[] = new double[100]; 
       double det1=1.0000000;
       double det2=1.0000000;
       double det4=1.0000000;
       double det3=1.0000000;
       int j=0,l=0,m=0,k,g,h,a,b=0,c,d;
        String ver1,ver2;
         int contador; 
       
       for (contador=11; contador>0;contador--) {
        double alfa;  
        
        System.out.println("Digite m");
        float inicio = entrada.nextFloat(); 
        System.out.println("digite M");
        float M = entrada.nextFloat(); 
        alfa=(inicio+M)/2;
        
        
        
        for (i=0;i<3*n+1;i++){
			l = 0;
			det1  =  1.0;
			while (l<n){
				matriz[l][l+1]  =  -1.0;
				matriz[l+1][l]  =  -1.0;
				l = l+1;
			}
                }
                        x= (float) (alfa-prec);
			vet_x[m]  =  x;
                        m++; 
		
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
				det1 =( det1*matriz[a][a]);
			}
                        
               
                    for (i=0;i<3*n+1;i++){
			l = 0;
			det2  =  1.0;
			while (l<n){
				matriz[l][l+1]  =  -1.0;
				matriz[l+1][l]  =  -1.0;
				l = l+1;
			}
                }
                        
			x= (float) (alfa+prec);
			vet_x[m]  =  x;
                        m++; 
			
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
				det2 =(det2*matriz[a][a]);
			}
                        
                     
                         m=0; 
                   
                        double mult= det1*det2; 
                        
                       while (mult>0) {
                   
                        alfa=(M+inicio)/2; 
                        m=0; 
                     
                        for (i=0;i<3*n+1;i++){
			l = 0;
			det3  =  1.0;
			while (l<n){
				matriz[l][l+1]  =  -1.0;
				matriz[l+1][l]  =  -1.0;
				l = l+1;
			}
                }
                        
                        x = (float) alfa;
			vet_x[m]  =  x;
                        m++; 
		
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
				det3 =( det3*matriz[a][a]);
			}
                        
                      
                        m=0;
                 
            
		for (i=0;i<3*n+1;i++){
			l = 0;
			det4  =  1.0;
			while (l<n){
				matriz[l][l+1]  =  -1.0;
				matriz[l+1][l]  =  -1.0;
				l = l+1;
			}
                }
                    
			x= (float) inicio;
			vet_x[m]  =  x;
                        m++; 
			
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
				det4 =( det4*matriz[a][a]);
			}
               
                        m=0; 
                        
            if (det3*det4<0) {
                M=(float) alfa; 
            }
            else if (det3*det4>0) {
                inicio=(float) alfa; 
            }
            else if (det3*det4==0) {
             
            }

             m=0; 
     
        
        for (i=0;i<3*n+1;i++){
			l = 0;
			det1  =  1.0;
			while (l<n){
				matriz[l][l+1]  =  -1.0;
				matriz[l+1][l]  =  -1.0;
				l = l+1;
			}
                }
                    
			x= (float) (alfa-prec);
			vet_x[m]  =  x;
                        m++; 
		
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
				det1 =( det1*matriz[a][a]);
			}
                   
                        m=0; 
                        
              
                    
                    for (i=0;i<3*n+1;i++){
			l = 0;
			det2  =  1.0;
			while (l<n){
				matriz[l][l+1]  =  -1.0;
				matriz[l+1][l]  =  -1.0;
				l = l+1;
			}
                }
                        
			x= (float) (alfa+prec);
			vet_x[m]  =  x;
                        m++; 
			
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
				det2 =(det2*matriz[a][a]);
			}
                        
                         m=0; 
                         
                         mult= det1*det2; 
                       
               }
                 System.out.println("A raiz é: "+alfa);
              
         }
    }
}