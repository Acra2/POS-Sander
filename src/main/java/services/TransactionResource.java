package services;

import Repositories.DummyTransActionRepo;
import Repositories.ITransactionRepo;
import app.Transaction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Sander on 22-9-2016.
 */
@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {

    ITransactionRepo transactionRepo = DummyTransActionRepo.getInstance();

    @GET
    public Transaction getTransaction(String id) {
        return transactionRepo.getTransaction(id);
    }
}
