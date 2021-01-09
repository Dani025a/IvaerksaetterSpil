package sample;

public class Worker {



    long workerPrice = 10;
    long newWorkerPrice;
    long workerAmount;
    long workerLevel;
    long newWorkerLevelprice;
    long workerLevelPrice = 100;
    long balance;


    public void buyWorker(long balance){
         if (workerAmount <= 25 && balance >= workerPrice){
                this.balance = balance - workerPrice;
                newWorkerPrice = workerPrice * 5;
                workerPrice = newWorkerPrice;
                workerAmount++;
        }
    }

    public void upgradeWorker(long balance){
        if (workerLevel <= 16 && balance >= workerLevelPrice) {
            this.balance = this.balance - workerLevelPrice;

                this.balance = balance - workerLevelPrice;
                newWorkerLevelprice = workerLevelPrice * 10;
                workerLevelPrice = newWorkerLevelprice;
                workerLevel++;

        }
    }

    public void worker(long balance){
        if (workerLevel != 0){
            if (workerAmount <= 5)
                this.balance = balance + (((workerAmount + 1) * 2) * (workerLevel + 1));
            else if (workerAmount > 10 && workerAmount >= 15)
                this.balance = balance + (((workerAmount + 1) * 3) * (workerLevel + 1));
            else if (workerAmount > 15 && workerAmount >= 20)
                this.balance = balance + (((workerAmount + 1) * 4) * (workerLevel + 1));
            else
                this.balance = balance + (((workerAmount + 1) * 5) * (workerLevel + 1));

        }

        else if (workerAmount != 0){
            if (workerAmount <= 10)
                if (workerAmount >= 5)
                    this.balance = balance + (((workerAmount + 1) * 2));
                else if (workerAmount < 10 && workerAmount >= 15)
                    this.balance = balance + (((workerAmount + 1) * 3));
                else if (workerAmount < 15 && workerAmount >= 20)
                    this.balance = balance + (((workerAmount + 1) * 4));
                else
                    this.balance = balance + (((workerAmount + 1) * 5));

        }
        else this.balance = balance;
    }

    public long getWorkerPrice() {
        return workerPrice;
    }

    public long getWorkerAmount() {
        return workerAmount;
    }

    public long getBalance() {
        return balance;
    }

    public long getWorkerLevel() {
        return workerLevel;
    }

    public long getWorkerLevelPrice() {
        return workerLevelPrice;
    }

}
