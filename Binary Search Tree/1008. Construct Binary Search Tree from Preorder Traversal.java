
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE,new int[1]);
    }
    public TreeNode helper(int[] arr,int lr,int rr,int[] idx){
        int i = idx[0];
        if(i == arr.length || lr > arr[i] || rr < arr[i]) return null;
        
        TreeNode root = new TreeNode(arr[i]);
        idx[0]++;
        
        root.left = helper(arr,lr,root.val,idx);
        root.right = helper(arr,root.val,rr,idx);
        
        return root;
    } 
}
