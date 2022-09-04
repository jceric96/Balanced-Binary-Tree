public class Main3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        checkRange(root);
        return result;
    }

    public int checkRange(TreeNode node) {
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = checkRange(node.left);
        }
        if (node.right != null) {
            right = checkRange(node.right);
        }
        if (left - right != 0 && left - right != 1 && left - right != -1) {
            result = false;
            return 0;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Main3 tree = new Main3();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = null;
        root.right.right = null;

        System.out.println(tree.isBalanced(root));
    }
}
