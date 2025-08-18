class Solution {
    public int binarySearch(int[] citations, int n, int l, int r){
        if(l == r){
            return l;
        }
        int mid = (l + r + 1)/2;
        int c = 0;
        for(int i = 0; i < n; i++){
            if(citations[i] >= mid){
                c++;
            }
        }
        if(c >= mid){
            return binarySearch(citations, n, mid, r);
        }
        return binarySearch(citations, n, l, mid - 1);
    }
    public int hIndex(int[] citations) {
        // code here
        int n = citations.length, min = 0, max = n;
        return binarySearch(citations, n, min, max);
    }
}