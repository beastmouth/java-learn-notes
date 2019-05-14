package tree;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 14:36
 **/

public class AVLNode {
    private AVLNode parent;
    private AVLNode leftChild;
    private AVLNode rightChild;
    private int data;
    /**
     * 深度
     */
    private int depth;
    private int balance;

    public AVLNode(int data) {
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.data = data;
    }

    public AVLNode(AVLNode parent, AVLNode leftChild, AVLNode rightChild, int data, int depth, int balance) {
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
        this.depth = depth;
        this.balance = balance;
    }

    public AVLNode(int data, int depth) {
        this.data = data;
        this.depth = depth;
    }

    private int height(AVLNode node) {
        return null == node ? 0 : node.getDepth();
    }

    private int maxHeight(AVLNode leftChild, AVLNode rightChild) {
        return height(leftChild) > height(rightChild) ? height(leftChild) : height(rightChild);
    }

    /**
     * 左左旋转
     * O
     * O
     * O
     *
     * @param node 此时的根节点
     * @return AVLNode
     * @author hbj
     * @date 2019/01/07 17:25
     */
    private AVLNode leftLeftRotate(AVLNode node) {
        AVLNode newRoot = node.getLeftChild();
        node.setLeftChild(newRoot.getRightChild());
        newRoot.setRightChild(node);

        node.setDepth(maxHeight(node.getLeftChild(), node.getRightChild()) + 1);
        newRoot.setDepth(maxHeight(newRoot.getLeftChild(), newRoot.getRightChild()) + 1);
        return newRoot;
    }

    /**
     * 右右旋转
     * O
     * O
     * O
     *
     * @param node 此时的根节点
     * @return AVLNode
     * @author hbj
     * @date 2019/01/07 17:30
     */
    private AVLNode rightRightRotate(AVLNode node) {
        AVLNode newRoot = node.getRightChild();
        node.setRightChild(newRoot.getLeftChild());
        newRoot.setLeftChild(node);

        node.setDepth(maxHeight(node.getLeftChild(), node.getRightChild()));
        newRoot.setDepth(maxHeight(newRoot.getLeftChild(), newRoot.getRightChild()));
        return newRoot;
    }

    /**
     * 左右旋转  先右右再坐坐
     * O
     * O
     * O
     *
     * @param node 此时的根节点
     * @return AVLNode
     * @author hbj
     * @date 2019/01/07 17:31
     */
    private AVLNode leftRightRotate(AVLNode node) {
        node.setLeftChild(rightRightRotate(node.getLeftChild()));
        return leftLeftRotate(node);
    }

    /**
     * 右左旋转 先左左再右右
     * O
     * O
     * O
     *
     * @param node 此时的根节点
     * @return AVLNode
     * @author hbj
     * @date 2019/01/07 17:33
     */
    private AVLNode rightLeftRotate(AVLNode node) {
        node.setRightChild(leftLeftRotate(node.getRightChild()));
        return rightRightRotate(node);
    }

    public AVLNode insert(AVLNode root, int val) throws Exception {
        if (null == root) {
            AVLNode newNode = new AVLNode(val);
            return newNode;
        }
//        if (containData(root, val)) {
//            throw new Exception("This value is already exist!");
//        }
        if (root.parent != null) {
            if (root.parent.leftChild == root) {
                root.parent.leftChild = insertNode(root, val);
            } else {
                root.parent.rightChild = insertNode(root, val);
            }
        }
//        insertNode(root, val);
        return null;
    }

    private AVLNode insertNode(AVLNode parent, int val) {
//        if (null == parent) {
//            return new AVLNode(val);
//        }
        if (val < parent.getData()) {
            if (parent.getLeftChild() != null) {
                insertNode(parent.getLeftChild(), val);
            } else {
                System.out.println("22");
                AVLNode parentKNode = new AVLNode(val);
                parent.setLeftChild(parentKNode);
                parentKNode.parent = parent;

                AVLNode parentPNode = parent.parent;
                if (parentPNode != null) {
                    int depthDiff = height(parentPNode.leftChild) - height(parentKNode.rightChild);
                    if (depthDiff > 1) {
                        //左左型
                        leftLeftRotate(parentPNode);
                    } else if (depthDiff < -1) {
                        //右左型
                        rightLeftRotate(parentPNode);
                    }
                }
            }
        }
        if (val > parent.getData()) {
            if (parent.getRightChild() != null) {
                System.out.println("44");
                insertNode(parent.getRightChild(), val);
            } else {
                System.out.println("33");
                AVLNode parentKNode = new AVLNode(val);
                parent.setRightChild(parentKNode);
                parentKNode.parent = parent;

                AVLNode parentPNode = parent.parent;
                if (parentPNode != null) {
                    int depthDiff = height(parentPNode.leftChild) - height(parentKNode.rightChild);
                    if (depthDiff > 1) {
                        //左右型
                        leftRightRotate(parentKNode);
                    } else if (depthDiff < -1) {
                        //右右型
                        rightRightRotate(parentKNode);
                    }
                }
            }
        }

        return parent;
//        if (val < parent.getData()) {
//            parent.setLeftChild(insertNode(parent.getLeftChild(), val));
//
//            if (height(parent.getLeftChild()) - height(parent.getRightChild()) > 1) {
//                int compareVal = parent.getLeftChild().getData();
//                if (val < compareVal) {
//                    parent = leftLeftRotate(parent);
//                } else {
//                    parent = leftRightRotate(parent);
//                }
//            }
//        }

//        if (val > parent.getData()) {
//            parent.setRightChild(insertNode(parent.getRightChild(), val));
//            if (height(parent.getRightChild()) - height(parent.getLeftChild()) > 2) {
//                int compareVal = parent.getRightChild().getData();
//                if (val > compareVal) {
//                    parent = rightRightRotate(parent);
//                } else {
//                    parent = rightLeftRotate(parent);
//                }
//            }
//        }

//        parent.setDepth(maxHeight(parent.getLeftChild(), parent.getRightChild()) + 1);
//        return parent;
    }

    private boolean containData(AVLNode root, int val) {
        AVLNode current = root;
        if (current == null) {
            return false;
        }
        while (current != null) {
            if (current.getData() > val) {
                current = current.getLeftChild();
            } else if (current.getData() < val) {
                current = current.getRightChild();
            } else {
                return true;
            }
        }
        return false;
    }

//    public void insert(AVLNode current, int data) {
//        //插入元素
//        if (data < current.data) {
//            if (current.leftChild != null) {
//                insert(current.leftChild, data);
//            } else {
//                current.leftChild = new AVLNode(data);
//                current.leftChild.parent = current;
//            }
//        } else {
//            if (current.rightChild != null) {
//                insert(current.rightChild, data);
//            } else {
//                current.rightChild = new AVLNode(data);
//                current.rightChild.parent = current;
//            }
//        }
//
//        //计算平衡因子
//        current.balance = calcBalance(current);
//
//        //左子树高 应该右旋
//        if (current.balance >= 2) {
//            if (current.leftChild.balance == -1) {
//                leftRotate(current.leftChild);
//            }
//            rightRotate(current);
//        }
//
//        if (current.balance <= -2) {
//            if (current.rightChild.balance == 1) {
//                rightRotate(current.rightChild);
//            }
//            leftRotate(current);
//        }
//
//        current.balance = calcBalance(current);
//        current.depth = calcDepth(current);
//    }
//
//    public int calcBalance(AVLNode p) {
//        int leftDepth;
//        int rightDepth;
//
//        if (p.leftChild != null) {
//            leftDepth = p.leftChild.depth;
//        }else {
//            leftDepth = 0;
//        }
//
//        if (p.rightChild != null) {
//            rightDepth = p.rightChild.depth;
//        } else {
//            rightDepth = 0;
//        }
//
//        return leftDepth - rightDepth;
//    }
//
//    public int calcDepth(AVLNode p){
//        int depth = 0;
//        if (p.leftChild != null) {
//            depth = p.leftChild.depth;
//        }
//
//        if (p.rightChild != null && depth < p.rightChild.depth) {
//            depth = p.rightChild.depth;
//        }
//
//        depth++;
//        return depth;
//    }


//    /**
//     * 右旋
//     *
//     * @param p 节点
//     * @author hbj
//     * @date 2019/01/07
//     */
//    private void rightRotate(AVLNode p){
//        AVLNode pParent = p.parent;
//        AVLNode pLeftSon = p.leftChild;
//        AVLNode pRightGrandSon = pLeftSon.rightChild;
//
//        //左孩子变成父节点
//        pLeftSon.parent = pParent;
//        if (pParent != null) {
//            if (p == pParent.leftChild) {
//                pParent.leftChild = pLeftSon;
//            } else if (p == pParent.rightChild) {
//                pParent.rightChild = pLeftSon;
//            }
//        }
//
//        pLeftSon.rightChild = p;
//        p.parent = pLeftSon;
//
//
//        p.leftChild = pRightGrandSon;
//        if (pRightGrandSon != null) {
//            pRightGrandSon.parent = p;
//        }
//
//        p.depth = calcDepth(p);
//        p.balance = calcBalance(p);
//
//        pLeftSon.depth = calcDepth(pLeftSon);
//        pLeftSon.balance = calcBalance(pLeftSon);
//    }

//    /**
//     * 左旋
//     *
//     * @param p 节点
//     * @author hbj
//     * @date 2019/01/07
//     */
//    private void leftRotate(AVLNode p){
//        AVLNode pParent = p.parent;
//        AVLNode pRightSon = p.rightChild;
//        AVLNode pLeftGrandSon = pRightSon.leftChild;
//
//        //右孩子变成父节点
//        pRightSon.parent = pParent;
//        if (pParent != null) {
//            if (p == pParent.rightChild) {
//                pParent.rightChild = pRightSon;
//            } else if (p == pParent.leftChild) {
//                pParent.leftChild = pRightSon;
//            }
//        }
//
//        pRightSon.leftChild = p;
//        p.parent = pRightSon;
//
//        p.rightChild = pLeftGrandSon;
//        if (pLeftGrandSon != null) {
//            pLeftGrandSon.parent = p;
//        }
//
//        p.depth = calcDepth(p);
//        p.balance = calcBalance(p);
//
//        pRightSon.depth = calcDepth(pRightSon);
//        pRightSon.balance = calcBalance(pRightSon);
//    }


    public AVLNode getParent() {
        return parent;
    }

    public void setParent(AVLNode parent) {
        this.parent = parent;
    }

    public AVLNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLNode leftChild) {
        this.leftChild = leftChild;
    }

    public AVLNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
