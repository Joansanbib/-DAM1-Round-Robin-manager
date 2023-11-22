import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner e=new Scanner (System.in);
		System.out.println("Quants procesos vols aplicar?");
		int valor1=e.nextInt(), cont=0, cont1=0, Q, valor2, valor3, var, C, J;
		double tempsespera=0, turn=0;
		char espera;
		
		if (valor1==0||valor1<0) {
			System.out.println("Prem 'Y' per a continuar amb un altre valor o 'N' per sortir");
			espera=e.next().charAt(0);
			
			switch (espera) {
				case 'Y':System.out.println("Entra de nou un valor"); valor1=e.nextInt();
				break;
				case 'y':System.out.println("Entra de nou un valor"); valor1=e.nextInt();
				break;
				case 'N': System.out.println("Has sortit del sistema");
				break;
				case 'n': System.out.println("Has sortit del sistema");
				break;
				default: System.out.println("Error");
				
			}
		}	int [] resultat_arribada=new int [valor1];
			int [] turnaround=new int [valor1];
			int [] proces=new int [valor1];
			int [] tf=new int [valor1];
			int [] arribada=new int [valor1];
			
			System.out.println("Defineix cada procés amb el seu temps");
			for (cont=0; valor1>cont; cont++) {
				 System.out.println("P"+(cont+1)+" :");
			     proces[cont]=e.nextInt();
			     arribada [cont]=proces[cont];
			     
			}System.out.println("Entra el tamany del quantum");
			Q=e.nextInt();
			valor2=Q;
			
			cont=0;
			while (proces[cont]!=0 || proces[cont]==0) {
														
				if (proces[cont]==Q) { 			
					if (arribada[cont]==proces[cont]) {
						resultat_arribada[cont]=cont1;
					}
					cont1=cont1+Q;
					proces[cont]=0;				
					tf[cont]=cont1;	
					cont++;
					if (cont==valor1) {
						cont=0;
						}
					if (proces[cont]==0){
						for (C=cont;valor1-1>C;C++) {
							cont++;
							if (cont==valor1) {
								break;
							}
							if (proces[cont]!=0) {
								break;
								
								}
							 }
						  }
					
						
						if (proces[cont]==0 && cont==valor1-1) {
							for (cont=-1;valor1-1>cont;cont++) {
								cont++;
								if (proces[cont]!=0) {
									break;
								}
							}
						}
						if (cont==valor1) {
							break;
						}
					}
														
				if (proces[cont]>Q) {  				
					if (arribada[cont]==proces[cont]) {
						resultat_arribada[cont]=cont1;
					}
					cont1=cont1+Q;	
					proces[cont]=proces[cont]-Q;	
					cont++;
					if (cont==valor1) {
						cont=0;
						}
					if (proces[cont]==0){
						for (C=cont;valor1-1>C;C++) {
							cont++;
							if (proces[cont]!=0) {
								break;
							}
						  } 
						
						if (proces[cont]==0 && cont==valor1-1) {
							for (cont=-1;valor1-1>cont;cont++) {
								cont++;
								if (proces[cont]!=0) {
									break;
								}
							}
						}
						if (cont==valor1) {
							break;
						}
					}
				}
				
				if (proces[cont]<Q && proces[cont]!=0) { 
				
					var=proces[cont];
					if (arribada[cont]==proces[cont]) {
						resultat_arribada[cont]=cont1;
					}
					proces[cont]=0;	
					cont1=cont1+var;
					tf[cont]=cont1;
					cont++;
					if (cont==valor1) {
						cont=0;
						}
					if (proces[cont]==0){
						for (C=cont;valor1-1>C;C++) {
							cont++;
							if (proces[cont]!=0) {
								break;
							}
						  } 
						
						if (proces[cont]==0 && cont==valor1-1) {
							for (cont=-1;valor1-1>cont;cont++) {
								cont++;
								if (proces[cont]!=0) {
									break;
								}
							}
						}
						if (cont==valor1) {
							break;
						}
					}
				}
				
				if (cont==valor1) {
					cont=0;
					}
				if (proces[cont]==0){
					for (C=cont;valor1-1>C;C++) {
						cont++;
						if (proces[cont]!=0) {
							break;
						}
					  } 
					
					if (proces[cont]==0 && cont==valor1-1) {
						for (cont=-1;valor1-1>cont;cont++) {
							cont++;
							if (proces[cont]!=0) {
								break;
							}
						}
					} 
				}
				
			}	
		
	
			int [] temps_espera=new int[valor1];
			for (cont=0; cont<valor1; cont++) {
				temps_espera[cont]=tf[cont]-proces[cont];
			}
			for (cont=0; cont<valor1; cont++) {
				turnaround[cont]=tf[cont]-resultat_arribada[cont];
			}
			for (cont=0; cont<valor1; cont++) {
				tempsespera=tempsespera+resultat_arribada[cont];
			}
			for (cont=0; cont<valor1; cont++) {
				turn=turn+turnaround[cont];
			}
			for (cont=0; cont<valor1; cont++) {			
				System.out.println("P"+(cont+1)+": .......... T.TOTAL: "+tf[cont]+" .......... T.ESPERA: "+resultat_arribada[cont]+" .......... T.AROUND: "+turnaround[cont]);
			}
				System.out.println("Mitjana del temps d'espera: "+tempsespera/valor1);
				System.out.println("Mitjana del turnaround: "+turn/valor1);
		
	}
}