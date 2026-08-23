class Solution {
    public void solve( int i, int n , int k  , List<Integer> list ,List<List<Integer>> ans) {
        if (list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>n){
            return;
        }
        
            list.add(i);
            solve(i+1, n , k, list , ans);
            list.remove(list.size()-1);
            solve(i+1,n,k ,list ,ans);
        }
    
    public List<List<Integer>> combine(int n , int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(1 ,n , k , list , ans);
        return ans;

    }
    }
        
    
