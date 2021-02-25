package com.epam.rd.Serhii_Minakov.Task6;

import com.epam.rd.Serhii_Minakov.Task6.repository.GoodsRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * This class is created to save the goods that are in storage to the specified file using GZIP
 */
public class GoodsSaverGZIP {
    private static final String FILE_NAME = "gzip.txt";

    /**
     * Saves the goods into the specified file using GZIP
     *
     * @param goods goods to be saved
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public static void saveAll(GoodsRepository goods) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(FILE_NAME)));
        oos.writeObject(goods.getGoods());
    }
}
