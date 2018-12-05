import java.sql.*;
import java.util.Scanner;
 
class MySql {
    public static void main(String args[]) {
 
        Statement statement;
        Connection connection = null;
 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "mbobel", "password");
 
            String createTable = "CREATE TABLE IF NOT EXISTS cars (brand VARCHAR(20), model VARCHAR(20), color VARCHAR(20))";
 
            statement = connection.createStatement();
            statement.executeUpdate(createTable);
 
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
