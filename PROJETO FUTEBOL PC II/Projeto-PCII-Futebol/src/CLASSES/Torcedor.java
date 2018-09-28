package classes;

	import javax.swing.*;
	import javax.swing.text.*;

import repositorios.bean.TorcedorEducado;
import repositorios.bean.TorcedorMauEducado;
import repositorios.dao.TorcedorEducadoDAO;
import repositorios.dao.TorcedorMauEducadoDAO;

import java.awt.*;
	import java.awt.event.*;
	import java.text.*;
	public class Torcedor extends JFrame{

	     JLabel lblTitle, lblSubtitle, lblNome,lblNacionalidade, lblTime, lblIdade;
	     JTextField txtNome,txtNacionalidade, txtTime;
	     JButton btnSair, btnEnviar, btnLimpar;
	     JRadioButton educado, maueducado;
	     JFormattedTextField txtIdade;
	     MaskFormatter dt;
	     
	     public Torcedor() {
	        super("Cadastro de Torcedor");
	        Container tela = getContentPane();
	        setLayout(null);
	        
	        lblTitle = new JLabel ("Cadastro de Torcedor");   
	        lblSubtitle = new JLabel ("Tipo:");
	        lblNome = new JLabel("Nome Completo:");
	        lblNacionalidade = new JLabel("Nacionalidade:");
	        lblTime = new JLabel("Qual Time Você Torce?");
	        lblIdade = new JLabel ("Sua Idade:");
	        
	        educado = new JRadioButton("Educado");
	        maueducado = new JRadioButton("Mau Educado");
	        
	        educado.setBounds(90,75,90,20);
	        maueducado.setBounds(180,75,120,20);
	        
	        txtNome = new JTextField(30);
	        txtTime = new JTextField(15);
	        txtNacionalidade = new JTextField(15);
	        
	        try {
	        	dt = new MaskFormatter("##/##/####");
	 			
	 			dt.setPlaceholderCharacter('_');
	 		
	 		}
	 		catch(ParseException excp) {}
	        
	        txtIdade = new JFormattedTextField(dt);
	        
	        lblTitle.setBounds(110,20,450,30);
	        lblTitle.setFont(new Font("Arial",Font.BOLD,30));
	        lblTitle.setForeground(Color.WHITE);

	        lblSubtitle.setBounds(30,70,320,30);
	        lblSubtitle.setFont(new Font("Arial",Font.BOLD,14));
	        lblSubtitle.setForeground(Color.WHITE);
	      
	        
	        lblNome.setBounds(30, 110, 300, 30);
	        lblNome.setFont(new Font("Arial",Font.BOLD,14));
	        lblNome.setForeground(Color.WHITE);
	        txtNome.setBounds(200, 110, 250, 25);
	        //txtTime.setToolTipText("Digite o Seu Nome Completo");
	        
	        lblNacionalidade.setBounds(30, 150, 200, 30);
	        lblNacionalidade.setFont(new Font("Arial",Font.BOLD,14));
	        lblNacionalidade.setForeground(Color.WHITE);
	        txtNacionalidade.setBounds(200, 150, 200, 25);
	        //txtTime.setToolTipText("Digite a sua Nacionalidade");
	        
	        lblIdade.setBounds(30, 190, 100, 30);
	        lblIdade.setFont(new Font("Arial",Font.BOLD,14));
	        lblIdade.setForeground(Color.WHITE);
	        txtIdade.setBounds(200, 190, 70, 25);
	        //txtTime.setToolTipText("Digite Sua Idade");
	        
	        
	        lblTime.setBounds(30, 230, 200, 30);
	        lblTime.setFont(new Font("Arial",Font.BOLD,14));
	        lblTime.setForeground(Color.WHITE);
	        txtTime.setBounds(200, 230, 150, 25);
	        //txtTime.setToolTipText("Digite o Time que Você Torce");
	        
	        
	        btnSair = new JButton("Voltar");
	        btnSair.setBounds(350, 270, 100, 25);
	        //btnSair.setFont(new Font("Arial", Font.BOLD, 16));
	        
	        btnSair.setToolTipText("Voltar");
	        
	        btnEnviar = new JButton("Cadastrar");
	        btnEnviar.setBounds(30, 270, 100, 25);
	        //btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
	       
	        btnEnviar.setToolTipText("Cadastrar informações");
	        
	        btnLimpar = new JButton("Limpar");
	        btnLimpar.setBounds(190, 270, 100, 25);
	        //btnLimpar.setFont(new Font("Arial", Font.BOLD, 16));
	        
	        btnLimpar.setToolTipText("Limpar caixas de texto");
	        //(128,255,255)
	        
	         
	        final JFrame window = this;
	        
	        btnSair.addActionListener(
	                new ActionListener() {
	                	public void actionPerformed(ActionEvent e) {
	                		
	                		setVisible(false);
	                }
	            }
	        );
	        
	         btnLimpar.addActionListener(
	                new ActionListener() {
	                	public void actionPerformed(ActionEvent e) {
		                
	                		txtNome.setText(null);
			                txtTime.setText(null);
			                txtIdade.setText(null);
			                txtNacionalidade.setText(null);
		                    educado.setSelected(false);
		                    maueducado.setSelected(false);
	               	}
	            }
	        );
	         
	         
	        btnEnviar.addActionListener(
	                new ActionListener() {
	                    public void actionPerformed (ActionEvent e) {
	                    
	                    	if (educado.isSelected() && maueducado.isSelected()) {
								
								JOptionPane.showMessageDialog(null, "Selecione só um, seu otário");
								
								educado.setSelected(false);
								maueducado.setSelected(false);
							}   
	                    	else {
	                    		
	                    		if(educado.isSelected()) {
	                    			
	                    			TorcedorEducado te = new TorcedorEducado();
	                    			TorcedorEducadoDAO dao = new TorcedorEducadoDAO();
	                    			
	                    			te.setIdTime(Integer.parseInt(txtTime.getText()));
	                    			te.setNmTorcedor(txtNome.getText());
	                    			te.setNacionalidade(txtNacionalidade.getText());
	                    			te.setDtNascimento(txtIdade.getText());
	                    			dao.create(te);	                    	
	                    			
	                    			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
	                    			
	                    			txtNome.setText(null);
	                    			txtIdade.setText(null);
	                    			txtNacionalidade.setText(null);
	                    			txtTime.setText(null);
	                    			educado.setSelected(false);
	                    			maueducado.setSelected(false);
	                    		}
	                    		else {
	                    			
	                    			TorcedorMauEducado tme = new TorcedorMauEducado();
	                    			TorcedorMauEducadoDAO dao = new TorcedorMauEducadoDAO();
	                    			
	                    			tme.setIdTime(Integer.parseInt(txtTime.getText()));
	                    			tme.setNmTorcedor(txtNome.getText());
	                    			tme.setNacionalidade(txtNacionalidade.getText());
	                    			tme.setDtNascimento(txtIdade.getText());
	                    			dao.create(tme);
	                    			
	                    			JOptionPane.showMessageDialog(null, "Torcedor Cadastrado com Sucesso!");
	                    			
	                    			txtNome.setText(null);
	                    			txtIdade.setText(null);
	                    			txtNacionalidade.setText(null);
	                    			txtTime.setText(null);
	                    			educado.setSelected(false);
	                    			maueducado.setSelected(false);
	                    		}
	                    	}	
	                    }
	                }
	        );
	        
	        tela.add(lblTitle);
	        tela.add(lblSubtitle);
	        tela.add(lblNome);
	        tela.add(txtNome);
	        tela.add(lblNacionalidade);
	        tela.add(txtNacionalidade);
	        tela.add(lblTime);
	        tela.add(txtTime);
	        tela.add(lblIdade);
	        tela.add(txtIdade);
	        
	        tela.add(educado);
	        tela.add(maueducado);
	        
	        tela.add(btnSair);
	        tela.add(btnLimpar);
	        tela.add(btnEnviar);
	        
	        
	        
	        JDesktopPane desk = new JDesktopPane(){
		          Image im = (new ImageIcon("tor.jpg")).getImage(); 
		          public void paintComponent(Graphics g){        
		           g.drawImage(im,0,0,this);            }
		                                      };
		        tela.add(desk);
		        JLabel status = new JLabel();
		            status.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		            status.setBounds(0, 0, 600, 330);
		            status.setIcon(new ImageIcon("tor.jpg"));
		            tela.add(status); 
	        
	      
	        setSize(550, 360);
	        setUndecorated(false);
	        setVisible(true);
	        setLocationRelativeTo(null);
	        //setResizable(false);

	     }
	     public static void main (String[]args) {
	    	 
	    	 Torcedor tc = new Torcedor();
	    	 tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     }
}