package FormGui;

import org.example.Aluno.DTOAluno;
import org.example.LoginDAO;
import org.example.Tools;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class LoginGui extends JFrame{
    private JPanel Main;
    private JButton entrarButton;
    private JTextField emailtextField;
    private JTextField senhatextField2;

    public LoginGui(){
        this.add(Main);
        this.setSize(300,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        entrarButton.addActionListener(v->{
            String email = emailtextField.getText().toString().trim();
            String senha = senhatextField2.getText().toString().trim();
            LoginDAO loginDAO = new LoginDAO();
            Map<String,String> mapLogin= loginDAO.selectDate();

            try {
                if (mapLogin.get(email).toString().equals(senha)) {
                    this.dispose();
                    GuiForm guiForm = new GuiForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Senha ou email invalido");
                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Digite algo nos campos por favor");
            }

        });


    }

}
