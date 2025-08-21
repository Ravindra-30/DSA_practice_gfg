class Solution {
    public int binarySearch(int arr[], int n, int k, int l, int r){
        if(l == r){
            return l;
        }
        int mid = (l + r + 1)/2;
        int c = 1, j = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] - arr[j] >= mid){
                c++;
                j = i;
            }
        }
        if(c >= k){
            return binarySearch(arr, n, k, mid, r);
        }
        return binarySearch(arr, n, k, l, mid - 1);
    }
    public int maxMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length, min = Integer.MAX_VALUE, max = arr[n - 1] - arr[0];
        if(k == 2){
            return max;
        }
        for(int i = 1; i < n; i++){
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        return binarySearch(arr, n, k, min, max);
    }
}
