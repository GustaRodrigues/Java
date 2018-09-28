package classes;

import javax.swing.*;
import javax.swing.text.*;

import repositorios.bean.BandeirinhaBean;
import repositorios.bean.GandulaBean;
import repositorios.bean.JuizBean;
import repositorios.dao.BandeirinhaDAO;
import repositorios.dao.GandulaDAO;
import repositorios.dao.JuizDAO;

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

			
		top = new JLabel("CADASTRO DE ASSISTENTE: ");
		nome = new JLabel("NOME DO ASSISTENTE: ");
		funcao = new JLabel("QUAL A FUNÇÃO:");
		
		sair = new JButton("Voltar");
		cadastrar = new JButton("Cadastrar");
		
		top.setFont(new Font("Arial", Font.BOLD, 20)); 
		nome.setFont(new Font("Arial", Font.BOLD, 14)); 
		funcao.setFont(new Font("Arial", Font.BOLD, 14)); 
		
		top.setForeground(Color.WHITE);
		nome.setForeground(Color.WHITE);
		funcao.setForeground(Color.WHITE);
			
		txtnome = new JTextField();

		list = new JComboBox();
				list.addItem("JUIZ");
				list.addItem("BANDEIRINHA");
				list.addItem("GANDULA");
				tela.add(list);
				list.setSelectedItem(null);	
				
		top.setBounds(150,1,300,50);
		nome.setBounds(20,65,200,50);
		funcao.setBounds(20,100,200,50);
		
		sair.setMargin(new Insets(1,1,1,1));
		sair.setBounds(270,190,100,25);
		
		cadastrar.setMargin(new Insets(1,1,1,1));
		cadastrar.setBounds(120,190,100,25);
		
		
		txtnome.setBounds(185,81,310,20);
		
		list.setBounds(150,115,180,20);		
		
		tela.add(top);
		tela.add(nome);
		tela.add(funcao);
		tela.add(txtnome);
		tela.add(sair);
		tela.add(cadastrar);
		
		sair.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
			
						setVisible(false);
					}
				}
			);
		
		cadastrar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						
						String x = list.getSelectedItem().toString();	
						//JOptionPane.showMessageDialog(null, "" + x);
						
						if(x == "BANDEIRINHA") {
							
							BandeirinhaBean bbean = new BandeirinhaBean();
							BandeirinhaDAO dao = new BandeirinhaDAO();
							
							bbean.setNmBandeirinha(txtnome.getText());
							
							dao.create(bbean);
							
							JOptionPane.showMessageDialog(null,"Bandeirinha cadastrado com sucesso!");
							
							txtnome.setText(null);
							list.setSelectedItem(null);
							
							x = null;
						}
						
						else if ( x == "JUIZ") {
							
							JuizBean jzb = new JuizBean();
							JuizDAO dao = new JuizDAO();
							
							jzb.setNmJuiz(txtnome.getText());
							dao.create(jzb);
							
							JOptionPane.showMessageDialog(null,"Juíz cadastrado com sucesso!");
							
							txtnome.setText(null);
							list.setSelectedItem(null);
							
							x = null;
						}
						
						else {
							
							GandulaBean gb = new GandulaBean();
							GandulaDAO	dao = new GandulaDAO();
							
							gb.setNmGandula(txtnome.getText());
							dao.create(gb);
							
							JOptionPane.showMessageDialog(null,"Gandula cadastrado com sucesso!");
							
							txtnome.setText(null);
							list.setSelectedItem(null);
						
							x = null;
						}
					}
				}
			);
		
			 JDesktopPane desk = new JDesktopPane(){
			 Image im = (new ImageIcon("arb5.jpg")).getImage(); 
			 public void paintComponent(Graphics g){        
			 g.drawImage(im,0,0,this);            }
					                                      };
			tela.add(desk);
		    JLabel status = new JLabel();
			status.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			status.setBounds(0, 0, 612, 408);
			status.setIcon(new ImageIcon("arb5.jpg"));
		    tela.add(status);   						
		
		setSize(550,320);
		setVisible(true);
		setLocationRelativeTo(null);
		//setResizable(false);

	} 
}	