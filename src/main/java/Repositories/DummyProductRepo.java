package Repositories;

import app.Product;
import app.SingleProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sander on 22-9-2016.
 */
public class DummyProductRepo implements IProductRepo {
    static HashMap<String, Product> products = new HashMap<String, Product>();

    private static DummyProductRepo repo;

    public static DummyProductRepo getInstance() {
        if (repo == null) {
            repo = new DummyProductRepo();
            products.put("123", new SingleProduct("123", "Product 1", 10.50));
            products.put("456", new SingleProduct("456", "Product 2", 18.29));
        }
        return repo;
    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(products.values());
    }

    ;

    public Product getProduct(String code) {

        return products.get(code);
    }

    ;

    public void addProduct(Product product) {

        products.put(product.getCode(), product);
    }

    public void deleteProduct(String code) {
        products.remove(code);
    }
}
