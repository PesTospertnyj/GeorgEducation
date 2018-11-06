import jdk.nashorn.internal.objects.annotations.Property;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;

public class JDBCExample {

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://localhost:5432/company";
//        String user = "postgres";
//        String password = "admin";
//        Connection connection = DriverManager.getConnection(url, user, password);

//        String url = "jdbc:postgresql://localhost:5432/" +
//                "company?user=postgres&password=admin";
//        String user = "postgres";
//        String password = "admin";
        Properties properties = new Properties();
//        properties.setProperty("url","jdbc:postgresql://localhost:5432/company");
        properties.setProperty("user","postgres");
        properties.setProperty("password","admin");
        Connection connection = DriverManager.getConnection(url, properties);
        return connection;
    }


    public static void main(String[] args) {
        // creates the database
        try (Connection connection = getConnection()) {
            String query = "create table if not exists employees (" +
                    "id serial primary key," +
                    "name varchar(50) not null," +
                    "salary decimal," +
                    "birth_date timestamp)";
            Statement statement = connection.createStatement();
            int rValue = statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // inserts to database using createStatement
        try (Connection connection = getConnection()) {
            String query = "insert into employees (name,salary) values ('John',1000.10)";
            Statement statement = connection.createStatement();
            int rValue = statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    // inserts to database using preparedStatement
        try (Connection connection = getConnection()) {
            String query = "insert into employees (name,salary,birth_date) values (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Robert");
            preparedStatement.setDouble(2,2000.50);
            LocalDateTime localDateTime = LocalDate.of(1980,10,5).atStartOfDay();
            preparedStatement.setTimestamp(3,Timestamp.valueOf(localDateTime));
            preparedStatement.executeUpdate();

            preparedStatement.setString(1,"Ann");
            preparedStatement.setDouble(2,1500.50);
            localDateTime = LocalDate.of(1985,10,5).atStartOfDay();
            preparedStatement.setTimestamp(3,Timestamp.valueOf(localDateTime));
            preparedStatement.executeUpdate();


            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = getConnection()) {
            String query = "delete from employees where salary>?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1,1000);
//            boolean isResultSet = preparedStatement.execute();
//            if (!isResultSet) {
//                int updateCount = preparedStatement.getUpdateCount();
//                System.out.println(updateCount);
//            }


            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = getConnection()) {
            String query = "update employees set name='Mr.' || name";
            Statement statement = connection.createStatement();
            boolean isResultSet = statement.execute(query);
            if (!isResultSet) {
                int updateCount = statement.getUpdateCount();
                System.out.println(updateCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
    }

