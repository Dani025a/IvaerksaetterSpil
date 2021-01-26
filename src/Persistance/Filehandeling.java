package Persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Filehandeling {

    public void save(Gamedata gameData) throws IOException {
        File file = new File("spildata.txt");
        PrintWriter output = new PrintWriter(file);
        output.println(gameData.balance);
        output.println(gameData.buildingLevel);
        output.println(gameData.buildingPrice);
        output.println(gameData.losingProcent);
        output.println(gameData.twoXProcent);
        output.println(gameData.fiveXProcent);
        output.println(gameData.hundredXProcent);
        output.println(gameData.investmentAmount);
        output.println(gameData.procentpicker);
        output.println(gameData.workerPrice);
        output.println(gameData.workerAmount);
        output.println(gameData.workerLevel);
        output.println(gameData.workerLevelPrice);
        output.close();
    }

    public Gamedata load() throws FileNotFoundException {
        File file = new File("spildata.txt");
        Scanner input = new Scanner(file);
        Gamedata gameData = new Gamedata();
        gameData.balance = Long.parseLong(input.next());
        gameData.buildingLevel = Integer.parseInt(input.next());
        gameData.buildingPrice = Long.parseLong(input.next());
        gameData.losingProcent = Integer.parseInt(input.next());
        gameData.twoXProcent = Integer.parseInt(input.next());
        gameData.fiveXProcent = Integer.parseInt(input.next());
        gameData.hundredXProcent = Integer.parseInt(input.next());
        gameData.investmentAmount = Long.parseLong(input.next());
        gameData.procentpicker = Integer.parseInt(input.next());
        gameData.workerPrice = Long.parseLong(input.next());
        gameData.workerAmount = Long.parseLong(input.next());
        gameData.workerLevel = Long.parseLong(input.next());
        gameData.workerLevelPrice = Long.parseLong(input.next());
        return gameData;
    }
}
