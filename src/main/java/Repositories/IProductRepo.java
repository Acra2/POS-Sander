package Repositories;

import app.Product;

import java.util.List;

/**
 * Created by Sander on 22-9-2016.
 */
public interface IProductRepo {
    public List<Product> getProducts();

    public Product getProduct(String code);

    public void addProduct(Product product);

    public void deleteProduct(String code);
}
