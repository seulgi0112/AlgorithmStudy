class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> output = new ArrayList<>();
        int n = groupSizes.length;
        List<Integer> temp[] = new ArrayList[n+1];
        for(int i=0; i<n; i++){
            temp[i] = new ArrayList();
        }
        for(int i=0; i<n; i++){
            int x = groupSizes[i];
            temp[x].add(i);
            
            if(temp[x].size() == x){
                output.add(temp[x]);
                temp[x] = new ArrayList();
            }
        }
        return output;   
    }
     
}