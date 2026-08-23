class Solution {
    public void solve(int[] nums ,List<Integer>list , int i, Set<List<Integer>> ans) {
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        solve(nums,list,i+1,ans);
        list.add(nums[i]);
        solve(nums,list,i+1,ans);
        list.remove(list.size()-1);
        
    }
     public List<List<Integer>> subsetsWithDup(int[] nums) {
       Set<List<Integer>> ans = new HashSet<>();
       List<Integer> list = new ArrayList<>();
       Arrays.sort(nums);
       solve(nums , list , 0 , ans);
       return new ArrayList<>(ans);

     }

}