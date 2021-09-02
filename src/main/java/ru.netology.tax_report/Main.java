package ru.netology.tax_report;

import ru.netology.tax_report.shop.Shop;

import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int SHOPS_NUMBER = 3;
        Shop [] shops = generateShops(SHOPS_NUMBER);
        LongAdder allTaxes = new LongAdder();

        Thread t1 = new Thread(() -> addTaxSum(shops[0].salesSum(), allTaxes));
        Thread t2 = new Thread(() -> addTaxSum(shops[1].salesSum(), allTaxes));
        Thread t3 = new Thread(() -> addTaxSum(shops[2].salesSum(), allTaxes));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.printf("Сумма всех налогов равна %d \n", allTaxes.sum());


    }

    public static void addTaxSum(long tax, LongAdder allTaxes) {

        allTaxes.add(tax);

    }

    public static Shop [] generateShops(int shopsNumber) {

        Shop [] shops = new Shop[shopsNumber];

        for (int i = 0; i < shopsNumber; i++) {

            shops[i] = new Shop(i+1);

        }
        return shops;
    }


}
