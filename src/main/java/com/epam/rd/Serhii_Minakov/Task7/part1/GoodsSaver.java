package com.epam.rd.Serhii_Minakov.Task7.part1;

import com.epam.rd.Serhii_Minakov.Task7.part1.models.Goods;
import com.epam.rd.Serhii_Minakov.Task7.part1.repository.GoodsRepository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This class is created to save the goods that are in storage to the specified file
 */
public class GoodsSaver {

    public static final String FILE_NAME = "myDB.txt";

    /**
     * Saves the goods into the specified file
     *
     * @param goods goods to be saved
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public static void saveAll(GoodsRepository goods) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        oos.writeObject(goods.getGoods());
    }

    /**
     * Reads the goods from the specified file to goods repository
     *
     * @return a new goods repository with written goods
     * @throws IOException            if an I/O error occurs while reading from the file
     * @throws ClassNotFoundException Class of a serialized object cannot be found
     */
    public static GoodsRepository readAll() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
        return new GoodsRepository((ArrayList<Goods>) ois.readObject());
    }
}
