
class Solution {
    int val=0;
    public void method(TreeNode root,StringBuilder sum){
        if(root==null) return;
        sum.append(root.val);
        if(root.left==null && root.right==null){
            val+=Integer.parseInt(sum.toString(),2);
        }else{
            method(root.left,sum);
            method(root.right,sum);
        }
        sum.deleteCharAt(sum.length()-1);
    }
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        method(root,sb);
        return val;
    }
}