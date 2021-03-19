package task2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static int STEADS_AMOUNT = 100;

    public static void main(String[] args) {
        List<Stead> listStead = fillSteadList(STEADS_AMOUNT);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите масимально допустимую цену за сотку "); //Показательный пример - 30000
        BigDecimal maxPrice = scanner.nextBigDecimal();
        System.out.println("Список нечестных сделок:");
        getUnfairDeals(listStead, maxPrice);
        System.out.println();
        System.out.println("Список честных сделок:");
        getFairDeals(listStead, maxPrice);

    }

    private static void getUnfairDeals(List<Stead> listStead, BigDecimal maxPrice) {
        listStead.stream()
                .filter(x -> x.getPriceForUnit().compareTo(maxPrice) > 0)
                .forEach(x -> System.out.println(x.toString()));
    }

    private static void getFairDeals(List<Stead> listStead, BigDecimal maxPrice) {
        listStead.stream()
                .filter(x -> x.getPriceForUnit().compareTo(maxPrice) <= 0)
                .forEach(x -> System.out.println(x.toString()));
    }

    private static List<Stead> fillSteadList(int amount) {
        Random rnd = new Random();
        List<Stead> listStead = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            listStead.add(new Stead(30 + rnd.nextInt(10), 30 + rnd.nextInt(10), new BigDecimal(300000 + rnd.nextInt(100000))));
        }
        return listStead;
    }


}
