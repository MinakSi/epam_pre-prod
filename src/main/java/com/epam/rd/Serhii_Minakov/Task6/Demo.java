package com.epam.rd.Serhii_Minakov.Task6;

import com.epam.rd.Serhii_Minakov.Task6.command.Command;
import com.epam.rd.Serhii_Minakov.Task6.command.implementation.CreateNewGoodCommand;
import com.epam.rd.Serhii_Minakov.Task6.input.types.RandomGoodsInput;
import com.epam.rd.Serhii_Minakov.Task6.repository.GoodsRepository;
import com.epam.rd.Serhii_Minakov.Task6.service.GoodsService;

import java.io.File;
import java.io.IOException;

public class Demo {
    public static final String STANDARD_SAVING_FILE_NAME = "C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\myDB.txt";
    public static final String GZIP_SAVING_FILE_NAME = "C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\gzip.txt";

    public static void main(String[] args) throws IOException {
        File standardSavingFile = new File(STANDARD_SAVING_FILE_NAME);
        File gzipSavingFile = new File(GZIP_SAVING_FILE_NAME);
        GoodsRepository repository = new GoodsRepository();
        GoodsService service = new GoodsService(repository);
        Command command = new CreateNewGoodCommand(new RandomGoodsInput(), service);

        for (int i = 0; i < 10; i++) {
            command.execute();
            System.out.println("goods: " + service.getGoodsRepository().getGoods().size());
            GoodsSaver.saveAll(repository);
            GoodsSaverGZIP.saveAll(repository);
            System.out.println("standard: " + standardSavingFile.length());
            System.out.println("gzip: " + gzipSavingFile.length());
            System.out.println();
            System.out.println();
        }
    }
}
