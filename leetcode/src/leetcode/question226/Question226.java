package leetcode.question226;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @Author wushaoya
 * @date 2023-08-31
 * Time: 15:01
 */
public class Question226 {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left == null) {
            node.left = node.right;
            node.right = null;
            dfs(node.left);
            return;
        }
        if (node.right == null) {
            node.right = node.left;
            node.left = null;
            dfs(node.right);
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        dfs(node.left);
        dfs(node.right);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
