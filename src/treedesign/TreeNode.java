/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedesign;

/**
 *
 * @author nafees
 */
class TreeNode {

    private int data; //this field is used for data;
    private TreeNode left = null;//to store left node address
    private TreeNode right = null;//to store right node address

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }


    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
