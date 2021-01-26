package sample;

public class Building {


    long balance;
    long buildingPrice = 100000;
    int buildingLevel = 1;

    public void UpgradeBuilding(long balance){
        if (buildingLevel >= 1 || buildingLevel <= 5){
            if (buildingLevel == 1 && balance >= buildingPrice){
                this.balance = balance - buildingPrice;
                buildingPrice = 1000000;
                buildingLevel ++;
            }
            else if (buildingLevel == 2 && balance >= buildingPrice){
                this.balance = balance - buildingPrice;
                buildingPrice = 100000000;
                buildingLevel ++;
            }
            else if (buildingLevel == 3 && balance >= buildingPrice){
                this.balance = balance - buildingPrice;
                buildingPrice = 10000000000L;
                buildingLevel ++;
            }
            else if (buildingLevel == 4 && balance >= buildingPrice){
                this.balance = balance - buildingPrice;
                buildingPrice = 1000000000000L;
                buildingLevel ++;
            }
            else if (buildingLevel == 5)
                buildingLevel = 5;
            else
                this.balance = balance;
        }
    }

    public long getBalance() {
        return balance;
    }

    public int getBuildingLevel() {
        return buildingLevel;
    }

    public long getBuildingPrice() {
        return buildingPrice;
    }
}
