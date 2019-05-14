package tree;

import java.util.LinkedList;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 10:58
 **/

public class TreeOptionsImpl implements TreeOptions {

    /**
     * 二叉查找树查找节点
     *
     * @param root 根节点
     * @param key  data值
     * @return treeNode
     * @author hbj
     * @date 2019/01/07
     */
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

    /**
     * 二叉查找树插入节点
     * 二月二十一号重写
     *
     * @param root 根节点
     * @param key  data值
     * @return treeNode
     * @author hbj
     * @date 2019/02/21
     */
    @Override
    public boolean insert(TreeNode root, int key) {
        TreeNode node = new TreeNode(key);
        if (root == null) {
            root = node;
            return true;
        }
        TreeNode current = root;
        while (current != null) {
            if (current.getData() > key) {
                if (current.getTreeNodeLeft() == null) {
                    current.setTreeNodeLeft(node);
                    return true;
                }
                current = current.getTreeNodeLeft();
            } else {
                if (current.getTreeNodeRight() == null) {
                    current.setTreeNodeRight(node);
                    return true;
                }
                current = current.getTreeNodeRight();
            }
        }
        return false;
    }


    /**
     * 二叉查找树删除节点
     *
     * @param key data值
     * @return boolean
     * @author hbj
     * @date 2019/02/21
     */
//    @Override
//    public boolean delete(TreeNode root,int key) {
    //原来的代码  还要多考虑一个是否为左子树 比较复杂
    //目前使用的是极客时间的代码
//        TreeNode deleteNode = root;
//        TreeNode deleteNodeParent = null;
//        boolean isLeft = false;
//
//        if (deleteNode == null) {
//            return false;
//        }
//
//        //寻找需要删除的节点和它的父节点
//        while (deleteNode.getData() != key) {
//            if (deleteNode.getData() > key) {
//                isLeft = true;
//                deleteNodeParent = deleteNode;
//                deleteNode = deleteNode.getTreeNodeLeft();
//            } else {
//                isLeft = false;
//                deleteNodeParent = deleteNode;
//                deleteNode = deleteNode.getTreeNodeRight();
//            }
//        }
//
//        //1.删除节点没有子节点：直接将父节点指向该节点的指针置空
//        if (deleteNode.getTreeNodeLeft() == null && deleteNode.getTreeNodeRight() == null) {
//            if (isLeft) {
//                deleteNodeParent.setTreeNodeLeft(null);
//                return true;
//            } else {
//                deleteNodeParent.setTreeNodeRight(null);
//                return true;
//            }
//        } else if (deleteNode.getTreeNodeLeft() != null && deleteNode.getTreeNodeRight() != null) {
//            //3.删除节点有两个子节点：要找到该节点的右子树的最小节点，将它替换到要删除的节点上。然后再删除这个最小节点
//            TreeNode deleteNodeRight = deleteNode.getTreeNodeRight();
//            TreeNode deleteNodeRightMin;
//            TreeNode deleteNodeRightMinParent;
//            while (deleteNodeRight != null) {
//                if (deleteNodeRight.getTreeNodeLeft() == null) {
//
//                }
//                deleteNodeRight = deleteNodeRight.getTreeNodeLeft();
//            }
//        } else {
//            //2.删除节点只有一个子节点：直接将子节点更新到父节点指向的指针即可
//            if (deleteNode.getTreeNodeLeft() != null) {
//                if (isLeft) {
//                    deleteNodeParent.setTreeNodeLeft(deleteNode.getTreeNodeLeft());
//                    return true;
//                } else {
//                    deleteNodeParent.setTreeNodeRight(deleteNode.getTreeNodeLeft());
//                    return true;
//                }
//            } else {
//                if (isLeft) {
//                    deleteNodeParent.setTreeNodeLeft(deleteNode.getTreeNodeRight());
//                    return true;
//                } else {
//                    deleteNodeParent.setTreeNodeRight(deleteNode.getTreeNodeRight());
//                    return true;
//                }
//            }
//        }
//    }
    @Override
    public void delete(TreeNode root, int data) {
        //原来的代码  还要多考虑一个是否为左子树 比较复杂
        //目前使用的是极客时间的代码
        TreeNode p = root;
        TreeNode pp = null;
        while (p != null && p.getData() != data) {
            pp = p;
            if (data > p.getData()) {
                p = p.getTreeNodeRight();
            } else {
                p = p.getTreeNodeLeft();
            }
        }
        if (p == null) {
            return;
        }

        if (p.getTreeNodeLeft() != null && p.getTreeNodeRight() != null) {
            TreeNode minP = p.getTreeNodeRight();
            TreeNode minPP = p;
            while (minP.getTreeNodeLeft() != null) {
                minPP = minP;
                minP = minP.getTreeNodeLeft();
            }

            p.setData(minP.getData());
            p = minP;
            pp = minPP;
        }

        TreeNode child;
        if (p.getTreeNodeLeft() != null) {
            child = p.getTreeNodeLeft();
        } else if (p.getTreeNodeRight() != null) {
            child = p.getTreeNodeRight();
        } else {
            child = null;
        }

        if (pp == null) {
            root = child;
        } else if (pp.getTreeNodeLeft() == p) {
            pp.setTreeNodeLeft(child);
        } else {
            pp.setTreeNodeRight(child);
        }

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
