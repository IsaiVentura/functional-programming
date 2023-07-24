import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.concurrent.atomic.AtomicInteger;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        AtomicInteger positive = new AtomicInteger(0);
        AtomicInteger negative = new AtomicInteger(0);
        AtomicInteger zero = new AtomicInteger(0);

        arr.stream().forEach(n -> {
            if(n > 0)
                positive.addAndGet(1);
            if (n < 0)
                negative.addAndGet(1);
            if (n == 0)
                zero.addAndGet(1);
        });

        int positivet = positive.get();
        int arrsize = arr.size();
        Double positiveResult = Double.valueOf(positivet / arrsize);

        System.out.println(String.format("%.6f", positiveResult));
        System.out.println(String.format("%.6f", Double.valueOf(negative.get()) / Double.valueOf(arr.size())));
        System.out.println(String.format("%.6f", Double.valueOf(zero.get() / arr.size())));
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}