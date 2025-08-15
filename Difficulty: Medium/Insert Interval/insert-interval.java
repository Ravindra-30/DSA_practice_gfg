class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int[]> arr = new ArrayList<>();
        int n = intervals.length, start = 1, end = -1;
        for(int i = 0; i < n; i++){
            if(intervals[i][1] < newInterval[0]){
                arr.add(intervals[i]);
                
            }
            else if(intervals[i][0] > newInterval[1]){
                if(start != -1){
                    arr.add(newInterval);
                    start = -1;
                }
                arr.add(intervals[i]);
            }
            else{
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
            
        }
        if(start != -1){
            arr.add(newInterval);
            start = -1;
        }
        return arr;
    }
}
