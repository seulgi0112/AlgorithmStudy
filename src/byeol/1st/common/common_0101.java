import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights){
        int cnt = 0, temp = 0;
        //대기열: FIFO (queue사용)
        Queue<Integer> q = new ConcurrentLinkedQueue<Integer>();
            
        //truck_weights에 담긴 값 하나씩 확인
        for(int i=0; i<truck_weights.length; i++){
            while(true){
                if(q.isEmpty()){                //q에 하나도 없을 때
                    q.add(truck_weights[i]);    //q에 트럭 추가
                    cnt++;
                    temp += truck_weights[i];
                    break;
                } else if(q.size() == bridge_length){
                    temp -= q.poll();
                    //q.poll();                     //q 맨 앞에 있는 트럭 꺼냄
                } else{                             //q에 truck이 다 안들어왔을 때 
                    if(weight < truck_weights[i] + temp){
                        cnt++;
                        q.add(0);
                    } else {
                        q.add(truck_weights[i]);
                        cnt++;
                        temp += truck_weights[i];
                        break;
                    }
                }
            }
        }
        return cnt+bridge_length;
    }
}

