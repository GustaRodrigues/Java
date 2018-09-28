package classes;
import java.util.Random;
public class Partida {

	public static void main(String args[])
	{
	    Random radom  = new Random();
	    int numeroTmp = 0;
	    for(int i=0;i<1; i++) {
	        numeroTmp=radom.nextInt(5);
	        System.out.println(">"+numeroTmp);
	        
	        if(numeroTmp == 1) {
	        	System.out.println("Bola não entrou");
	        	 int numero = 0;
	     	    for(int j=0;j<1; j++) {
	     	        numero=radom.nextInt(4);
	     	        System.out.println(">"+numero);
	     	        
	     	        if(numero == 1 ) {
	     	        	System.out.println("Goleiro Defendeu");
	     	        	}
	     	        
	     	       if(numero == 2 ) {
	     	    	  System.out.println("Bola na Trave");
    	        	}
	     	       
	     	      if(numero == 3 ) {
	     	  
	     	    	 System.out.println("Bola pra fora");
   	        	}
	     	      
	     	   
	     	    }     	
	        }
	        
	        if(numeroTmp == 2) {
	        	System.out.println("Gandula Invade campo");
	        }
	        
	        if(numeroTmp == 3) {
	        	System.out.println("Goleiro Adiantou");
	        }
	        
	        if(numeroTmp == 4) {
	        	System.out.println("Batedor acertou");
	        }
	    }
	}
	
}
