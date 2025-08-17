class Solution {

    private int binarySearch(int arr[], int l, int r, int val){
        if(l == r){
            arr[l]--;
            return l;
        }
        int mid = (l + r)/2;
        if(arr[mid] < val){
            return binarySearch(arr, mid + 1, r, val);
        }
        return binarySearch(arr, l, mid, val);
    }
    public void rearrange(int[] arr, int x) {
        // code here
        int n = arr.length;
        int dif[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            dif[i] = Math.abs(arr[i] - x);
            q.add(arr[i]);
            
        }
        Arrays.sort(dif);
        for(int i = 0; i < n; i++){
            int v = q.poll();
            int val = Math.abs(x - v);
            int in = binarySearch(dif, 0, n - 1, val);
            arr[in] = v;
            // System.out.println(Arrays.toString(dif) + " " + in);
        }
        
    }
}
