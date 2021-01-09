package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

    long balance = 10;

    String lostInvestment = "You lost on the investment";
    String two = "you won 2X";
    String five = "you won 5X";
    String onehundred = "you have won 100X";
    int clickerAmount;
    int day = 1;



    Worker worker = new Worker();
    Card card = new Card();
    public void newBalance(){
        balanceField.setText(String.valueOf(balance));
    }


    public void onActionCard(){
        card.cards(balance);
        textArea.setText(card.toString());
        balance = card.getBalance();
        newBalance();
    }



    public void onActionBuyInvestment(){
        card.investmentBuy(balance);
        balance = card.getBalance();
        if (card.losingProcent == 100){ textArea.setText(lostInvestment); card.losingProcent = 0;}
        else if (card.twoXProcent == 100) { textArea.setText(two); card.twoXProcent = 0;}
        else if (card.fiveXProcent == 100) { textArea.setText(five); card.fiveXProcent = 0;}
        else if (card.hundredXProcent == 100) { textArea.setText(onehundred); card.hundredXProcent = 0;}
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        workersLevelLabel.setText("0");
        workerslabel.setText("0");
        workersLevelpriceLabel.setText("100");
        workerspricelabel.setText("10");
        balanceField.setText("10");
        daylabel.setText("1");
    }
}
