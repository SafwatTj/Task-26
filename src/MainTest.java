import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class MainTest {
    private  List<BankAccount> accounts;

    @BeforeEach
    void setUp() {
        accounts = new ArrayList<>( List.of(
                new BankAccount( new Person("Oleg","Olegov", "oleg@gmail.com"), "DE00006",3333.3),
                new BankAccount(new Person("Jack","Johnson", "jack@gmail.com"), "DE00005",872.50),
                new BankAccount(new Person("Ann","Johnson", "ann@gmail.com"), "DE00004",3452.40),
                new BankAccount(new Person("Nick","Nickson", "nick@gmail.com"), "DE00003",10.30),
                new BankAccount(new Person("Mike","Tyson", "mile@gmail.com"), "DE00002",10000.20),
                new BankAccount( new Person("Danial","Gragson", "danial@gmail.com"), "DE00001",888.10)

        ) );
    }

    @Test
    void mapOwnerBalance_regularCase() {

        Map<Person,Double> expectedMap = new HashMap<>();
        expectedMap.put(new Person("Danial","Gragson", "danial@gmail.com"), 888.10);
        expectedMap.put(new Person("Mike","Tyson", "mile@gmail.com"), 10000.20);
        expectedMap.put(new Person("Nick","Nickson", "nick@gmail.com"), 10.30);
        expectedMap.put(new Person("Ann","Johnson", "ann@gmail.com"), 3452.40);
        expectedMap.put(new Person("Jack","Johnson", "jack@gmail.com"), 872.50);
        expectedMap.put(new Person("Oleg","Olegov", "oleg@gmail.com"), 3333.3);

        Assertions.assertEquals(expectedMap, Main.mapOwnerToBalance(accounts));

    }

    @Test
    void mapOwnerBalance_nullList_shouldReturnEmptyMap() {
        Map<Person, Double> expectedMap = Collections.emptyMap();
        Assertions.assertEquals(expectedMap, Main.mapOwnerToBalance(null));
    }

    @Test
    void mapIbanToOwner_regularCase(){

        Map<String, Person> expectedMap = Map.of(
                "DE00006", new Person("Oleg","Olegov", "oleg@gmail.com"),
                "DE00005", new Person("Jack","Johnson", "jack@gmail.com"),
                "DE00004", new Person("Ann","Johnson", "ann@gmail.com"),
                "DE00003", new Person("Nick","Nickson", "nick@gmail.com"),
                "DE00002", new Person("Mike","Tyson", "mile@gmail.com"),
                "DE00001", new Person("Danial","Gragson", "danial@gmail.com")
                );

        Assertions.assertEquals(expectedMap, Main.mapIbanToOwner(accounts));
    }

    @Test
    void mapIbanToOwner_nullList_shouldReturnEmptyMap() {
        Map<String, Person> expectedMap = Collections.emptyMap();
        Assertions.assertEquals(expectedMap, Main.mapIbanToOwner(null));
    }



    @Test
    void mapIbanToNameString_regularCase(){

        Map<String, String> expectedMap = Map.of(
                "DE00006", "O. Olegov",
                "DE00005", "J. Johnson",
                "DE00004", "A. Johnson",
                "DE00003", "N. Nickson",
                "DE00002", "M. Tyson",
                "DE00001", "D. Gragson"
        );

        Assertions.assertEquals(expectedMap, Main.mapIbanToNameString(accounts));
    }

    @Test
    void mapIbanToNameString_nullList_shouldReturnEmptyMap() {
        Map<String, String> expectedMap = Collections.emptyMap();
        Assertions.assertEquals(expectedMap, Main.mapIbanToNameString(null));
    }



}