class Solution {
    public void solve(int nums[] , boolean used[] , List<List<Integer>> ans , List<Integer> curr){

        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < nums.length ; i++){
            if(used[i] == true)continue;
            curr.add(nums[i]);
            used[i] = true;

            solve(nums, used , ans , curr);
            curr.remove(curr.size()-1);
            used[i] = false;
        }

    }
        public List<List<Integer>> permute(int[] nums) {
        boolean used [ ] = new boolean[nums.length] ;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        solve(nums,used,ans,curr);
        return ans;
        }
        
}
