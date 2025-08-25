class Solution {
    public int binarySearch(int arr[], int n, int k, int m, int min, int max){
        if(min == max){
            return min;
        }
        int mid = (min + max + 1)/2;
        int req = mid - arr[m];
        int in = m + 1;
        if(n % 2 == 0){
            req += mid - arr[m + 1];
            in = m + 2;
        }
        for(int i = in; i < n; i++){
            if(arr[i] >= mid || req > k){
                break;
            }
            req += mid - arr[i];
        }
        if(req > k){
            return binarySearch(arr, n, k, m, min, mid - 1);
        }
        return binarySearch(arr, n, k, m, mid, max);
    }
    public int maximizeMedian(int[] arr, int k) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int m = (n - 1)/2;
        int min = 0;
        if(n % 2 == 0){
            min = (arr[m] + arr[m + 1])/2;
        }
        else{
            min = arr[m];
        }
        int max = min + k;
        return binarySearch(arr, n, k, m, min, max);
    }
}
