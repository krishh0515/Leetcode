class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    { 
        List <Integer> ans =new ArrayList<>();
        int[] hash=new int[1001]; 
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    if(hash[nums1[i]]==0)
                    {
                        ans.add(nums1[i]);
                        hash[nums1[i]]++; 
                    }
                }
            }
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) 
        {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}