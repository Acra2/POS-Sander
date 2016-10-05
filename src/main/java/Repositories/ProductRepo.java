package Repositories;

import app.Product;
import app.SingleProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sander on 3-10-2016.
 */
public class ProductRepo implements IProductRepo {

    private static ProductRepo repo;

    JdbcConnection jdbcConnection = new JdbcConnection();

    public static ProductRepo getInstance() {
        if (repo == null) {
            repo = new ProductRepo();
        }
        return repo;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        try {
            ResultSet resultSet = jdbcConnection.getResultSet("select * from PRODUCTS");
            while (resultSet.next()) {
                Product product = new SingleProduct(resultSet.getString("code"), resultSet.getString("name"), resultSet.getDouble("price"));
                products.add(product);
            }
            jdbcConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return products;
    }

    public Product getProduct(String code) {
        Product product = null;
        try {
            ResultSet resultSet = jdbcConnection.getResultSet("select * from PRODUCTS where code = "+code);
            while (resultSet.next()) {
                product = new SingleProduct(resultSet.getString("code"), resultSet.getString("name"), resultSet.getDouble("price"));

            }
            jdbcConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return product;
    }

    public void addProduct(Product product) {

    }

    public void deleteProduct(String code) {

    }
}
