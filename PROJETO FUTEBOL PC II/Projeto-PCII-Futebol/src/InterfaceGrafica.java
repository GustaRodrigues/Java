import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.Timer;

public class InterfaceGrafica extends JFrame {
	
	//ImageIcon iconeCli, iconeFor, iconeUsu, iconePro;
	JLabel lblTitulo, lblData, lblHora;
	JButton botaoIniciarPartida, botaoSair, easteregg;
	int ds, dia, mes, ano, hh, mm, ss, h;
	Calendar data, hora;
	DecimalFormat formato;
	String diasemana[]= {
			"Domingo" , "Segunda-Feira" , "Terça-Feira" , "Quarta-Feira" , "Quinta-Feira" , "Sexta-Feira" , "Sábado"
	};
	String meses[]= {
		"Janeiro" , "Fevereiro" , "Março" , "Abril" , "Maio" , "Junho" , "Julho" , "Agosto" , "Setembro" , "Outubro" , "Novembro" , "Dezembro"	
	};
	JMenuBar mnBar;
	JMenu cadastros, mais;
	JMenuItem jmiJogador, jmiAssistente, jmiTime, jmiTorcedor, jmiRegras, jmiDb;
	public InterfaceGrafica(){
		super("Simulador de Partidas");
		Container tela = getContentPane();
		setLayout(null);

		/*iconeCli = new ImageIcon("cliente.png");
		iconeFor = new ImageIcon("fornecedor.png");
		iconeUsu = new ImageIcon("usuario.png");
		iconePro = new ImageIcon("produto.png");*/
		
		lblData = new JLabel("");
		lblTitulo = new JLabel ("Simulador de Partidas");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		lblHora = new JLabel("");		
		
		data = Calendar.getInstance();
		ds = data.get(Calendar.DAY_OF_WEEK);
		dia = data.get(Calendar.DAY_OF_MONTH);
		mes = data.get(Calendar.MONTH);
		ano = data.get(Calendar.YEAR);
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
		lblData.setText("Data: " +diasemana[ds-1] +", " +dia+" de " +meses[mes]+" de " +ano);
		
		botaoIniciarPartida = new JButton ("Iniciar Partida");
		botaoSair = new JButton ("Sair");
		
		lblTitulo.setBounds(320,10,300,20);
		lblHora.setBounds(20,410,200,20);
		lblData.setBounds(20,390,280,20);
		botaoIniciarPartida.setBounds(320, 290,150,30);
		botaoSair.setBounds(710, 410, 50, 25);
		botaoSair.setMargin(new Insets(1,1,1,1));
		
		lblData.setForeground(Color.WHITE);
		
		ActionListener tarefa = (new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				HORAS();
			}
		});
		javax.swing.Timer time = new javax.swing.Timer(1000, tarefa);
		time.start();
		
		botaoIniciarPartida.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ea) {
						botaoIniciarPartida app4 = new botaoIniciarPartida();
						setVisible(false);
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
						
					}
				}
			);
		
		jmiTime.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						
					}
				}
			);
		
		jmiTorcedor.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ed) {
						
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
		InterfaceGrafica app = new InterfaceGrafica();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void HORAS() {
		hora = Calendar.getInstance();
		hh = hora.get(Calendar.HOUR_OF_DAY);
		mm = hora.get(Calendar.MINUTE);
		ss = hora.get(Calendar.SECOND);
		formato = new DecimalFormat("00");
		lblHora.setText("Hora: " + formatar(hh%12) + ":" +formatar(mm)+":"+formatar(ss));
		lblHora.setForeground(Color.WHITE);
	}
	
	private String formatar(int num) {
		formato = new DecimalFormat("00");
		return formato.format(num);
	}
}
