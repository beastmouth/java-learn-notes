package tree;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 13:55
 **/

public class TreeTest {
    public static void main(String[] args) throws Exception {
        AVLNode root = new AVLNode(3);
        AVLTreeOptionsImpl treeOptions = new AVLTreeOptionsImpl();
        root.insert(root, 4);
        root.insert(root, 6);
//        root.insert(root, 8);
//        root.insert(root, 7);
//        root.insert(root, 1);
//        root.insert(root, 2);
//        root.insert(root, 10);

        System.out.println("===========中序遍历===========");
        treeOptions.infixOrder(root);
        System.out.println();
        System.out.println("===========先序遍历============");
        treeOptions.preOrder(root);
        System.out.println();
        System.out.println("===========后序遍历============");
        treeOptions.postOrder(root);
        System.out.println();
        System.out.println("===========层级遍历============");
        treeOptions.levelOrder(root);
        System.out.println();
    }
}
