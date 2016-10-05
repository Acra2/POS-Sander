package app;

import lombok.Getter;

/**
 * Created by Erik on 19-9-2016.
 */
@Getter
public abstract class User {

    protected String code;
    protected String name;

    public User(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
