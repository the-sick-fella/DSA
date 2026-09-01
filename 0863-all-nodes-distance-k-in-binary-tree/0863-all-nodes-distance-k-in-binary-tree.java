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
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                Set<TreeNode> set = map.getOrDefault(node, new HashSet<>());
                if(node.left != null){
                    q.offer(node.left);
                    set.add(node.left);

                    Set<TreeNode> ls = map.getOrDefault(node.left, new HashSet<>());
                    ls.add(node);
                    map.put(node.left, ls);
                }

                if(node.right != null){
                    q.offer(node.right);
                    set.add(node.right);

                    Set<TreeNode> rs = map.getOrDefault(node.right, new HashSet<>());
                    rs.add(node);
                    map.put(node.right, rs);
                }
                map.put(node, set);
            }
        }

// for (Map.Entry<TreeNode, Set<TreeNode>> entry : map.entrySet()) {
//     TreeNode node = entry.getKey();

//     System.out.print(node.val + " -> ");

//     for (TreeNode neighbour : entry.getValue()) {
//         System.out.print(neighbour.val + " ");
//     }

//     System.out.println();
// }
        q = new LinkedList<>();
        q.offer(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        for(int i = 0; i<k; i++){
            int size = q.size();

            for(int j = 0; j<size; j++){
                TreeNode node = q.poll();
                Set<TreeNode> nextSet = map.get(node);
                for(TreeNode temp : nextSet){
                    if(!visited.contains(temp)){
                        q.offer(temp);
                        visited.add(temp);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) list.add(q.poll().val);
        return list;
    }
}