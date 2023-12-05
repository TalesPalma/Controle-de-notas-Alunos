package ConexaoBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBD {
    private Connection connection;
    private Statement statement ;
    public ConnectBD() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/meudb", "root", "");
            System.out.println("Connected sucefful");
            this.statement = this.connection.createStatement();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void closeDB(){
        try {
            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
