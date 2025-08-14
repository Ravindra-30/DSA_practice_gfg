class Solution {
    int getSum(int freq[], int index)
    {
        int sum = 0;
        index = index + 1;
        while(index>0)
        {
            sum += freq[index];
            index -= index & (-index);
        }
        return sum;
    }
    public static void updateBIT(int freq[], int n, int index, 
                                        int val)
    {
        index = index + 1;
        while(index <= n)
        {
            freq[index] += val;
            index += index & (-index);
        }
    }
    public int countRevPairs(int[] arr) {
        // code here
        int MAX = 50001;
        int freq[] = new int[MAX];
        int max = 0, n = arr.length, c= 0;
        for(int i = 0; i < n; i++){
            int num = arr[i];
            int x = 0;
            if(MAX > 2 * num)
                x = getSum(freq, 2 * num);
            c += (i - x);
            updateBIT(freq, MAX - 1, num, 1);
        }
        return c;
        
    }
}