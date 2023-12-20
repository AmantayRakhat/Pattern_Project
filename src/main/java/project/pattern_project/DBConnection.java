package project.pattern_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Singleton
class DBConnection
{
    private static Connection conn;

    private DBConnection(){}

    public static Connection getConnection()
    {
        try
        {
            if(conn==null)
            {
                String url = "jdbc:postgresql://localhost:5432/PatternData";
                String username = "postgres";
                String password = "090804mk";
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, username, password);

            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return conn;
    }
  static List<Product> getProductsForComposite(int compositeProductId) {
        Connection conn=DBConnection.getConnection();
        List<Product> products = new ArrayList<>();

        try {
            String query = "SELECT p.id, p.name, p.price FROM products p JOIN composite_product_items cpi ON p.id = cpi.product_id WHERE cpi.composite_product_id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, compositeProductId);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                Product product = new ConcreteProduct(id, name, price);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

}