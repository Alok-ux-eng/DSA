class Solution {
    public char findTheDifference(String s, String t) {

        HashMap<Character , Integer > mp = new HashMap<>();
       // for (int num : nums);
       // mp.put(num,mp.getOrDefault(num,0)+1);
       for (char ch : s.toCharArray()){
        mp.put(ch, mp.getOrDefault(ch,0)+1);

       }

       for (char ch : t.toCharArray()) {

        if (!mp.containsKey(ch)) {
            return ch;
        }
        mp.put(ch,mp.get(ch)-1);

        if(mp.get(ch)==0) {
        mp.remove(ch);

       }
        
    }
    return ' ';

}
}