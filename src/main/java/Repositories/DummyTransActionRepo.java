package Repositories;

import app.Product;
import app.Transaction;

import java.util.HashMap;

/**
 * Created by Sander on 22-9-2016.
 */
public class DummyTransActionRepo implements ITransactionRepo {

    static HashMap<String, Transaction> transactions = new HashMap<String, Transaction>();

    private static DummyTransActionRepo repo;

    public static DummyTransActionRepo getInstance() {
        if (repo == null) {
            repo = new DummyTransActionRepo();
        }
        return repo;
    }

    public Transaction getTransaction(String id) {
        return transactions.get(id);
    }

    public Transaction addProduct(Transaction transaction, Product product) {
        transaction.addProduct(product);
        return transaction;
    }

    public Transaction closeTransaction(Transaction transaction) {
        transaction.finishTransaction();
        return transaction;
    }
}
