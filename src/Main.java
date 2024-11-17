/*
Дан список  BankAccount {Person owner, String IBAN, double balance).
Класс Person состоит из {String fName, String lName String email). Используя stream необходимо получить:

map где ключом будет owner (Person), а значением будет баланс (Double)
map где ключом будет IBAN (String), а значением будет owner (Person)
map где ключом будет IBAN (String), а значением будет строка  J.Jack (т.e. первая буква fName и lName)

В рамках данной задачи person и account  уникальны и у каждого owner a единственный счет.

 */

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static Map<Person,Double> mapOwnerToBalance(List<BankAccount> accounts){
       if (accounts == null) {
           return Collections.emptyMap();
       }
        return accounts.stream()
                //.collect(Collectors.toMap(a->a.getOwner(), a-> a.getBalance()));
                .collect(Collectors.toMap(BankAccount::getOwner, BankAccount::getBalance));
    }

    public static Map<String, Person> mapIbanToOwner(List<BankAccount> accounts){
        if (accounts == null) {
            return Collections.emptyMap();
        }

        return accounts.stream()
                .collect(Collectors.toMap( BankAccount::getIBAN, BankAccount::getOwner  ));

    }

    public static Map<String, String> mapIbanToNameString(List<BankAccount> accounts){
        if (accounts == null) {
            return Collections.emptyMap();
        }

        return accounts.stream()
                .collect(Collectors.toMap( BankAccount::getIBAN, ba -> ba.getOwner().getfName().charAt(0) + ". " + ba.getOwner().getlName()   ));

    }

}