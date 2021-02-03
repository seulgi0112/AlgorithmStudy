import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class byeol {

	/**
	 * n명의 사람들이 그룹으로 나뉘어져 있다. 
	 * 각각의 사람들은 고유 번호를 가지고 있다. (0 ~ n-1)
	 * 정수배열인 groupSizes가 주어진다. 
	 * groupSizes[i]는 i인 사람이 속해 있는 그룹의 크기를 뜻한다. 
	 * (예를 들어 groupSizes[1]=3이면, 1번 사람은 group 사이즈가 3인 곳에 있다.)
	 * i번 사람이 groupSizes[i]에 속해 있는 group의 리스트를 return하라.
	 * @param groupSizes
	 * @return
	 */
	
	public static List<List<Integer>> groupThePeople(int[] groupSizes)
	{
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
	
		//사람번호 저장 
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<groupSizes.length;i++)
		{
			//사람번호 , 그룹 크기
			map.put(i,groupSizes[i]);

		}
		//value로 정렬(오름차순)
		List<Integer> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
		
		//answer 만들기
		int count = 1;
		List<Integer> tempList = new ArrayList<Integer>();
		for(int key: keySetList)
		{
			if(map.get(key) == count)
			{
				if(count == 1)
				{
					tempList = new ArrayList<Integer>();
					tempList.add(key);
					answer.add(tempList);
				}
				else {
					tempList.add(key);
					answer.add(tempList);
					count = 1;
				}
			}
			else
			{
				if(count == 1)
				{
					tempList = new ArrayList<Integer>();
					tempList.add(key);
					count++;
				}
				else
				{
					tempList.add(key);
					count++;
				}
			}
		}
		System.out.println(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		int[] groupSizes = {2,2,1,1,1,1,1,1};
		groupThePeople(groupSizes);
	}

}
