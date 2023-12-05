package FormGui;



import org.example.Aluno.DTOAluno;
import org.example.Tools;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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
    private JTextField textFieldNome;
    private JLabel nomeText;
    private JLabel turmaText;
    private JLabel notaText;
    private JTextField textFieldTurma;
    private JTextField textFieldNota;
    private JButton salvarButton;
    private JTable TableConsult;


    public GuiForm() {
        Container contentPane = getContentPane();//Usando para passar para as funcoes tools
        Tools.setarFrame(this,Home);
        InserirTela.setVisible(false);
        ConsultarTela.setVisible(false);
        EditarTela.setVisible(false);
        setTabela();


        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Tools.getTela(contentPane,InserirTela);
            }
        });

        consultarButton.addActionListener(v->{
            Tools.getTela(contentPane,ConsultarTela);
            setTabela();

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

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int estado=0;
                DTOAluno aluno = new DTOAluno();
            String nome=textFieldNome.getText();
            int turma= Integer.parseInt(textFieldTurma.getText());
            int nota= Integer.parseInt(textFieldNota.getText());


            aluno.insert(nome,turma,nota);
            textFieldNome.setText("");
            textFieldTurma.setText("");
            textFieldNota.setText("");

            }
        });
    }


    private void setTabela(){

      DefaultTableModel defaultTableModel = new DefaultTableModel();
      defaultTableModel.addColumn("Nome");
      defaultTableModel.addColumn("Turma");
      defaultTableModel.addColumn("Nota");
      defaultTableModel.addColumn("Estado");

//        Object[] object = {"tales",20,1,false};
        TableConsult.setModel(defaultTableModel);




    }


}
