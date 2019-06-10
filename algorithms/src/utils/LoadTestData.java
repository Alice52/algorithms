package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LoadTestData {

    private final static Logger logger = Logger.getLogger(LoadTestData.class);

    /**
     * Read the array of int and return the array.
     *
     * @param path the location of the file
     * @return the array of the file
     */
    public static List<Integer> readInts(String path) {

        InputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            logger.error("ERROR happened in utils.LoadTestData.readInts[FileNotFoundException line:31]:" + e.getMessage());
        }

        InputStreamReader reader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<Integer> ints = new ArrayList<Integer>();
        String[] temp = null;
        String line = null;

        try {

            while ((line = bufferedReader.readLine()) != null) {
                temp = line.trim().split(" ");

                for (int i = 0; i < temp.length; i++) {
                    ints.add(Integer.valueOf(temp[i].trim()).intValue());
                }
            }
        } catch (NumberFormatException | IOException e) {
            logger.error("ERROR happened in utils.LoadTestData.readInts:" + e.getCause());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.error("ERROR happened in utils.LoadTestData.readInts:[IOException line 57]" + e.getMessage());
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.error("ERROR happened in utils.LoadTestData.readInts:[IOException line: 65]" + e.getMessage());
                }
            }

            if (fileInputStream != null) {

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    logger.error("ERROR happened in utils.LoadTestData.readInts:[IOException line: 74]" + e.getMessage());
                }
            }
        }

        return ints;
    }

    @Test
    public void test() {

        final String path = "D:\\worksapce\\Resource\\algs4-data\\largeT.txt";
        List<Integer> ints = readInts(path);
        System.out.println(ints.indexOf(0));
        Collections.sort(ints);
        System.out.println(ints.get(0));
        System.out.println(ints.size());
    }
}