package app;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Created by Erik on 19-9-2016.
 */
public abstract class Transaction {
    @Setter
    @Getter
    protected String ID;
    protected ArrayList<Product> productsInTransaction;
    @Setter
    protected Card assignedCard;
    protected boolean inProgress;

    public Transaction() {
        this.productsInTransaction = new ArrayList<Product>();
        this.inProgress = true;
    }

    public void finishTransaction() {
        this.inProgress = false;
    }

    public void addProduct(Product product) {
        if (inProgress) {
            this.productsInTransaction.add(product);
        }
    }
}
