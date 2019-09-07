package calculator;
import java.util.Scanner;

public class InterfaceUsuario {

	public static void main(String[] args) {
		mostrarResultado(criarCalculo());
	}
	
	public static void testar() {
		Calculo c1 = new Calculo(9,'+',2);
		System.out.println(c1.processarCalculo());
	}
	
	public static Calculo criarCalculo() {
		
		double numero1;
	    double numero2;
	    char operacao;
	    
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite um número: ");
		numero1 = input.nextDouble();
		
		System.out.println("Digite a operação: ");
		operacao = input.next().charAt(0);
		
		System.out.println("Digite um número: ");
		numero2 = input.nextDouble();
		
		Calculo calc = new Calculo(numero1, operacao, numero2);
		
		return calc;
	}
	
	public static void mostrarResultado(Calculo umCalculo) {
		System.out.println("O resultado é: " + umCalculo.processarCalculo());
	}
	
}
