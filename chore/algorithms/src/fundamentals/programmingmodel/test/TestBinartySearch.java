package fundamentals.programmingmodel.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import fundamentals.programmingmodel.BinarySearch;
import utils.LoadTestData;

public class TestBinartySearch {

    private final static String FILTER_PATH = "F:\\Java\\Algorithms4\\algs4-data\\#zackFilter.txt";
    private final static String SOURCE_PATH = "F:\\Java\\Algorithms4\\algs4-data\\largeW.txt";
    private final static String WHITLE_LIST_PATH = "F:\\Java\\Algorithms4\\algs4-data\\largeT.txt";

    @Test
    /**
     * Get the int value in target,which is not exist in source, and write the
     * result to filterList file.
     */
    public void testBinarySearch() throws IOException {

        List<Integer> whiteList = new ArrayList<Integer>();
        whiteList = LoadTestData.readInts(TestBinartySearch.WHITLE_LIST_PATH);
        List<Integer> source = new ArrayList<Integer>();
        source = LoadTestData.readInts(TestBinartySearch.SOURCE_PATH);
        List<Integer> target = new ArrayList<Integer>();

        Collections.sort(source);

        for (int i = 0; i < whiteList.size(); i++) {
            int key = whiteList.get(i);
            if (BinarySearch.rank(key, source) == -1) {
                target.add(key);
            }
        }

        // Write the result to filterList file
        System.out.println(target.size());
        FileWriter fileWritter = new FileWriter(TestBinartySearch.FILTER_PATH);
        BufferedWriter writer = new BufferedWriter(fileWritter);

        for (Iterator<Integer> iterator = target.iterator(); iterator.hasNext();) {
            Integer integer = iterator.next();
            writer.write(String.valueOf(integer));
            writer.newLine();
        }

        if (writer != null) {

            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}