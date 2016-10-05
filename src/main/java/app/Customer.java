package app;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Erik on 19-9-2016.
 */
@Getter
@Setter
public class Customer extends User {
    private Card card;

    public Customer(String code, Card card) {
        super(code, "");
        this.card = card;
    }
}
