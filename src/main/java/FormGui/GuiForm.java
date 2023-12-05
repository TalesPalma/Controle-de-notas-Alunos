package FormGui;



import org.example.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiForm extends JFrame {

    private JPanel Home;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton inserirButton;
    private JPanel InserirTela;
    private JPanel ConsultarTela;
    private JPanel EditarTela;
    private JButton voltarButton;
    private JButton voltar2Button;
    private JButton voltar3Button;

    ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(
            getClass().getResource("/Imagens/android.png"))
            .getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));

    public GuiForm() {
        Container contentPane = getContentPane();//Usando para passar para as funcoes tools
        Tools.setarFrame(this,Home);
        InserirTela.setVisible(false);
        ConsultarTela.setVisible(false);
        EditarTela.setVisible(false);




        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Tools.getTela(contentPane,InserirTela);
            }
        });

        consultarButton.addActionListener(v->{
            Tools.getTela(contentPane,ConsultarTela);

        });

        editarButton.addActionListener(v->{
            Tools.getTela(contentPane,EditarTela);

        });


        voltarButton.addActionListener(v->{
            Tools.voltarInicioPara(contentPane,Home);
        });

        voltar2Button.addActionListener(v->{
            Tools.voltarInicioPara(contentPane,Home);
        });

        voltar3Button.addActionListener(v->{
            Tools.voltarInicioPara(contentPane,Home);
        });
    }




}
