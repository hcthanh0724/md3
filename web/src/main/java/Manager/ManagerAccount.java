package Manager;

import Model.Account;

import java.util.ArrayList;
import java.util.List;

public class ManagerAccount {
   public static List <Account> accounts = new ArrayList<>();
    static {
        accounts.add(new Account("thanh9999","thanh1111"));
        accounts.add(new Account("tien9999","tien1111"));
        accounts.add(new Account("tot9999","tot1111"));
        accounts.add(new Account("trieu9999","trieu1111"));
        accounts.add(new Account("tung9999","tung1111"));
        accounts.add(new Account("toan9999","toan1111"));
    }

}
