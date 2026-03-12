public class DoWhileLoopAdvanced {

    // Validate a PIN (simulated)
    static int validatePin(int[] attempts, int correctPin) {
        int idx = 0, triesLeft = 3;
        do {
            int entered = attempts[idx++];
            triesLeft--;
            if (entered == correctPin) {
                System.out.println("  PIN accepted!");
                return idx;
            }
            if (triesLeft > 0) System.out.println("  Wrong PIN. Tries left: " + triesLeft);
            else System.out.println("  Account locked after 3 failed attempts.");
        } while (triesLeft > 0 && idx < attempts.length);
        return -1;
    }

    // Roman numeral converter
    static String toRoman(int num) {
        int[]    vals  = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] syms  = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do {
            while (num >= vals[i]) { sb.append(syms[i]); num -= vals[i]; }
            i++;
        } while (num > 0 && i < vals.length);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== PIN Validation ===");
        System.out.println("Test 1 (correct on 2nd try):");
        validatePin(new int[]{1234, 4321}, 4321);
        System.out.println("Test 2 (all wrong):");
        validatePin(new int[]{1111, 2222, 3333}, 4321);

        System.out.println("\n=== Roman Numerals ===");
        int[] nums = {1, 4, 9, 14, 40, 90, 399, 1994, 2024, 3999};
        for (int n : nums)
            System.out.printf("%5d = %s%n", n, toRoman(n));
    }
}
