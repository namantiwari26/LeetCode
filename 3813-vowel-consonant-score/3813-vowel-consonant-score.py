class Solution:
    
    def vowelConsonantScore(self, s: str) -> int:
        v=c=0
        for ch in s:
            if ch.isalpha():
                if ch.lower() in 'aeiou':
                    v+=1
                else:
                    c+=1
                
        if c==0:
            return 0
        
        return v//c

             
        