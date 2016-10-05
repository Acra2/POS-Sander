package Repositories;

import app.Product;
import app.Transaction;

/**
 * Created by Sander on 22-9-2016.
 */
public interface ITransactionRepo {
    Transaction getTransaction(String code);

    Transaction addProduct(Transaction transaction, Product product);

    Transaction closeTransaction(Transaction transaction);
}
