package ru.netology.tax_report.shop;

import java.util.Random;

public class Shop {

    private final int [] sales;
    private final int SALES_SIZE;
    private final Random rand;
    private final int shopNumber;

    public Shop (int shopNumber) {

        rand = new Random();
        SALES_SIZE = rand.nextInt(25) + 2;
        sales = new int[SALES_SIZE];
        this.shopNumber = shopNumber;
        generateSales();

    }

    private void generateSales () {

        for (int i = 0; i < SALES_SIZE; i++) {

            sales[i] = rand.nextInt(50) * rand.nextInt(50);

        }

    }

    public long salesSum () {

        long sum = 0;

        for (int sale : sales) {

            sum += sale;

        }

        System.out.printf("Сумма выручки магазина №%d равна %d \n", shopNumber, sum);
        return sum;
    }

}
