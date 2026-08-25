class Solution {
    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        // Store all numbers
        for (int num : nums) {
            set.add(num);
        }

        // Check multiples of k
        for (int multiple = k; ; multiple += k) {

            if (!set.contains(multiple)) {
                return multiple;
            }
        }
    }
}