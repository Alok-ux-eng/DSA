import java.util.*;

class Solution {

    long MOD = 1000000007;
    long BASE = 26;

    public String longestDupSubstring(String s) {

        int n = s.length();

        int low = 1;
        int high = n - 1;

        int bestStart = -1;
        int bestLen = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int start = check(s, mid);

            if (start != -1) {

                bestStart = start;
                bestLen = mid;

                low = mid + 1;
            } 
            else {

                high = mid - 1;
            }
        }

        if (bestStart == -1) {
            return "";
        }

        return s.substring(bestStart, bestStart + bestLen);
    }


    private int check(String s, int len) {

        int n = s.length();

        long power = 1;

        for (int i = 0; i < len; i++) {
            power = (power * BASE) % MOD;
        }

        long hash = 0;

        // Calculate first window hash
        for (int i = 0; i < len; i++) {

            hash = (hash * BASE + (s.charAt(i) - 'a' + 1)) % MOD;
        }

        HashMap<Long, List<Integer>> map = new HashMap<>();

        List<Integer> first = new ArrayList<>();
        first.add(0);

        map.put(hash, first);

        // Sliding Window + Rolling Hash
        for (int i = 1; i <= n - len; i++) {

            int outgoing = s.charAt(i - 1) - 'a' + 1;
            int incoming = s.charAt(i + len - 1) - 'a' + 1;

            hash = (hash * BASE - outgoing * power % MOD + incoming) % MOD;

            if (hash < 0) {
                hash += MOD;
            }

            if (map.containsKey(hash)) {

                for (int prev : map.get(hash)) {

                    if (s.substring(prev, prev + len)
                         .equals(s.substring(i, i + len))) {

                        return i;
                    }
                }
            }

            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(i);
        }

        return -1;
    }
}