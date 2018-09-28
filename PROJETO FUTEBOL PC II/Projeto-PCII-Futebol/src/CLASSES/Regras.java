package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Regras extends JFrame {
	
	//ImageIcon iconeCli, iconeFor, iconeUsu, iconePro;
	JButton botaoSair,botaoVoltar;
	
	public Regras(){
		super("Regras do Simulador de Partida");
		Container tela = getContentPane();
		setLayout(null);
			
		botaoVoltar = new JButton ("Voltar");
		botaoSair = new JButton ("Sair");
		
		botaoSair.setBounds(670, 370, 100, 25);
		botaoSair.setMargin(new Insets(1,1,1,1));
		
		botaoVoltar.setBounds(560, 370, 100, 25);
		botaoVoltar.setMargin(new Insets(1,1,1,1));
		
		
	
		botaoSair.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						
						setVisible(false);
					}
				}
				);
		

		botaoVoltar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				}
			);
		
		tela.add(botaoSair);
		tela.add(botaoVoltar);	
		
		setSize(800, 470);
		setVisible(true);
		setLocationRelativeTo(null);
		//setResizable(false);

	}

}