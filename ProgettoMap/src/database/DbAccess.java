package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAccess {
    private String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private final String DBMS = "jdbc:mysql";
    private final String SERVER = "localhost";
    private final String DATABASE = "MapDB";
    private final String PORT= "3306";
    private final String USER_ID = "MapUser";
    private final String PASSWORD = "map";
    private Connection conn;

    public void initConnection() throws DatabaseConnectionException{
        try{
            Class.forName(DRIVER_CLASS_NAME);
            String url = DBMS+"://"+SERVER+":"+PORT+"/"+DATABASE;
            conn = DriverManager.getConnection(url, USER_ID, PASSWORD);
            closeConnection();
        } catch(ClassNotFoundException e){
            throw new DatabaseConnectionException("Driver non trovato", e);
        } catch(SQLException e){
            throw new DatabaseConnectionException("Database non trovato", e);
        }
    }

    public Connection getConnection(){
        return conn;
    }
    public void closeConnection(){
        try{
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
