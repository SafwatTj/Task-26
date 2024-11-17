import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main2 {
    /*
    Дана Map <String, BankAccount,> ключ это email. Ваша задача используя стримы лист из имен 3 самых крупных клиентов (т.е. тех у кого на счету самый большой остаток)
     */

    public static void main(String[] args) {






    }

    public static List<String> getVipClient (Map<String,BankAccount> map){
        Comparator<Map.Entry<String, BankAccount>> comparatorByBalance = (e1, e2) -> Double.compare(e1.getValue().getBalance(), e2.getValue().getBalance());
        return map.entrySet().stream()
                .sorted(comparatorByBalance.reversed())
                .limit(3)
                .map(e-> e.getValue().getOwner().getfName() + " " + e.getValue().getOwner().getlName())
                .collect(Collectors.toList());
    }

}
