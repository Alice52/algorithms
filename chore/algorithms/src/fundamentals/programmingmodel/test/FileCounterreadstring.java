package fundamentals.programmingmodel.test;

/******************************************************************************
 *  Compilation:  javac FrequencyCounter.java
 *  Execution:    java FrequencyCounter L < input.txt
 *  Dependencies: ST.java StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/31elementary/tnyTale.txt
 *                http://algs4.cs.princeton.edu/31elementary/tale.txt
 *                http://algs4.cs.princeton.edu/31elementary/leipzig100K.txt
 *                http://algs4.cs.princeton.edu/31elementary/leipzig300K.txt
 *                http://algs4.cs.princeton.edu/31elementary/leipzig1M.txt
 *
 *  Read in a list of words from standard input and print out
 *  the most frequently occurring word that has length greater than
 *  a given threshold.
 *
 *  % java FrequencyCounter 1 < tinyTale.txt
 *  it 10
 *
 *  % java FrequencyCounter 8 < tale.txt
 *  business 122
 *
 *  % java FrequencyCounter 10 < leipzig1M.txt
 *  government 24763
 *
 *
 ******************************************************************************/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * The {@code FrequencyCounter} class provides a client for reading in a
 * sequence of words and printing a word (exceeding a given length) that occurs
 * most frequently. It is useful as a test client for various symbol table
 * implementations.
 * <p>
 * For additional documentation, see
 * <a href="http://algs4.cs.princeton.edu/31elementary">Section 3.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */

public class FileCounterreadstring {

    /**
     * Reads in a command-line integer and sequence of words from standard input
     * and prints out a word (whose length exceeds the threshold) that occurs
     * most frequently to standard output. It also prints out the number of
     * words whose length exceeds the threshold and the number of distinct such
     * words.
     *
     * @param args
     *            the command-line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        int distinct = 0, words = 0;
        String[] arr = null;
        String line;
        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();

        /*****************************************************************
         * ���ļ��ж�ȡ�ַ���ʵ�� File file=new
         * File("F:/Java/Algorithms/algs4-data/tinyTale.txt"); BufferedReader
         * br=new BufferedReader(new FileReader(file)); while
         * ((line=br.readLine())!=null){ arr=line.split(" ");
         * //------------------------ֻ�ܴ���һ�е�ת����֮��ĻḲ��ԭ�ȵ�arr���� }
         ******************************************************************/
        File file = new File("F:/Java/Algorithms/algs4-data/1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            arr = line.split(""); // ------------------------ֻ�ܴ���һ�е�ת����֮��ĻḲ��ԭ�ȵ�arr����
            for (int i = 0; i < arr.length; i++) {
                String key = arr[i];
                if (key.length() < minlen) {
                    continue;
                }
                words++;
                if (st.contains(key)) {
                    st.put(key, st.get(key) + 1);
                } else {
                    st.put(key, 1);
                    distinct++;
                }
            }
        }
        br.close();

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);

        for (String word : st.keys()) {

            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }

    // Do not instantiate.
    private FileCounterreadstring() {
    }
}