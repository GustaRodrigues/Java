import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Arrays;


public class Assistente  extends JFrame {
	
	JLabel  top,nome,funcao;
	JTextField txtnome;
	JButton sair,cadastrar;
	
	JComboBox list;
	
	public Assistente () {
		super("CADASTRO DE ASSISTENTE");
		Container tela = getContentPane();
		setLayout(null);

		
	top = new JLabel("CADASTRO DE ASSISTENTE");
	nome = new JLabel("NOME DO ASSISTENTE");
	funcao = new JLabel("QUAL A FUNÇÃO DO ASSISTENTE");
	sair = new JButton("SAIR");
	cadastrar = new JButton("cadastrar");
	
	
	txtnome = new JTextField();
	
	
	
	list = new JComboBox();
			list.addItem("JUIZ");
			list.addItem("BANDERINHA");
			list.addItem("GANDULA");
			tela.add(list);
			
	top.setBounds(170,1,200,50);
	nome.setBounds(10,65,140,50);
	funcao.setBounds(10,100,200,50);
	sair.setBounds(120,160,100,30);
	cadastrar.setBounds(240,160,100,30);
	
	
	txtnome.setBounds(150,81,310,20);
	
	list.setBounds(220,115,240,20);		
	
	
					tela.add(top);
					tela.add(nome);
					tela.add(funcao);
					tela.add(txtnome);
					tela.add(sair);
					tela.add(cadastrar);
					
	
	setSize(500,270);
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);

	} 
	
	public static void main(String[] args) {
		Assistente app = new Assistente ();
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	