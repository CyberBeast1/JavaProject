/*
 * This file id for mysql connection...
 */
package testing;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author amritpal
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner reader = new Scanner(System.in);
        System.out.println("Hello, World!");
        String dbURL = "jdbc:mysql://localhost:3306/testing";
        String username ="root";
        String password = "abc";
        try {
            Connection dbCon = DriverManager.getConnection(dbURL, username, password);
            Statement stmt = dbCon.createStatement();
            PreparedStatement preparedStatement = null;
            int counter = 0;
            
            System.out.println("1 - Inserting data\n2 - Displaying data");
            System.out.print("Select number: ");
            int command = reader.nextInt();
            
            if(command == 1){
                // Inserting data into table
                preparedStatement = dbCon.prepareStatement("insert into dummy(name,age,class) values (?,?,?)");
                System.out.print("Enter how many times you want to INSERT data: ");
                counter = reader.nextInt();
                for (int i = 0; i < counter; i++) {
                    System.out.printf("-------Enter data for %d Person---------\n",i+1);
                    System.out.print("Enter name: ");
                    preparedStatement.setString(1, reader.next());

                    System.out.print("Enter your age: ");
                    preparedStatement.setInt(2, reader.nextInt());

                    System.out.print("Enter your class: ");
                    preparedStatement.setInt(3, reader.nextInt());

                    preparedStatement.executeUpdate();

                }
                
                System.out.println("Inserted data Successfully!");
            } else if(command == 2){
                // Displaying data from table
                String query ="select * from dummy";
                ResultSet rs = stmt.executeQuery(query);
                int columns = rs.getMetaData().getColumnCount();
                System.err.println("Column count : " + columns);
                System.out.println("-----------------Displaying Data--------------------");
                while(rs.next()){
                    for (int i = 1; i <= columns; i++) {
                        System.out.print(rs.getString(i));
                        System.out.print("|");
                    }
                    System.out.println();
                }
            } else{
                System.err.println("Invalid input TRY AGAIN!");
            }
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        reader.close();
    }
    
}
