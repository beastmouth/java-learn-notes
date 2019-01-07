package tree;

import java.util.LinkedList;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 16:09
 **/

public class AVLTreeOptionsImpl implements AVLTreeOptions {
    @Override
    public void infixOrder(AVLNode current) {
        if (current != null) {
            infixOrder(current.getLeftChild());
            System.out.print(current.getData() + " ");
            infixOrder(current.getRightChild());
        }
    }

    @Override
    public void preOrder(AVLNode current) {
        if (current != null) {
            System.out.print(current.getData() + " ");
            preOrder(current.getLeftChild());
            preOrder(current.getRightChild());
        }
    }

    @Override
    public void postOrder(AVLNode current) {
        if (current != null) {
            postOrder(current.getLeftChild());
            postOrder(current.getRightChild());
            System.out.print(current.getData() + " ");
        }
    }

    @Override
    public void levelOrder(AVLNode root) {
        if (root == null) {
            return;
        }
        LinkedList<AVLNode> list = new LinkedList<>();
        list.add(root);
        AVLNode currentNode;
        while (!list.isEmpty()) {
            currentNode = list.poll();
            System.out.print(currentNode.getData() + " ");
            if (currentNode.getLeftChild() != null) {
                list.add(currentNode.getLeftChild());
            }
            if (currentNode.getRightChild() != null) {
                list.add(currentNode.getRightChild());
            }
        }
    }
}
