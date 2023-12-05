package org.example.Aluno;

import ConexaoBd.ConnectBD;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DTOAluno {

    public void insert(String nome,int turma,int nota){
        int  estado = 0 ;
        if(nota>=10) {
            estado = 1;
        }

        String sql = "INSERT INTO Aluno (nome,turma,nota,estado) VALUES" +
                "('"+nome+"','"+turma+"','"+nota+"','"+estado+"')";

        ConnectBD connectBD = new ConnectBD();
        Statement statement = connectBD.getStatement();

        try {
            statement.execute(sql);
            JOptionPane.showMessageDialog(null,"Dados inserido com Sucesso");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO AI INSERIR DADOS " + e.getMessage());
        }

    }


    public ResultSet selectDates(){
        ConnectBD connectBD = new ConnectBD();
        Statement statement = connectBD.getStatement();
        String sql = "SELECT * FROM Aluno";
        ResultSet resultSet=null;
        try {
             resultSet  = statement.executeQuery(sql);

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao fazer consulta de dados "
                    + e.getMessage() );
        }

        return resultSet;
    }

}
