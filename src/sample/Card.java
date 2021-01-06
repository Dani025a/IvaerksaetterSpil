package sample;

import java.io.Serializable;
import java.util.Random;

public class Card implements Serializable {

    Controller controller = new Controller();

    long balance = 141241254;
    Random random = new Random();
    String lostInvestment = "You lost on the investment";
    String oneFive = "you won 1.5X";
    String two = "you won 2X";
    String five = "you won 5X";
    String onehundred = "you have won 100X";

    long max;
    long min;
    int losingProcent;
    int twoXProcent;
    int fiveXProcent;
    int hundredXProcent;
    int checkProcentage = 0;


    public void cards(){
        max = balance;
        min = balance % 10;
        long investmentAmount = min + (long) (Math.random() * (max - min));
        int cardPicker = random.nextInt(9);
        cardPicker = 1;


        if (cardPicker == 1){
            int investmentprocent = random.nextInt(75 + 1);
            losingProcent = investmentprocent;
            checkProcentage = losingProcent;

            investmentprocent = random.nextInt(100 - losingProcent + 1);
            twoXProcent = investmentprocent;
            controller.textArea.setText("You have a new investment " +
                    "\nThe chance of of losing your investment is: " + losingProcent + "%" +
                    "\nThe chance of winnning 2X the investment is: " + twoXProcent + "%" +
                    "\nClick invest to take the risk the cost is: " + investmentAmount);
            checkProcentage = losingProcent + twoXProcent;
            checkProcentage = 100;

            if (checkProcentage != 100) {
                investmentprocent = random.nextInt(100 - checkProcentage + 1);
                fiveXProcent = investmentprocent;

                controller.textArea.setText("You have a new investment" +
                        "\nThe chance of of losing your investment is: " + losingProcent + "%" +
                        "\nThe chance of winnning 2X the investment is: " + twoXProcent + "%" +
                        "\nThe chance of winnning 5X the investment is: " + fiveXProcent + "%" +
                        "\nClick invest to take the risk the cost is: " + investmentAmount);
                checkProcentage = losingProcent + twoXProcent + fiveXProcent;
            }

            if (checkProcentage != 100) {
                hundredXProcent = investmentprocent;
                hundredXProcent = 100 - checkProcentage;
                controller.textArea.setText("You have a new investment" +
                        "\nThe chance of of losing your investment is: " + losingProcent + "%" +
                        "\nThe chance of winnning 2X the investment is: " + twoXProcent + "%" +
                        "\nThe chance of winnning 5X the investment is: " + fiveXProcent + "%" +
                        "\nThe chance of winnning 100X the investment is: " + hundredXProcent + "%" +
                        "\nClick invest to take the risk the cost is: " + investmentAmount);
            }
        }


    }

    public long getBalance() {
        return balance;
    }
}
