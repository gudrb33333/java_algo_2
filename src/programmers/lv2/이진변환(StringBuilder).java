class Solution {
    private int[] answer = {0, 0};
    
    
    public int[] solution(String s) {
        String remainStr = s;
        
        while (!remainStr.equals("1")) {
            String removedZoroStr = removeZero(remainStr);
            String changedToBinaryStr = changeToBinary(removedZoroStr.length());

            answer[0] += 1;
            remainStr = changedToBinaryStr;
        }
        
        return answer;
    }
    
    public String removeZero(String s) {
        String result = "";
        
        for (char c : s.toCharArray()) {
            if (c == '1') {
                result += "1";
            } else {
                answer[1] += 1;
            }
        }
        
        return result;
    }
    
    public String changeToBinary(int a) {
        StringBuilder result = new StringBuilder();
        
        while (a != 0) {
            int q = a / 2;
            int r = a % 2;
            result.insert(0, r);

            a = q;
        }

        return result.toString();
    }
    
}
