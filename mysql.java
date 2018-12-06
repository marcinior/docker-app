import java.sql.*;
import java.util.Scanner;
import java.lang.Thread;
 
class MySql {
    public static void main(String args[]) {
 
        Statement statement;
        Connection connection = null;
 
        try {
            Thread.sleep(3000);
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://10.0.10.3:3306/myDB", "mbobel", "password");
 
            String createTable = "CREATE TABLE IF NOT EXISTS cars (brand VARCHAR(20), model VARCHAR(20), color VARCHAR(20))";
 
            statement = connection.createStatement();
            statement.executeUpdate(createTable);
         
            String insertQuery1 = "INSERT INTO cars VALUES('Seat', 'Leon','Red')";
            statement.executeUpdate(insertQuery1);
         
            String insertQuery2 = "INSERT INTO cars VALUES('Audi', 'A4','Black')";
            statement.executeUpdate(insertQuery2);
         
            String insertQuery3 = "INSERT INTO cars VALUES('Ford', 'Fiesta','Green')";
            statement.executeUpdate(insertQuery3);
 
            Scanner in = new Scanner(System.in);
 
            while (true) {
                System.out.println("\n--------------Add new car press 1, for display cars press 2--------------\n");
                String userChoice = in.nextLine();
 
                if (userChoice.equals("1")) {
                    System.out.print("Type car brand:\n");
                    String brand = in.nextLine();
                    System.out.print("Type car model:\n");
                    String model = in.nextLine();
                    System.out.print("Type car color:\n");
                    String color = in.nextLine();
 
                    statement = connection.createStatement();
 
                    String insertQuery = "INSERT INTO cars VALUES('" + brand + "', '" + model + "', '" + color + "')";
                    statement.executeUpdate(insertQuery);
                    System.out.println("Car successfully added to database\n");
                }
                else if (userChoice.equals("2")) {
                    statement = connection.createStatement();
                    String selectQuery = "SELECT * FROM cars";
                    ResultSet response = statement.executeQuery(selectQuery);
                    int i = 1;
                    System.out.print("Nr\t");
                    System.out.print("Brand\t");
                    System.out.print("Model\t");
                    System.out.print("Color\n");
 
                    while (response.next()) {
                        System.out.print(i + "\t");
                        System.out.print(response.getString("brand") + "\t");
                        System.out.print(response.getString("model") + "\t");
                        System.out.print(response.getString("color") + "\n");
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
