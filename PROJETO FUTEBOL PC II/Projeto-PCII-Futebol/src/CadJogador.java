import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class CadJogador extends JFrame {
	
	//ImageIcon iconeCli, iconeFor, iconeUsu, iconePro;
	JLabel lblTitulo,lblNome,lblNasc,lblNatural,lblNacio,lblPosicao;
	JTextField txtNome,txtNasc,txtNatural,txtNacio;
	JButton botaoSair,botaoVoltar,botaoCadastrar;
	MaskFormatter mascaranasc;	
	
	public CadJogador(){
		super("Cadastro de Jogador");
		Container tela = getContentPane();
		setLayout(null);		
		
		lblTitulo = new JLabel ("Cadastro de Jogador");
		lblNome = new JLabel ("Nome:");
		lblNasc = new JLabel ("Nascimento:");
		lblNatural = new JLabel ("Natural De:");
		lblNacio = new JLabel ("Nacionalidade: ");
		lblPosicao = new JLabel ("Posição: ");
		
		txtNome = new JTextField ();
		txtNasc = new JTextField ();
		txtNatural = new JTextField ();
		txtNacio = new JTextField ();
		
		try {
			mascaranasc = new MaskFormatter("##/##/####");
			
			mascaranasc.setPlaceholderCharacter('_');
		
		}
		catch(ParseException excp) {
			
		}
		txtNasc = new JFormattedTextField(mascaranasc);
		
		
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		lblNome.setFont(new Font("Arial", Font.BOLD, 14)); 
		lblNasc.setFont(new Font("Arial", Font.BOLD, 14));
		lblNatural.setFont(new Font("Arial", Font.BOLD, 14));
		lblNacio.setFont(new Font("Arial", Font.BOLD, 14));
		lblPosicao.setFont(new Font("Arial", Font.BOLD, 14));
	
		botaoVoltar = new JButton ("Voltar");
		botaoSair = new JButton ("Sair");
		botaoCadastrar = new JButton ("Cadastrar");
		
		lblTitulo.setBounds(320, 10, 300, 20);
		lblNome.setBounds(30, 60, 300, 20);
		lblNasc.setBounds(30, 90, 300, 20);
		lblNatural.setBounds(30, 120, 300, 20);
		lblNacio.setBounds(30, 150, 300, 20);
		lblPosicao.setBounds(30, 180, 300, 20);
		
		txtNome.setBounds(90, 60, 300, 20);
		txtNasc.setBounds(130, 90, 70, 20);
		txtNatural.setBounds(120, 120, 300, 20); 
		txtNacio.setBounds(140, 150, 300, 20);
		
		botaoSair.setBounds(670, 370, 100, 25);
		botaoSair.setMargin(new Insets(1,1,1,1));
		
		botaoVoltar.setBounds(560, 370, 100, 25);
		botaoVoltar.setMargin(new Insets(1,1,1,1));
		
		botaoCadastrar.setBounds(450,370, 100, 25);
		botaoCadastrar.setMargin(new Insets(1,1,1,1));
		
		   JComboBox jagadores = new JComboBox();
		   jagadores.addItem("Batedor");
		   jagadores.addItem("Goleiro");
		   jagadores.setBounds(100, 180, 100, 20);
	       tela.add(jagadores);		
	
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
		
		tela.add(lblTitulo);
		tela.add(botaoSair);
		tela.add(botaoVoltar);
		tela.add(botaoCadastrar);
		
		tela.add(lblNome); 
		tela.add(lblNasc);
		tela.add(lblNatural); 
		tela.add(lblNacio);
		tela.add(lblPosicao);
		
		tela.add(txtNome);
		tela.add(txtNasc);
		tela.add(txtNatural);
		tela.add(txtNacio);	
		
		JDesktopPane desk = new JDesktopPane(){
	          Image im = (new ImageIcon("jogador.jpg")).getImage(); 
	          public void paintComponent(Graphics g){        
	           g.drawImage(im,0,0,this);            
	           }
	       };
	  
	     tela.add(desk);
	              JLabel status = new JLabel();
	              status.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	              status.setBounds(1, 1, 800, 590);
	              status.setIcon(new ImageIcon("jogador.jpg"));
	              tela.add(status);         

		setSize(800, 470);
		setVisible(true);
		setLocationRelativeTo(null);
		//setResizable(false);

	}

}
