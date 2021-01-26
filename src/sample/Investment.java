package sample;

import java.util.Random;

public class Investment {

    long balance;
    Random random = new Random();

    long max;
    long min;
    int losingProcent;
    int twoXProcent;
    int fiveXProcent;
    int hundredXProcent;
    int checkProcentage = 0;
    long investmentAmount;
    int cardPicker;
    int procentpicker;

    public void investment(long balance) {
        if (balance >= 10000) {
            max = balance;
            min = balance % 10;
            this.balance = balance - 10000;
            investmentAmount = min + (long) (Math.random() * (max - min));
            cardPicker = random.nextInt(2) + 1;


            if (cardPicker == 1) {
                int investmentprocent = random.nextInt(75) + 1;
                losingProcent = investmentprocent;
                checkProcentage = losingProcent;

                investmentprocent = random.nextInt(100 - losingProcent) + 1;
                twoXProcent = investmentprocent;
                checkProcentage = losingProcent + twoXProcent;

                if (checkProcentage != 100) {
                    investmentprocent = random.nextInt(100 - checkProcentage) + 1;
                    fiveXProcent = investmentprocent;
                    checkProcentage = losingProcent + twoXProcent + fiveXProcent;
                }

                if (checkProcentage != 100) {
                    hundredXProcent = investmentprocent;
                    hundredXProcent = 100 - checkProcentage;
                }
            }
        }


    }
    public void investmentBuy( long balance){
        if (cardPicker == 1 && balance >= investmentAmount){
            procentpicker = random.nextInt(100) + 1;
            twoXProcent = losingProcent + twoXProcent;
            fiveXProcent = twoXProcent + fiveXProcent;

            if (hundredXProcent != 0){
                if (procentpicker > 0 && procentpicker <= losingProcent){
                    this.balance = balance - investmentAmount;
                losingProcent = 100;}
                else if (procentpicker > losingProcent && procentpicker <= twoXProcent){
                    this.balance = balance + (investmentAmount * 2);
                twoXProcent = 100;}
                else if (procentpicker > twoXProcent && procentpicker <= fiveXProcent){
                    this.balance = balance + (investmentAmount * 5);
                fiveXProcent = 100;}
                else {
                    this.balance = balance + (investmentAmount * 100);
                hundredXProcent = 100;}

            }
            else if (fiveXProcent != 0){
                if (procentpicker > 0 && procentpicker <= losingProcent){
                    this.balance = balance - investmentAmount;
                    losingProcent = 100;
                }
                else if (procentpicker > losingProcent && procentpicker <= twoXProcent){
                    this.balance = balance + (investmentAmount * 2);
                    twoXProcent = 100;
                }
                else{
                    this.balance = balance + (investmentAmount * 5);
                    fiveXProcent = 100;}
            }
            else {
                if (procentpicker > 0 && procentpicker <= losingProcent) {
                    this.balance = balance - investmentAmount;
                    losingProcent = 100;
                } else if (procentpicker < losingProcent && procentpicker >= twoXProcent) {
                    this.balance = balance + (investmentAmount * 2);
                    twoXProcent = 100;
                }
            }
            cardPicker = 100;
        }
    }


    public String toString() {

        if (cardPicker == 1) {
            if (fiveXProcent != 0) {
                return "You have a new investment" +
                        "\nThe chance of of losing your investment is: " + losingProcent + "%" +
                        "\nThe chance of winnning 2X the investment is: " + twoXProcent + "%" +
                        "\nThe chance of winnning 5X the investment is: " + fiveXProcent + "%" +
                        "\nThe chance of winnning 100X the investment is: " + hundredXProcent + "%" +
                        "\nClick invest to take the risk the cost is: " + investmentAmount;
            }else if (hundredXProcent != 0) {
                return ("You have a new investment" +
                        "\nThe chance of of losing your investment is: " + losingProcent + "%" +
                        "\nThe chance of winnning 2X the investment is: " + twoXProcent + "%" +
                        "\nThe chance of winnning 5X the investment is: " + fiveXProcent + "%" +
                        "\nClick invest to take the risk the cost is: " + investmentAmount);
            }  else
                return ("You have a new investment " +
                        "\nThe chance of of losing your investment is: " + losingProcent + "%" +
                        "\nThe chance of winnning 2X the investment is: " + twoXProcent + "%" +
                        "\nClick invest to take the risk the cost is: " + investmentAmount);
        }
        else if (cardPicker != 0) return "No new investment found, better luck next time";
        else return "";
    }



    public long getBalance() {
        return balance;
    }

    public int getLosingProcent() {
        return losingProcent;
    }

    public int getTwoXProcent() {
        return twoXProcent;
    }

    public int getFiveXProcent() {
        return fiveXProcent;
    }

    public int getHundredXProcent() {
        return hundredXProcent;
    }

    public long getInvestmentAmount() {
        return investmentAmount;
    }
}
