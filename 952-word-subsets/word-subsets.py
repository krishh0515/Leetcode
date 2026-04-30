from collections import Counter

class Solution:
    def wordSubsets(self, words1, words2):
        
        # Step 1: build max frequency map
        maxFreq = [0] * 26
        
        for word in words2:
            count = Counter(word)
            for ch in count:
                idx = ord(ch) - ord('a')
                maxFreq[idx] = max(maxFreq[idx], count[ch])
        
        # Step 2: check words1
        result = []
        
        for word in words1:
            count = Counter(word)
            
            valid = True
            for i in range(26):
                if count.get(chr(i + ord('a')), 0) < maxFreq[i]:
                    valid = False
                    break
            
            if valid:
                result.append(word)
        
        return result