class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a== null || k<=0){
            return new int[0];

        }
        int n=a.length;
        int[] arr= new int [n-k+1];
        int po=0;
        Deque<Integer>q= new ArrayDeque<>();
        for (int i=0;i<a.length;i++){
            while(!q.isEmpty() && q.peek()<i-k+1){
                q.poll();
            }
            while(!q.isEmpty() && a[q.peekLast()]<a[i]){
                q.pollLast();
            }
                q.offer(i);
                if(i>=k-1){
                    arr[po++]=a[q.peek()];
                }
            }
            return arr;
        }
}
        
