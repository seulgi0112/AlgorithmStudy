import java.util.LinkedList;
import java.util.Queue;

public class Common1 {

	/**
	 * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
	 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
	 * 트럭은 1초에 1만큼 움직이며, 
	 * 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
	 * @param bridge_length
	 * @param weight
	 * @param truck_weights
	 * @return
	 */
	 public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue<Integer> tqueue = new LinkedList<>(); //int형 queue 선언, linkedlist 이용
	        int totalWeight = 0;
	        for(int t : truck_weights)
	        {
	        	while(true)
	        	{
	        		//다리가 비어 있는 경우
	        		if(tqueue.isEmpty())
	        		{	
	        			tqueue.add(t);
	        			totalWeight += t;
	        			answer++;
	        			break;
	        		}
	        		//다리가 꽉찬 경우
	        		else if(tqueue.size()==bridge_length)
	        		{
	        			totalWeight -= tqueue.peek();
	        			tqueue.poll();
	        	
	        		}
	        		//다리가 비어있지도 않고 가득 차지도 않은 경우
	        		else
	        		{
	        			//다리가 견딜수 있는 무게보다 트럭의 무게 합이 적은 경우
	        			if(totalWeight + t <= weight)
	        			{
	        				tqueue.add(t);
	        				totalWeight += t;
	        				answer++;
	        				break;
	        			}
	        			//아닌경우 0으로 비어있는 공간 표시
	        			else {
	        				tqueue.add(0);
	        				answer++;
	        			}
	        		}
	        	}
	        }
	        //마지막 트럭이 건너는 시간 더해주기
	        answer = answer + bridge_length;
	        return answer;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		System.out.println("answer : " + solution(100,100,truck_weights) );
		
	}

}
