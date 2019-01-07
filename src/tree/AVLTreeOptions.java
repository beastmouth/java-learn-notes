package tree;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 16:08
 **/
public interface AVLTreeOptions {
    /**
     * 中序遍历
     *
     * @param current 目前节点
     * @author hbj
     * @date 2019/01/07
     */
    void infixOrder(AVLNode current);

    /**
     * 先序遍历
     *
     * @param current 目前节点
     * @author hbj
     * @date 2019/01/07
     */
    void preOrder(AVLNode current);

    /**
     * 后序遍历
     *
     * @param current 目前节点
     * @author hbj
     * @date 2019/01/07
     */
    void postOrder(AVLNode current);

    /**
     * 层级遍历
     *
     * @param root 根节点
     * @author hbj
     * @date 2019/01/07
     */
    void levelOrder(AVLNode root);
}
