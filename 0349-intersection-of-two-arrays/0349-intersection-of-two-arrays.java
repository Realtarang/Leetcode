class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> t = new TreeSet<>();
        for(int num : nums1)
        {
            t.add(num);
        }

        TreeSet<Integer> result = new TreeSet<>();
        for(int num : nums2)
        {
            if(t.contains(num))
            {
                result.add(num);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for(int num : result)
        {
            arr[i++] = num;
        }

        return arr;        
    }
}