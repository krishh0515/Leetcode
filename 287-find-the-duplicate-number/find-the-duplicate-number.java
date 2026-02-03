class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num :nums){
            if(!set.contains(num)){
                set.add(num);
            }
            else{
                return num;
            }
        }
        return -1;
    }
}