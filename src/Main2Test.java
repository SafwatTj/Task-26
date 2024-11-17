import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Main2Test {

    @Test
    void getVipClient() {
        Map<String, BankAccount> map = Map.of(
                "oleg@gmail.com",new BankAccount( new Person("Oleg","Olegov", "oleg@gmail.com"), "DE00006",3333.3),
                "jack@gmail.com", new BankAccount(new Person("Jack","Johnson", "jack@gmail.com"), "DE00005",872.50),
                "ann@gmail.com",new BankAccount(new Person("Ann","Johnson", "ann@gmail.com"), "DE00004",3452.40),
                "nick@gmail.com",new BankAccount(new Person("Nick","Nickson", "nick@gmail.com"), "DE00003",10.30),
                "mile@gmail.com",new BankAccount(new Person("Mike","Tyson", "mile@gmail.com"), "DE00002",10000.20),
                "danial@gmail.com",new BankAccount( new Person("Danial","Gragson", "danial@gmail.com"), "DE00001",888.10)
        );

        List<String> expectedList = List.of(
                "Mike Tyson",
                "Ann Johnson",
                "Oleg Olegov"
        );

        List<String> actualResult = Main2.getVipClient(map);
        Assertions.assertIterableEquals(expectedList,actualResult);
    }
}