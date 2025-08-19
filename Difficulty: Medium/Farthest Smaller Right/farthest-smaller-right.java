class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        // Code Here
        ArrayList<Integer> list = new ArrayList<>();
        
        int n = arr.length;
        int min[] = new int[n]; 
        for(int i = n - 1; i >= 0; i--){
            int num = arr[i];
            if(i == n - 1){
                list.add(-1);
                min[i] = num;
            }
            else{
                min[i] = Math.min(min[i + 1], num);
                if(min[i] == num){
                    list.add(-1);
                    continue;
                }
                int l = i + 1, r = n - 1, in = -1;
                while(l < r){
                    int mid = (l + r + 1)/2;
                    if(min[mid] >= num){
                        r = mid - 1;
                    }
                    else{
                        l = mid;
                    }
                }
                list.add(l);
            }
        }
        Collections.reverse(list);
        return list;
    }
}