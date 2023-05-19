class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> myList = new ArrayList<>();
        for (int i = 0; i < 2; i++)  {
            myList.add(new ArrayList<>());
        }

        Map<Integer, Boolean> myMap1 = new HashMap<>();
        Map<Integer, Boolean> myMap2 = new HashMap<>();
        for(int i = 0; i<nums1.length; i++)
        {
            myMap1.put(nums1[i], true);
        }
        for(int i = 0; i<nums2.length; i++)
        {
            myMap2.put(nums2[i], true);
        }
        for(int i = 0; i<nums1.length; i++)
        {
            if(!myMap2.getOrDefault(nums1[i], false)) 
            {
                myList.get(0).add(nums1[i]);
                myMap2.put(nums1[i], true);
            }
        }
        for(int i = 0; i<nums2.length; i++)
        {
            if(!myMap1.getOrDefault(nums2[i], false)) 
            { 
                myList.get(1).add(nums2[i]);
                myMap1.put(nums2[i], true);
            }
        }
        return myList;
    }
}
