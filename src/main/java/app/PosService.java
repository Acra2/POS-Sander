package app;

import Repositories.DummyEmployeeRepo;
import Repositories.DummyProductRepo;
import Repositories.IEmployeeRepo;
import Repositories.IProductRepo;

/**
 * Created by Erik on 19-9-2016.
 */
public class PosService {

    static IEmployeeRepo employeeRepo = DummyEmployeeRepo.getInstance();
    static IProductRepo productRepo = DummyProductRepo.getInstance();

    public static void fillInventory() {
        Inventory inventory = Inventory.getInventory();
        inventory.addProduct(new SingleProduct("555", "Laptop", 999.99));
    }

    public static Session login(String employeeCode, int deskNumber) {
        if (employeeCode != null && deskNumber != 0) {
            if (employeeRepo.getEmployee(employeeCode) != null) {
                if (CashDesk.matches(deskNumber)) {
                    return new Session(employeeRepo.getEmployee(employeeCode), new CashDesk(deskNumber));
                } else return null;
            } else return null;
        } else return null;
    }

    public static Transaction createTransaction() {

        InputReader reader = new InputReader();
        TransactionFactory transactionFactory = new TransactionFactory();

        while (true) {
            System.out.println("Which transaction do you want to start? Type 'sale' | 'reservation' | 'refund");

            Transaction transaction = transactionFactory.createTransaction(reader.readInput());
            if (transaction != null) {
                return transaction;
            }
        }
    }

    public static void finishTransaction(Session session, Transaction transaction) {
        transaction.finishTransaction();
        session.addTransaction(transaction);
    }

    public static void addProductToTransaction(Transaction transaction, String productCode) {
        Product product = productRepo.getProduct(productCode);
        if (product != null) {
            transaction.addProduct(product);
            System.out.println(product.getName() + " added.");
            System.out.println("Price: " + product.getPrice());
        } else {
            System.out.println("Invalid product code");
        }
    }
}
