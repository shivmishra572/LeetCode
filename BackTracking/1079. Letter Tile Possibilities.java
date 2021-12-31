//Approach 1

class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> ans = subset("",tiles);
        return ans.size();
    }
    
    public static HashSet<String> subset(String p,String up){
		//Base Condition
		if(up.length() == 0) {
			HashSet<String> temp = new HashSet<>();
			if(p.length() == 1) {
				temp.add(p);
			}
			else if(p.length() > 1){
				temp.addAll(combo("",p));
			}
			return temp;
		}
		
		HashSet<String> temp = new HashSet<>();
		temp.addAll(subset(p,up.substring(1)));
		temp.addAll(subset(p+up.charAt(0),up.substring(1)));
		
		return temp;
	}
	
	public static HashSet<String> combo(String p,String up){
		//Base Condition
		if(up.length() == 0) {
			HashSet<String> temp = new HashSet<>();
			temp.add(p);
			return temp;
		}
		
		HashSet<String> temp = new HashSet<>();
		//Recurrence Relation
		String copy_up = up.substring(1);
		for(int i=0;i<=p.length();i++) {
			String copy_p = p.substring(0,i)+up.charAt(0)+p.substring(i);
			temp.addAll(combo(copy_p,copy_up));	
		}	
		return temp;
	}
}
