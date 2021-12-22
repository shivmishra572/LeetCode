class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combination2(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }
    
    private void combination2(List<List<Integer>> ans,List<Integer> temp,int[] cand,int target,int start){
        
        //Base Condition
        if(target == 0 && !ans.contains(temp)){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        //Recurrence Relation
        for(int i=start;i<cand.length && cand[i] <= target;i++){
            if( i>start && cand[i] == cand[i-1]){
                continue;
            }
            temp.add(cand[i]);
            combination2(ans,temp,cand,target-cand[i],i+1);
            temp.remove(temp.size()-1);
        }
    }
}
