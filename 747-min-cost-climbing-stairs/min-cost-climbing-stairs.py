class Solution(object):
    def minCostClimbingStairs(self, cost):
        n=len(cost)
        dp=[0]*(n+1)
        prev,curr=0,0
        for i in range(2,n+1):
            prev,curr=curr,min(cost[i-2]+prev,cost[i-1]+curr)
        return curr