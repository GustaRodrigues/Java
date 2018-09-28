package classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.Timer;

public class Principal extends JFrame {

	JLabel lblTitulo, lblData, lblHora;
	JButton botaoIniciarPartida, botaoSair, easteregg;
	DecimalFormat formato;
	
	JMenuBar mnBar;
	JMenu cadastros, mais;
	JMenuItem jmiJogador, jmiAssistente, jmiTime, jmiTorcedor, jmiRegras, jmiDb;
	public Principal(){
		super("Simulador de Partidas");
		Container tela = getContentPane();
		setLayout(null);
		
		lblData = new JLabel("");
		lblTitulo = new JLabel ("Simulador de Partidas");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		lblHora = new JLabel("");		
		
		
		///
		mnBar = new JMenuBar ();
		
		cadastros = new JMenu("Cadastrar");
		jmiJogador = new JMenuItem ("Jogador");
		jmiAssistente = new JMenuItem ("Assistente");
		jmiTime = new JMenuItem ("Time");
		jmiTorcedor = new JMenuItem ("Torcedor");
		
		mais = new JMenu("Mais");
		jmiRegras = new JMenuItem ("Sobre o aplicativo");
		jmiDb = new JMenuItem ("Informações");
		
		setJMenuBar(mnBar);
		mnBar.add(cadastros);
		mnBar.add(mais);
		
		cadastros.add(jmiJogador);
		cadastros.add(jmiAssistente);
		cadastros.add(jmiTime);
		cadastros.add(jmiTorcedor);
		
		mais.add(jmiRegras);
		mais.add(jmiDb);
		///
		
		botaoIniciarPartida = new JButton ("Iniciar Partida");
		botaoSair = new JButton ("Sair");
		
		lblTitulo.setBounds(320,10,300,20);
		lblHora.setBounds(20,410,200,20);
		lblData.setBounds(20,390,280,20);
		botaoIniciarPartida.setBounds(320, 290,150,30);
		botaoSair.setBounds(710, 410, 50, 25);
		botaoSair.setMargin(new Insets(1,1,1,1));
		
		lblData.setForeground(Color.WHITE);
		
		botaoIniciarPartida.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ea) {
						//botaoIniciarPartida app4 = new botaoIniciarPartida();
						//setVisible(false);
					}
				}
			);
		
		botaoSair.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						System.exit(0);
					}
				}
			);
		
			jmiJogador.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						CadJogador cdj = new CadJogador();
					}
				}
			);     
			
		
		jmiAssistente.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						Assistente assis = new Assistente();
					}
				}
			);
		
		jmiTime.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						Time tcd = new Time();
						
					}
				}
			);
		
		jmiTorcedor.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						Torcedor tcd = new Torcedor();
					}
				}
			);
		
		jmiRegras.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						Regras reg = new Regras();
					}
				}
			);
		
		jmiDb.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						ConsultarDatabase cdj = new ConsultarDatabase();
					}
				}
			);
		///
		tela.add(lblTitulo);
		tela.add(botaoIniciarPartida);
		tela.add(botaoSair);
		tela.add(lblData);
		tela.add(lblHora);
		///
		JDesktopPane desk = new JDesktopPane(){
	          Image im = (new ImageIcon("futebol.jpeg")).getImage(); 
	          public void paintComponent(Graphics g){        
	           g.drawImage(im,0,0,this);            }
	                                      };
	        tela.add(desk);
	        JLabel status = new JLabel();
	            status.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	            status.setBounds(1, 1, 852, 480);
	            status.setIcon(new ImageIcon("futebol.jpeg"));
	            tela.add(status);
	    ///        
		setSize(852, 520);
		setVisible(true);
		setLocationRelativeTo(null);
		//setResizable(false);
		
	}

	public static void main(String[] args) {
		Principal app = new Principal();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

	
