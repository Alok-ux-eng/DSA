class Solution {
    public void solve(int[] candidates  , int target , List<Integer> list , Set<List<Integer>> ans ,int currSum , int i){
        if(currSum == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(currSum >target){
            return;
        }
        
        for(int j=i ; j<candidates.length;j++){
        if(j>i && candidates[j] == candidates[j-1]) continue;
        list.add(candidates[j]);
        solve(candidates , target , list , ans, currSum+candidates[j],j+1);
        list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<Integer> list = new ArrayList<>();
         Set<List<Integer>> ans = new HashSet<>();
         Arrays.sort(candidates);
         solve(candidates , target , list , ans, 0,0);
         return new ArrayList<>(ans);
    }
}