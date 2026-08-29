/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair {
    boolean found;
    TreeNode node;

    public Pair(boolean found, TreeNode node) {
        this.found = found;
        this.node = node;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Pair pair = new Pair(false, null);
        Set<Integer> list = f(root, p, q, pair);
        return pair.node;
    }

    Set<Integer> f(TreeNode node, TreeNode p, TreeNode q, Pair pair) {
        Set<Integer> set = new HashSet<>();
        set.add(node.val);

        if(node.left != null){
            Set<Integer> ls = f(node.left, p, q, pair);
            if(pair.found) return set;
            for(int val : ls) set.add(val);
        }
        
        if(set.contains(p.val) && set.contains(q.val)){
            pair.found = true;
            pair.node = node;
        }

        if(node.right != null){
            Set<Integer> rs = f(node.right, p, q, pair);
            if(pair.found) return set;
            for(int val : rs) set.add(val);
        }

        if(set.contains(p.val) && set.contains(q.val)){
            pair.found = true;
            pair.node = node;
        }
        return set;
    }
}