package tree;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 10:02
 **/

public class TreeNode {
    private TreeNode treeNodeLeft;
    private TreeNode treeNodeRight;
    private int data;

    public TreeNode(int data) {
        this.treeNodeLeft = null;
        this.treeNodeRight = null;
        this.data = data;
    }

    public void display(){
        System.out.println(data);
    }

    public TreeNode getTreeNodeLeft() {
        return treeNodeLeft;
    }

    public void setTreeNodeLeft(TreeNode treeNodeLeft) {
        this.treeNodeLeft = treeNodeLeft;
    }

    public TreeNode getTreeNodeRight() {
        return treeNodeRight;
    }

    public void setTreeNodeRight(TreeNode treeNodeRight) {
        this.treeNodeRight = treeNodeRight;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
