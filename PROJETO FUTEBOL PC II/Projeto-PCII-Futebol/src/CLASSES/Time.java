package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import repositorios.bean.TimeCasa;
import repositorios.bean.TimeVisitante;
import repositorios.dao.TimeCasaDAO;
import repositorios.dao.TimeVisitanteDAO;

public class Time extends JFrame{
	
	JLabel lblTitulo, lblNomeTime, lblCidade;
	JTextField txtNome, txtCidade;
	JButton btnCadastrar, btnAtletas,btnVoltar;
	JRadioButton casa, visitante;
	
	public Time() {
		super("Cadastro de Times");
		Container tela = getContentPane();
		setLayout(null);
		
		lblTitulo = new JLabel ("--Cadastro de Times--");
		lblNomeTime = new JLabel ("Nome do Time:");
		lblCidade = new JLabel ("Cidade do Time:");
		
		txtNome = new JTextField (50);
		txtCidade = new JTextField (50);
		
		btnCadastrar = new JButton ("Cadastrar");
		btnAtletas = new JButton ("Cadastrar Jogador");
		btnVoltar = new JButton ("Voltar");
		
		casa = new JRadioButton("Casa");
		visitante = new JRadioButton("Visitante");
		
		lblTitulo.setFont(new Font("Arial",Font.BOLD,18));
		lblNomeTime.setFont(new Font("Arial",Font.BOLD,14));
		lblCidade.setFont(new Font("Arial",Font.BOLD,14));
		
		lblTitulo.setForeground(Color.WHITE);
		lblNomeTime.setForeground(Color.WHITE);
		lblCidade.setForeground(Color.WHITE);
		
		lblTitulo.setBounds(200,5,250,50);
		lblNomeTime.setBounds(30,70,150,20);
		lblCidade.setBounds(30,102,150,20);
		
		txtNome.setBounds(150,70,250,25);
		txtCidade.setBounds(150,100,250,25);
		
		btnCadastrar.setBounds(100,170,100,25);
		btnAtletas.setBounds(210,170,150,25);
		btnVoltar.setBounds(370,170,100,25);
		
		casa.setFont(new Font("Arial",Font.BOLD,14));
		visitante.setFont(new Font("Arial",Font.BOLD,14));
			
		casa.setBounds(20,130,70,20);
		visitante.setBounds(90,130,100,20);
		

		btnCadastrar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						
						if (casa.isSelected() && visitante.isSelected()) {
							
							JOptionPane.showMessageDialog(null, "Selecione apenas uma opção");
							
							casa.setSelected(false);
							visitante.setSelected(false);
						}
						else {
							
							if(casa.isSelected()) {
								
								TimeCasa tc = new TimeCasa();
								TimeCasaDAO dao = new TimeCasaDAO();
								
								tc.setNmTime(txtNome.getText());
								tc.setCidade(txtCidade.getText());
								dao.create(tc);
								
								JOptionPane.showMessageDialog(null, "Time da Casa cadastrado!");
								
								txtNome.setText(null);
								txtCidade.setText(null);
								casa.setSelected(false);
								visitante.setSelected(false);
							}
						
							else {
								
								TimeVisitante tv = new TimeVisitante();
								TimeVisitanteDAO dao = new TimeVisitanteDAO();
								
								tv.setNmTime(txtNome.getText());
								tv.setCidade(txtCidade.getText());
								dao.create(tv);
								
								JOptionPane.showMessageDialog(null,"Time Visitante cadastrado!");
					
								txtNome.setText(null);
								txtCidade.setText(null);
								casa.setSelected(false);
								visitante.setSelected(false);
							}
						}
					}
				}
			);
		
		btnAtletas.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
			
						CadJogador jogador = new CadJogador();
					}
				}
			);
		
		btnVoltar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				}
			);
		
		tela.add(lblTitulo);
		tela.add(lblNomeTime);
		tela.add(lblCidade);
		
		tela.add(txtNome);
		tela.add(txtCidade);
		
		tela.add(btnCadastrar);
		tela.add(btnAtletas);
		tela.add(btnVoltar);
		
		tela.add(casa);
		tela.add(visitante);
		
		JDesktopPane desk = new JDesktopPane(){
	          Image im = (new ImageIcon("tim.jpg")).getImage(); 
	          public void paintComponent(Graphics g){        
	           g.drawImage(im,0,0,this);            }
	                                      };
	        tela.add(desk);
	        JLabel status = new JLabel();
	            status.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	            status.setBounds(0, 0, 580, 250);
	            status.setIcon(new ImageIcon("tim.jpg"));
	            tela.add(status);
		
		setSize(580,270);
		setVisible(true);
		setLocationRelativeTo(null);
		//setResizable(false);
	}
	
}
