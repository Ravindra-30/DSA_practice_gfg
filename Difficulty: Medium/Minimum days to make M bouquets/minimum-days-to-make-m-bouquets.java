class Solution {
    public int check(int arr[], int val, int k){
        int c = 0, f = 0, n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] <= val){
                f++;
            }
            else{
                f = 0;
            }
            if(f == k){
                f = 0;
                c++;
            }
        }
        return c;
    }
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        int l = Integer.MAX_VALUE, r = 0;
        int n = arr.length;
        if(n < k * m){
            return -1;
        }
        for(int i = 0; i < n; i++){
            l = Math.min(l, arr[i]);
            r = Math.max(r, arr[i]);
        }
        while(l < r){
            int mid = (l + r)/2;
            if(check(arr, mid, k) >= m){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}