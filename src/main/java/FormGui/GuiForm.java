package FormGui;



import org.example.Aluno.DTOAluno;
import org.example.Tools;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class GuiForm extends JFrame {

    private JPanel Home;
    private JButton consultarButton;
    private JButton editarButton;
    private JButton inserirButton;
    private JPanel InserirTela;
    private JPanel ConsultarTela;
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

        voltarButton.addActionListener(v->{
            Tools.voltarInicioPara(contentPane,Home);
        });

        voltar2Button.addActionListener(v->{
            Tools.voltarInicioPara(contentPane,Home);
        });



        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
            int estado=0;
                DTOAluno aluno = new DTOAluno();
            String nome=textFieldNome.getText();
            int turma= Integer.parseInt(textFieldTurma.getText());
            int nota= Integer.parseInt(textFieldNota.getText());
                aluno.insert(nome, turma, nota);
                JOptionPane.showMessageDialog(null,"Dados inserido com sucesso");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"ERRO AO INSERIR DADOS " + ex.getMessage());
            }
            textFieldNome.setText("");
            textFieldTurma.setText("");
            textFieldNota.setText("");
            }
        });



        editarButton.addActionListener(v->{
            int column = TableConsult.getSelectedColumn();
            int row = TableConsult.getSelectedRow();
            String id = TableConsult.getValueAt(row,0).toString();
            String NomeAluno = TableConsult.getValueAt(row,1).toString();


            if(TableConsult.getColumnName(column).toString().equals("Estado") || TableConsult.getColumnName(column).toString().equals("ID")){
                JOptionPane.showMessageDialog(null,"Voce nao pode mudar esse campo");
            }else {

                if (JOptionPane.showConfirmDialog(null, "Deseja mesmo alterar a "
                        + TableConsult.getColumnName(column) + " do aluno " + NomeAluno + "?")
                        == JOptionPane.YES_OPTION) {

                    String novoDado = JOptionPane.showInputDialog("Digite o dado novo");
                    DTOAluno dtoAluno = new DTOAluno();
                    dtoAluno.updateDate(id, TableConsult.getColumnName(column), novoDado);
                }
            }
        });



    }


    private void setTabela(){

        DefaultTableModel defaultTableModel = new DefaultTableModel();
      defaultTableModel.addColumn("ID");
      defaultTableModel.addColumn("Nome");
      defaultTableModel.addColumn("Turma");
      defaultTableModel.addColumn("Nota");
      defaultTableModel.addColumn("Estado");

//

        DTOAluno dtoAluno = new DTOAluno();
        ResultSet resultSet = dtoAluno.selectDates();

      try{
          ResultSetMetaData metaData = resultSet.getMetaData();
          while(resultSet.next()){
              Object[] object = new Object[5];
              int cont=0;
                for(int i=1;i<=metaData.getColumnCount();i++){
                    object[cont]=resultSet.getString(i);
                    cont++;
                }

                if(object[4].equals("1")){
                    object[4]="Aprovado";
                }else{
                    object[4]="Reprovado";
                }
              defaultTableModel.addRow(object);
          }

      }catch (SQLException e){
          JOptionPane.showMessageDialog(null,"ERRO COM RESULT SET" + e.getMessage());
      }


        TableConsult.setModel(defaultTableModel);
    }




}
