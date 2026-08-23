class Solution {
    public void solve(int[] candidates , int target , List<Integer> list , List<List<Integer>> ans , int currSum , int i) {
        if(currSum == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>=candidates.length || currSum > target ) {
            return;
        }
        list.add(candidates[i]);
        solve(candidates , target ,list , ans , currSum + candidates[i],i);
        list.remove(list.size()-1);
        solve(candidates , target , list , ans , currSum , i+1);  
    }
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target , list , ans, 0 , 0);
        return ans;

}
}