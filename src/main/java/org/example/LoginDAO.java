package org.example;

import ConexaoBd.ConnectBD;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginDAO {
    private String email , senha ;
    private int id ;


    public Map selectDate(){
        ConnectBD connectBD = new ConnectBD();
        Statement statement = connectBD.getStatement();
        ResultSet resultSet = null ;
        Map<String,String> map = new HashMap<>();
        String sql = "SELECT * FROM Login";
        try{
           resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Object[] objects = new Object[3];
                int cont=0;
                for(int i = 1 ; i<=3 ; i++){
                   objects[cont]=resultSet.getString(i);
                   cont++;
                }

                map.put(objects[1].toString(),objects[2].toString());
            }

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,
                    "Algum erro occoreu com o banco de dados"  + ex.getMessage());
        }


        return  map;
    }



}
