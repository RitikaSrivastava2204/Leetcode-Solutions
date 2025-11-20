class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        Set<Integer> set = new HashSet<>();
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1] == nums2[p2]){
                set.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1]<nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }

        }
        int[] arr = new int[set.size()];
        int k = 0;
        for(int ele : set){
            arr[k++] = ele;
        }
        return arr;
    }
}