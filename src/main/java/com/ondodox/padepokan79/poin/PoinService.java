package com.ondodox.padepokan79.poin;


public class PoinService {

    public static int countPoinBP(Long amount){
        float poins = 0;
        if (amount > 30000){
            long temp =  amount - 30000;
            poins += (float) temp / 1000 * 2;
            amount -= temp;
        }

        if (amount <= 30000 && amount > 10000){
            long temp = amount - 10000;
            poins += (float)temp / 2000;
        }

        return Math.round(poins);
    }
    public static int countPoinBL(long amount){
        float poins = 0;
        if (amount > 100000){
            long temp =  amount - 100000;
            poins += (float) temp / 2000 * 2;
            amount -= temp;
        }

        if (amount >= 50000){
            long temp = amount - 50000;
            poins += (float)temp / 2000;
        }

        return Math.round(poins);
    }
}
