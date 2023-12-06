package FormGui;

import org.example.Tools;

import javax.swing.*;
import java.awt.*;

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

            if(email.equals("tales@gmail.com") && senha.equals("123")){
                this.dispose();
                GuiForm guiForm = new GuiForm();
            }
            else{
                JOptionPane.showMessageDialog(null,"SENHA OU EMAIL INCORRETOS");
            }

        });


    }

}
