// stack 써서 안하구 그냥 for문으로.. 했음다...
class Solution{
    public int[] solution(int[] prices){
        int[] answer = new int[prices.length];
        //[i]랑 [i+1]~[last]까지 비교함
        
        for(int i=0; i<prices.length; i++){
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                cnt++;
                if(prices[i]>prices[j]) break;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}