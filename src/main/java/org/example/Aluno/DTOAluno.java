package org.example.Aluno;

import ConexaoBd.ConnectBD;

import javax.swing.*;
import java.sql.*;

public class DTOAluno {

    public void insert(String nome,int turma,int nota) throws SQLException{
        int  estado = 0 ;
        if(nota>=10) {
            estado = 1;
        }
        String sql = "INSERT INTO Aluno (nome,turma,nota,estado) VALUES" +
                "('"+nome+"','"+turma+"','"+nota+"','"+estado+"')";

        ConnectBD connectBD = new ConnectBD();
        Statement statement = connectBD.getStatement();
        statement.execute(sql);

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

    public void updateDate(String id,String column,String novoDado){

       String sql = "UPDATE Aluno set " + column + "='" + novoDado + "' WHERE id='" + id + "'";
       ConnectBD connectBD = new ConnectBD();
       Statement statement = connectBD.getStatement();

        if(column.equals("Nota")){
            int nota = Integer.parseInt(novoDado);
            int novoEstado = (nota>=10)?1:0;
            sql = "UPDATE Aluno set nota = '"+novoDado+"' , estado="+novoEstado+" WHERE id='"+id+"'";
        }

            try {
                statement.execute(sql);
                statement.close();
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, "Error " + e.getMessage());
            }





    }



}
