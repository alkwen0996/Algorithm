class Solution {
   public int solution(int[] cookie) {
        int leftSum, leftIdx;
        int rightSum, rightIdx;
        int answer = 0;
        
        for(int i = 0; i < cookie.length-1; i++) {   
            leftSum =cookie[i];
            leftIdx = i;
            rightSum =cookie[i+1];
            rightIdx = i+1; 
            while(true) {
                if(leftSum == rightSum && answer < leftSum) {
                    answer = leftSum;
                }
                if(leftIdx > 0 && leftSum <= rightSum) {
                    leftIdx--;
                    leftSum += cookie[leftIdx];
                }else if(rightIdx < cookie.length-1 && leftSum >= rightSum) {
                    rightIdx++;
                    rightSum += cookie[rightIdx];
                }else {
                    break;
                }
            }
        }
       
        return answer;
    }
}