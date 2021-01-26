package sample;

import Persistance.Filehandeling;
import Persistance.Gamedata;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {




    @FXML
    private Label balanceField = new Label();

    @FXML
    private Label daylabel;

    @FXML
    private Label workerslabel;

    @FXML
    private Label workerspricelabel;

    @FXML
    private Label workersLevelLabel;

    @FXML
    private Label workersLevelpriceLabel;

    @FXML
    public TextArea textArea = new TextArea();

    @FXML
    private Label buildingPrice;

    @FXML
    private ImageView buildingImage;

    long balance = 10;

    String lostInvestment = "You lost on the investment";
    String two = "you won 2X";
    String five = "you won 5X";
    String onehundred = "you have won 100X";
    int clickerAmount;
    int day = 1;

    Building building = new Building();
    Worker worker = new Worker();
    Investment investment = new Investment();
    public void newBalance(){
        balanceField.setText(String.valueOf(balance));
    }


    public void onActionCard(){
        investment.investment(balance);
        textArea.setText(investment.toString());
        balance = investment.getBalance();
        newBalance();
    }



    public void onActionBuyInvestment(){
        investment.investmentBuy(balance);
        balance = investment.getBalance();
        if (investment.losingProcent == 100){ textArea.setText(lostInvestment); investment.losingProcent = 0;}
        else if (investment.twoXProcent == 100) { textArea.setText(two); investment.twoXProcent = 0;}
        else if (investment.fiveXProcent == 100) { textArea.setText(five); investment.fiveXProcent = 0;}
        else if (investment.hundredXProcent == 100) { textArea.setText(onehundred); investment.hundredXProcent = 0;}
        newBalance();
    }

    public void onActionclicker(){
        if (worker.getWorkerAmount() != 0 || worker.getWorkerLevel() != 0) {
            worker.worker(balance);
            balance = worker.getBalance();
            clickerAmount++;
            newBalance();
            if (clickerAmount == 50) {
                clickerAmount = 0;
                day++;
                daylabel.setText(String.valueOf(day));
            }
        }

    }

    public void onActionBuyWorkers(){
        worker.buyWorker(balance);
        workerslabel.setText(String.valueOf(worker.getWorkerAmount()));
        workerspricelabel.setText(String.valueOf(worker.getWorkerPrice()));
        balance = worker.getBalance();
        newBalance();

        if (worker.getWorkerAmount() == 26){
            workerspricelabel.setText("");
            workerslabel.setText("MAX");
    }
    }
    public void onActionUpgradeWorkers(){
        worker.upgradeWorker(balance);
        workersLevelLabel.setText(String.valueOf(worker.getWorkerLevel()));
        workersLevelpriceLabel.setText(String.valueOf(worker.getWorkerLevelPrice()));
        balance = worker.getBalance();
        newBalance();
        if (worker.getWorkerLevel() == 17){
            workersLevelpriceLabel.setText("");
            workersLevelLabel.setText("MAX");
        }

    }

    public void onActionUpgradeBuilding(){


        building.UpgradeBuilding(balance);
        balance = building.getBalance();
        newBalance();

        if (building.getBuildingLevel() == 1)
        {buildingImage.setImage( new Image("Images/GarageLevelOne.jpg"));
        buildingPrice.setText(String.valueOf(building.getBuildingPrice()));}

        else if (building.getBuildingLevel() == 2)
        {buildingImage.setImage( new Image("Images/smallOfficeLevelTwo.png"));
        buildingPrice.setText(String.valueOf(building.getBuildingPrice()));}

        else if (building.getBuildingLevel() == 3)
        {buildingImage.setImage( new Image("Images/MediumOfficeLevelThree.jpg"));
        buildingPrice.setText(String.valueOf(building.getBuildingPrice()));}

        else if (building.getBuildingLevel() == 4)
        {buildingImage.setImage( new Image("Images/BigOfficeBuildingLevelFour.gif"));
        buildingPrice.setText(String.valueOf(building.getBuildingPrice()));}

        else {
            buildingImage.setImage(new Image("Images/CityLevelFive.jpg"));
            buildingPrice.setText("MAX");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        workersLevelLabel.setText(String.valueOf(worker.getWorkerLevel()));
        workerslabel.setText(String.valueOf(worker.getWorkerAmount()));
        workersLevelpriceLabel.setText(String.valueOf(worker.workerLevelPrice));
        workerspricelabel.setText(String.valueOf(worker.workerPrice));
        balanceField.setText(String.valueOf(balance));
        daylabel.setText(String.valueOf(day));
        buildingImage.setImage( new Image("Images/GarageLevelOne.jpg"));
        buildingPrice.setText(String.valueOf(building.getBuildingPrice()));
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        Gamedata gameData = new Gamedata();
        gameData.balance = balance;
        gameData.buildingPrice = building.getBuildingPrice();
        gameData.buildingLevel = building.getBuildingLevel();
        gameData.losingProcent = investment.getLosingProcent();
        gameData.twoXProcent = investment.getTwoXProcent();
        gameData.fiveXProcent = investment.getFiveXProcent();
        gameData.hundredXProcent = investment.getHundredXProcent();
        gameData.investmentAmount = investment.getInvestmentAmount();
        gameData.workerLevel = worker.getWorkerLevel();
        gameData.workerLevelPrice = worker.getWorkerLevelPrice();
        gameData.workerAmount = worker.getWorkerAmount();
        gameData.workerPrice = worker.getWorkerPrice();

        Filehandeling filehandeling = new Filehandeling();
        filehandeling.save(gameData);

    }



    @FXML
    void load(ActionEvent event) throws IOException{
        Filehandeling filehandeling = new Filehandeling();
        Gamedata gameData;
        gameData = filehandeling.load();
        balance = gameData.balance;
        building.buildingPrice = gameData.buildingPrice;
        building.buildingLevel = gameData.buildingLevel;
        investment.losingProcent = gameData.losingProcent;
        investment.twoXProcent = gameData.twoXProcent;
        investment.fiveXProcent = gameData.fiveXProcent;
        investment.hundredXProcent = gameData.hundredXProcent;
        investment.investmentAmount = gameData.investmentAmount;
        worker.workerLevel = gameData.workerLevel;
        worker.workerLevelPrice = gameData.workerLevelPrice;
        worker.workerAmount = gameData.workerAmount;
        worker.workerPrice = gameData.workerPrice;

        workersLevelLabel.setText(String.valueOf(worker.getWorkerLevel()));
        workerslabel.setText(String.valueOf(worker.getWorkerAmount()));
        workersLevelpriceLabel.setText(String.valueOf(worker.getWorkerLevelPrice()));
        workerspricelabel.setText(String.valueOf(worker.getWorkerPrice()));
        balanceField.setText(String.valueOf(balance));
        daylabel.setText(String.valueOf(day));
        textArea.setText(investment.toString());
        onActionUpgradeBuilding();

    }
}
