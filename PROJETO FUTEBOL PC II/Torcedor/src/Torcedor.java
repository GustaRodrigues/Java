import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.awt.Window;
public class Torcedor extends JFrame{

     JLabel lblTitle, lblSubtitle, lblNome,lblNacionalidade, lblTime, lblIdade;
     JTextField txtNome,txtNacionalidade, txtTime, txtIdade;
     JButton btnSair, btnEnviar, btnLimpar;
     
     public Torcedor() {
        super("Cadastro de Torcedor");
        Container tela = getContentPane();
        setLayout(null);
        
        lblTitle = new JLabel ("Cadastro de Torcedor");   
        lblSubtitle = new JLabel ("Preencha os campos abaixo:");
        lblNome = new JLabel("Nome Completo:");
        lblNacionalidade = new JLabel("Nacionalidade:");
        lblTime = new JLabel("Qual Time Você Torce?");
        lblIdade = new JLabel ("Sua Idade:");
        
        txtNome = new JTextField(30);
        txtTime = new JTextField(15);
        txtNacionalidade = new JTextField(15);
        txtIdade = new JTextField(02);
        
        lblTitle.setBounds(90,20,450,30);
        lblTitle.setFont(new Font("Arial",Font.BOLD,30));
        lblTitle.setForeground(new Color(22, 20, 71));
        
        lblSubtitle.setBounds(110,60,320,30);
        lblSubtitle.setFont(new Font("Microsoft Sans Serif",Font.BOLD,18));
        lblSubtitle.setForeground(new Color(108, 0, 0));
        
        lblNome.setBounds(30, 110, 300, 30);
        lblNome.setFont(new Font("Arial",Font.BOLD,14));
        txtNome.setBounds(200, 110, 250, 25);
        //txtTime.setToolTipText("Digite o Seu Nome Completo");
        
        lblNacionalidade.setBounds(30, 150, 200, 30);
        lblNacionalidade.setFont(new Font("Arial",Font.BOLD,14));
        txtNacionalidade.setBounds(200, 150, 200, 25);
        //txtTime.setToolTipText("Digite a sua Nacionalidade");
        
        lblIdade.setBounds(30, 190, 100, 30);
        lblIdade.setFont(new Font("Arial",Font.BOLD,14));
        txtIdade.setBounds(200, 190, 50, 25);
        //txtTime.setToolTipText("Digite Sua Idade");
        
        
        lblTime.setBounds(30, 230, 200, 30);
        lblTime.setFont(new Font("Arial",Font.BOLD,14));
        txtTime.setBounds(200, 230, 150, 25);
        //txtTime.setToolTipText("Digite o Time que Você Torce");
        
        btnSair = new JButton("Sair");
        btnSair.setBounds(350, 270, 100, 40);
        btnSair.setFont(new Font("Arial", Font.BOLD, 16));
        btnSair.setBackground(new Color(255, 0, 0));
        btnSair.setForeground(new Color(247, 247, 247));
        btnSair.setVerticalTextPosition(SwingConstants.CENTER);
        btnSair.setHorizontalTextPosition(SwingConstants.LEFT);
        btnSair.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnSair.setToolTipText("Botão para Sair do Cadastro de Torcedor");
        
        btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(30, 270, 100, 40);
        btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEnviar.setBackground(new Color(255, 255, 255));
        btnEnviar.setForeground(new Color(0, 0, 0));
        //btnEnviar.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnEnviar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnEnviar.setToolTipText("Botão para Enviar suas Informações de Cadastro");
        
        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(190, 270, 100, 40);
        btnLimpar.setFont(new Font("Arial", Font.BOLD, 16));
        btnLimpar.setBackground(new Color(203, 235, 235));
        btnLimpar.setForeground(new Color(0, 0, 98));
        btnLimpar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnLimpar.setToolTipText("Botão para Limpar as Caixas de Texto");
        //(128,255,255)
        
         
        final JFrame window = this;
        
        
        
        btnSair.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcao;
                Object[] botoes = {"Sim", "Não", "Cancelar"};
                opcao = JOptionPane.showOptionDialog(null, "Deseja fechar o Cadastro?",
                        "Fechar o Cadastro", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, botoes[0]);
                if (opcao == JOptionPane.YES_OPTION) {
                    window.dispose();
                }
            }
        });
        
         btnLimpar.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNome.setText(null);
                txtTime.setText(null);
                txtIdade.setText(null);
                txtNacionalidade.setText(null);
            }
        }
        );
         
         btnSair.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                //só inserir aqui o código
                btnSair.setBackground(new Color(185, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //só inserir aqui o código
                btnSair.setBackground(new Color(255, 0, 0));
            }

        });

        btnLimpar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                //só inserir aqui o código
                btnLimpar.setBackground(new Color(89, 89, 255));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //só inserir aqui o código
                btnLimpar.setBackground(new Color(203, 235, 235));
            }

        });

        btnEnviar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                //cor que ficará quando o mouse estiver dentro do botão
                btnEnviar.setBackground(new Color(129, 241, 116));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //cor que ficará quando o mouse sair do botão
                btnEnviar.setBackground(new Color(255, 255, 255));
            }

        });
        
        btnEnviar.addActionListener(
                new ActionListener() {
                    public void actionPerformed (ActionEvent e) {
                        
                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
                    
                    txtNome.setText(null);
                    txtIdade.setText(null);
                    txtNacionalidade.setText(null);
                    txtTime.setText(null);
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
        
        tela.add(btnSair);
        tela.add(btnLimpar);
        tela.add(btnEnviar);
        
        setUndecorated(false);
        setSize(500, 360);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        Color minhaCor = new Color (255, 181 ,105);
        tela.setBackground(minhaCor);
        
    
     }
     
     
         
     public static void main(String[] args) {
        Torcedor app = new Torcedor();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
