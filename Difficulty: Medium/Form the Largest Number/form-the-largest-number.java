class Solution {
    public String findLargest(int[] arr) {
        // code here
        String[] boxed = Arrays.stream(arr).boxed().map(x -> String.valueOf(x)).toArray(String[]::new);
        Arrays.sort(boxed, (a, b) -> (b + a).compareTo(a + b));
        if(boxed[0].equals("0")){
            return "0";
        }
        // System.out.println(Arrays.toString(boxed));
        StringBuilder s = new StringBuilder();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            s.append(boxed[i]);
            
        }
        return s.toString();
    }
}