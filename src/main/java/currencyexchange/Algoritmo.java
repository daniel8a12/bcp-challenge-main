package currencyexchange;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo {

    public static void main(String[] args) {
        System.out.println("Arreglo de números: ");
        Integer[] num = {1, 2, 8, 23, 5, 15, 17, 15};
        List<Integer> primos = new ArrayList<>();
        for (Integer x : num) {
            if (esPrimo(x)) {
                primos.add(x);
            }
        }

        System.out.println("Primos: " + primos);
        System.out.println("Ordenado: " + ordenado(primos));


    }

    public static List<Integer> ordenado(List<Integer> primos) {

        for (int x = 0; x < primos.size(); x++) {
            for (int i = 0; i < primos.size() - 1; i++) {
                if (primos.get(i) > primos.get(i + 1)) {
                    Integer tmp = primos.get(i + 1);
                    primos.set(i + 1, primos.get(i));
                    primos.set(i, tmp);
                }
            }
        }

        return primos;
    }


    public static boolean esPrimo(Integer num) {
        //El 0 - 1 - 4
        if (num == 0 || num == 1 || num == 4) {
            return false;
        }

        for (int x = 2; x < num; x++) {
            if (num % x == 0) {
                return false;
            }
        }
        return true;
    }

}
