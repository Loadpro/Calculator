package Calculator;

import java.util.TreeMap;
public class Conversion {
    TreeMap<Character, Integer> calculatorKeyMap = new TreeMap<>();
    TreeMap<Integer, String> rimKeyMap = new TreeMap<>();

    public Conversion() {
        calculatorKeyMap.put('I', 1);
        calculatorKeyMap.put('V', 5);
        calculatorKeyMap.put('X', 10);
        calculatorKeyMap.put('L', 50);
        calculatorKeyMap.put('C', 100);
        calculatorKeyMap.put('D', 500);
        calculatorKeyMap.put('M', 1000);

        rimKeyMap.put(1000, "M");
        rimKeyMap.put(900, "CM");
        rimKeyMap.put(500, "D");
        rimKeyMap.put(400, "CD");
        rimKeyMap.put(100, "C");
        rimKeyMap.put(90, "XC");
        rimKeyMap.put(50, "L");
        rimKeyMap.put(40, "XL");
        rimKeyMap.put(10, "X");
        rimKeyMap.put(9, "IX");
        rimKeyMap.put(5, "V");
        rimKeyMap.put(4, "IV");
        rimKeyMap.put(1, "I");

    }

    public boolean isCalulator(String number) {
        return calculatorKeyMap.containsKey(number.charAt(0));
    }
public String intToRim(int number) {
        String rim = "";
        int rimKey;
        do {
            rimKey = rimKeyMap.floorKey(number);
            rim += rimKeyMap.get(rimKey);
            number -= rimKey;
        } while (number != 0);
        return rim;
}
    public int rimeToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int rime;
        int result = calculatorKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            rime = calculatorKeyMap.get(arr[i]);

            if (rime < calculatorKeyMap.get(arr[i + 1])) {
                result -= rime;
            } else {
                result += rime;
            }


        }
        return result;

    }

}
