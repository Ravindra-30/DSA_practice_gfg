class Solution {
    public int binarySearch(int arr[], int l, int r, int val){
        if(arr[r] < val){
            return r + 1;
        }
        if(arr[l] > val){
            return l;
        }
        if(l == r){
            return l;
        }
        int mid = (l + r)/2;
        if(arr[mid] < val){
            return binarySearch(arr, mid + 1, r, val);
        }
        return binarySearch(arr, l, mid, val);
    }
    public int mergeSort(int arr[], int n, int l, int r){
        if(l == r){
            return 0;
        }
        int mid = (l + r)/2;
        int c = 0;
        c += mergeSort(arr, n, l , mid);
        c += mergeSort(arr, n, mid + 1 , r);
        int nums[] = new int[r - l + 1];
        for(int i = mid + 1; i <= r; i++){
            c += mid  + 1 - binarySearch(arr, l, mid, 2 * arr[i] + 1);
        }
        int j = l, k = mid + 1;
        for(int i = 0; i < nums.length; i++){
            if(j > mid || (k <= r && arr[j] >= arr[k])){
                nums[i] = arr[k];
                k++;
            }
            else{
                nums[i] = arr[j];
                j++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            arr[l + i] = nums[i];
        }
        return c;
    }
    public int countRevPairs(int[] arr) {
        // code here
        int n = arr.length;
        return mergeSort(arr, n, 0, n - 1);
    }
}
