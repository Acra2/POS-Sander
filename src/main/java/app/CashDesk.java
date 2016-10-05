package app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Erik on 19-9-2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class CashDesk {
    private int number;

    public static boolean matches(int number) {
        if (number == 1) {
            return true;
        } else {
            return false;
        }
    }
}
