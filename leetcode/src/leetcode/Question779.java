package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 我们构建了一个包含 n 行(索引从 1 开始)的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数n和序数 k，返回第 n 行中第 k个字符。（k从索引 1 开始）
 *
 * @Author wushaoya
 * @date 2023-06-30
 * Time: 10:36
 */
public class Question779 {

    public static void main(String[] args) {
        int res = kthGrammar(2, 2);
        System.out.println(res);
    }

    public static int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
        // -------下面方法超出内存限制--------
        /*if (n == 1 || k == 1) {
            return 0;
        }
        TreeNode treeNode = new TreeNode(0, 1);
        initTree(2, treeNode, n);
        String res = levelOrder(treeNode).toString();
        return Integer.parseInt(res.substring(k - 1, k));*/
    }

    /**
     * 构建 n-1 层的树结构
     *
     * @param index
     * @param treeNode
     * @param n
     */
    public static void initTree(int index, TreeNode treeNode, int n) {
        if (index == n) {
            return;
        }
        if (treeNode.first == 0) {
            treeNode.setPrev(new TreeNode(0, 1));
            treeNode.setLast(new TreeNode(1, 0));
        } else {
            treeNode.setPrev(new TreeNode(1, 0));
            treeNode.setLast(new TreeNode(0, 1));
        }
        index++;
        initTree(index, treeNode.getPrev(), n);
        initTree(index, treeNode.getLast(), n);
    }

    /**
     * 二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public static StringBuilder levelOrder(TreeNode root) {
        // 存储结果的数组
        List<StringBuilder> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            StringBuilder str = new StringBuilder();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                str.append(node.first);
                str.append(node.two);
                if (node.prev != null) {
                    queue.offer(node.prev);
                }
                if (node.last != null) {
                    queue.offer(node.last);
                }
            }
            res.add(str);
        }
        return res.get(res.size() - 1);
    }

}

class TreeNode {
    TreeNode prev;
    TreeNode last;
    int first;
    int two;

    public TreeNode(int first, int two) {
        this.first = first;
        this.two = two;
    }

    public void setPrev(TreeNode prev) {
        this.prev = prev;
    }

    public void setLast(TreeNode last) {
        this.last = last;
    }

    public TreeNode getPrev() {
        return prev;
    }

    public TreeNode getLast() {
        return last;
    }
}
