class Solution {
    public String solution(String s) {
        String[] strList = s.split(" ");
        int[] intList = new int[strList.length];
        
        for(int i=0; i<strList.length; i++) {
            intList[i] = Integer.parseInt(strList[i]);
        }
      
        int maxResult = -10000000;
        int minResult = 10000000;
            
        for(int item : intList) {
            maxResult = Math.max(item, maxResult);
            minResult = Math.min(item, minResult);
        }
        
        return String.valueOf(minResult) + " " + String.valueOf(maxResult);
    }
}
