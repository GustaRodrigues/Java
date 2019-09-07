package calculator;

public class Calculo {
	public double numero1;
    public double numero2;
    public char operacao;
    
    public Calculo(){}
    
    public Calculo(double numero1, char operacao, double numero2){
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacao = operacao;
        
    }
    
    private double somar(){
        return this.numero1 + this.numero2;
    }
    
    private double subtrair(){
        return this.numero1 - this.numero2;
    }
    
    private double multiplicar(){
        return this.numero1 * this.numero2;
    }
    
    private double dividir(){
        return this.numero1 / this.numero2;
    }
    
    private double calcularPotencia(){
        return Math.pow(this.numero1,this.numero2);
    }
    
    private double calcularRaiz(){
        return Math.pow(this.numero1, 1/(this.numero2));
    }
    
    public double processarCalculo(){
        
        switch(this.operacao){
            
            case '+': 
                return somar();
                
            case '-': 
                return subtrair();
                
            case '*': 
                return multiplicar();
                
            case '/': 
                return dividir();
                
            case '^':
                return calcularPotencia();
                
            case 'r': 
                return calcularRaiz();
        }
		return processarCalculo();
    }
}
