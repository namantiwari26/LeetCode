class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int digit : digits){
            freq[digit]++;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=1;i<=9;i++){
            if(freq[i]==0) continue;
            freq[i]--;
            for(int j=0;j<=9;j++){
                if(freq[j]==0) continue;
                freq[j]--;
                for(int k=0;k<=8;k+=2){
                    if(freq[k]>0){
                        ans.add(100*i+j*10+k);
                    }
                }
                freq[j]++;
            }
            freq[i]++;
        }
        int[] result = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        return result;
    }
}