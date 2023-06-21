package database;
import java.sql.SQLException;

public class NoValueException extends Exception{
    NoValueException(String message, SQLException e){
        super(message, e);
    }
}
