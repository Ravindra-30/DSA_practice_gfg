class Solution {
    public int median(int[][] mat) {
        // code here
        int m = mat.length, n = mat[0].length;
        int k = (m * n)/2, c = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < m; i++){
            pq.add(new int[]{mat[i][0], i, 1});
        }
        while(k > c){
            int arr[] = pq.poll();
            c++;
            int i = arr[1];
            int j = arr[2];
            if(j < n){
                pq.add(new int[]{mat[i][j], i, j + 1});
            }
        }
        return pq.poll()[0];
    }
}