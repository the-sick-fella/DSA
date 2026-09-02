/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        getParents(root, map);
        getNodesAtDistance(map, target, k, list);
        return list;
    }

    void getParents(TreeNode node, Map<TreeNode, TreeNode> map){
        if(node.left != null){
            map.put(node.left, node);
            getParents(node.left, map);
        }
        if(node.right != null){
            map.put(node.right, node);
            getParents(node.right, map);
        }
    }

    void getNodesAtDistance(Map<TreeNode, TreeNode> map, TreeNode target, int k, List<Integer> list){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> vis = new HashSet<>();

        for(int i = 0; i<k; i++){
            int size = q.size();
            for(int j = 0; j<size; j++){
                TreeNode node = q.poll();
                vis.add(node);
                TreeNode parent = map.get(node);
                if(parent != null && !vis.contains(parent)) q.offer(parent);
                if(node.left != null && !vis.contains(node.left)) q.offer(node.left);
                if(node.right != null && !vis.contains(node.right)) q.offer(node.right);
            }
        }

        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
    }
}