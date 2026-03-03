class Solution(object):
    def checkValidString(self, s):
        leftMin = 0
        leftMax = 0
        
        for ch in s:
            if ch == '(':
                leftMin += 1
                leftMax += 1
                
            elif ch == ')':
                leftMin -= 1
                leftMax -= 1
                
            else:  # '*'
                leftMin -= 1   # if treated as ')'
                leftMax += 1   # if treated as '('
            
            # If too many ')'
            if leftMax < 0:
                return False
            
            # leftMin cannot go below 0
            if leftMin < 0:
                leftMin = 0
        
        return leftMin == 0