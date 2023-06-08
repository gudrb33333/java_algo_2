class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;
        
        String[] strArr = s.split(" ");
        
        for ( String item : strArr ) {
            int intItem = Integer.valueOf(item);
            min = Math.min(intItem, min);
            max = Math.max(intItem, max);
        }
        
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}
