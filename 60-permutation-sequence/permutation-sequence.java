class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();

        int fact = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);

            if (i < n) {
                fact *= i;
            }
        }
        k--;

        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            int index = k / fact;

            ans.append(numbers.get(index));
            numbers.remove(index);

            k = k % fact;
            n--;

            if (n > 0) {
                fact /= n;
            }
        }

        return ans.toString();
    }
}