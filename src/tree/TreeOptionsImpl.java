package tree;

import java.util.LinkedList;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 10:58
 **/

public class TreeOptionsImpl implements TreeOptions {
    @Override
    public TreeNode find(TreeNode root, int key) {
        TreeNode current = root;
        if (current == null) {
            return null;
        }
        while (current != null) {
            if (current.getData() > key) {
                current = current.getTreeNodeLeft();
            } else if (current.getData() < key) {
                current = current.getTreeNodeRight();
            } else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean insert(TreeNode root, int key) {
        TreeNode node = new TreeNode(key);
        if (root == null) {
            root = node;
            return true;
        } else {
            TreeNode current = root;
            TreeNode parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.getData() > key) {
                    current = current.getTreeNodeLeft();
                    if (current == null) {
                        parentNode.setTreeNodeLeft(node);
                        return true;
                    }
                } else {
                    current = current.getTreeNodeRight();
                    if (current == null) {
                        parentNode.setTreeNodeRight(node);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(int key) {
        return false;
    }

    /**
     * 中序遍历
     *
     * @param current 目前节点
     * @author hbj
     * @date 2019/01/07
     */
    @Override
    public void infixOrder(TreeNode current) {
        if (current != null) {
            infixOrder(current.getTreeNodeLeft());
            System.out.print(current.getData() + " ");
            infixOrder(current.getTreeNodeRight());
        }
    }

    /**
     * 先序遍历
     *
     * @param current 目前节点
     * @author hbj
     * @date 2019/01/07
     */
    @Override
    public void preOrder(TreeNode current) {
        if (current != null) {
            System.out.print(current.getData() + " ");
            preOrder(current.getTreeNodeLeft());
            preOrder(current.getTreeNodeRight());
        }
    }

    /**
     * 后序遍历
     *
     * @param current 目前节点
     * @author hbj
     * @date 2019/01/07
     */
    @Override
    public void postOrder(TreeNode current) {
        if (current != null) {
            postOrder(current.getTreeNodeLeft());
            postOrder(current.getTreeNodeRight());
            System.out.print(current.getData() + " ");
        }
    }

    /**
     * 层级遍历
     *
     * @param root 根节点
     * @author hbj
     * @date 2019/01/07
     */
    @Override
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode currentNode;
        while (!list.isEmpty()) {
            currentNode = list.poll();
            System.out.print(currentNode.getData() + " ");
            if (currentNode.getTreeNodeLeft() != null) {
                list.add(currentNode.getTreeNodeLeft());
            }
            if (currentNode.getTreeNodeRight() != null) {
                list.add(currentNode.getTreeNodeRight());
            }
        }
    }
}
