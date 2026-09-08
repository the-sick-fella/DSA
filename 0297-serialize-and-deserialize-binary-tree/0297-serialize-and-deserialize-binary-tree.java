/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (!q.isEmpty() && flag) {
            int size = q.size();
            flag = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node == null)
                    sb.append("null");
                else
                    sb.append(node.val);

                sb.append(',');

                if (node == null)
                    continue;

                q.offer(node.left);
                q.offer(node.right);
                if (node.left != null || node.right != null)
                    flag = true;
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if (s.length() == 0)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ',') {
                sb.append(s.charAt(i++));
            }

            i++;

            if (sb.toString().equals("null")) {
                q.offer(null);
            } else {
                int val = Integer.valueOf(sb.toString());

                TreeNode newNode = new TreeNode(val);
                q.offer(newNode);
            }
        }

        Queue<TreeNode> q2 = new LinkedList<>();
        TreeNode root = q.poll();
        q2.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q2.poll();

            if (node == null)
                continue;

            node.left = q.poll();
            q2.offer(node.left);

            node.right = q.poll();
            q2.offer(node.right);
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));