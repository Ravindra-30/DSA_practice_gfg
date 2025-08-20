class Solution {
    public boolean binarySearch(int [][]mat, int l, int r, int n, int m, int t, int x){
        // System.out.println(l + " " + r);
        if(l == r){
            int i = l / m;
            int j = l % m;
            return mat[i][j] == x;
        }
        int mid = (l + r)/2;
        int i = mid / m;
        int j = mid % m;
        int mx = mat[i][j];
        if(mx == x){
            return true;
        }
        
        int il = l / m;
        int jl = l % m;
        int lx = mat[il][jl];
        
        int ir = r / m;
        int jr = r % m;
        int rx = mat[ir][jr];
        // System.out.println(mx);
        if((mx > lx && x < mx && x >= lx) || (mx < lx && (x < mx || x >= lx))){
            return binarySearch(mat, l, mid - 1, n, m, t, x);
        }
        return binarySearch(mat, mid + 1, r, n, m, t, x);
        
    }
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length, m = mat[0].length, t = m * n;
        int l = 0, r = t - 1;
        return binarySearch(mat, l, r, n, m, t, x);
    }
}