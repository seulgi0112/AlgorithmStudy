function solution(bridge_length, weight, truck_weights){
    var answer = 0;
    //1. 대기열 생성
    var truckQ = [];
    var cnt = 0;
    var temp = 0;
    //2. 대기열 크기가 bridge-length와 동일한지 확인
    truck_weights.forEach(element => {
        while(true){
            if(truckQ.length == 0){
                truckQ.push(element);
                cnt ++;
                temp += element;
                break;
            } else if (truckQ.length == bridge_length){
                //get first element in array : array.shift() 
                temp -= truckQ.shift();
            } else {
                if(weight < temp + element){
                    truckQ.push(0);
                    cnt++;
                } else {
                    truckQ.push(element);
                    cnt++;
                    temp += element;
                    break;
                }
            }
        }
    });
    return bridge_length + cnt;
}
solution(2,10,[7,4,5,6]);