import java.util.Arrays;

public class Personal_0202 {
	/**
	 *  제한 사항
	 *  scoville의 길이는 2 이상 1,000,000 이하입니다.K는 0 이상 1,000,000,000 이하입니다.
	 *  scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
	 *  모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
	 * @param scoville
	 * @param K
	 * @return
	 */

	public static int solution(int[] scoville, int K) {
        int answer = 0;
        int count = 0;
        int length = scoville.length;
        Arrays.sort(scoville);
        
        for(int i=0;i<length-1;i++)
        {
        	//K보다 작을 때 
        	//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        	if(scoville[i]<K)
        	{
        		int tmpNum = scoville[i] + (scoville[i+1] * 2);
        		scoville[i] = 0;
        		scoville[i+1] = tmpNum;
        		Arrays.sort(scoville);
        		answer++;
        	}
        	//스코빌지수가 K이상인경우 ++
        	else if(scoville[i]>=K)
        	{
        		count++;
        	}
        }
        
        //모든음식의 스코빌지수가 K이상이 되지 않는 경우
        if(count == 0 && scoville[length-1] < K)
        {
        	answer = -1;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		//[1, 2, 3, 9, 10, 12], 7
		//[1, 1, 1], 4), 2)
		//[10, 10, 10, 10, 10], 100), 4)
		//[1, 2, 3, 9, 10, 12], 7), 2)
		//[0, 2, 3, 9, 10, 12], 7), 2)
		//[0, 0, 3, 9, 10, 12], 7), 3)
		//[0, 0, 0, 0], 7), -1)
		//[0, 0, 3, 9, 10, 12], 7000), -1)
		//[0, 0, 3, 9, 10, 12], 0), 0)
		//[0, 0, 3, 9, 10, 12], 1), 2)
		//[0, 0], 0), 0)
		//[0, 0], 1), -1)
		//[1, 0], 1), 1)
		int[] num = {1, 0};
		System.out.println(solution(num, 1));
		
	}
}
