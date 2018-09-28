import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class botaoIniciarPartida extends JFrame {
	
	//ImageIcon iconeCli, iconeFor, iconeUsu, iconePro;
	JButton botaoSair,botaoVoltar;
	
	public botaoIniciarPartida(){
		super("Tela da Partida");
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
						System.exit(0);
					}
				}
				);
		

		botaoVoltar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InterfaceGrafica app2 = new InterfaceGrafica();
						app2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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