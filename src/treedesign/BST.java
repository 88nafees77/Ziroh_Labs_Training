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
public class BST extends Tree {

    public void insert(int val) {
        TreeNode newnode = new TreeNode();
        newnode.setData(val);
        newnode.setLeft(null);
        newnode.setRight(null);
        if (root == null) {
            root = newnode;
        } else {
            TreeNode ptr = new TreeNode();
            TreeNode curr = null;
            ptr = root;
            while (ptr != null) {
                curr = ptr;
                if (ptr.getData() < val) {
                    ptr = ptr.getRight();
                } else {
                    ptr = ptr.getLeft();
                }
            }
            if (curr.getData() > val) {
                curr.setLeft(newnode);
            } else {
                curr.setRight(newnode);
            }

        }

    }

    public int getHeightEN(TreeNode node) {
        if (node == null) {
            return -1;
        }
        if (node.getLeft() == null && node.getRight() == null){
            return 1;
        }
        int a = 1 + getHeightEN(node.getLeft());
        int b = 1 + getHeightEN(node.getRight());
        return Math.max(a, b);
    }

    public void inOrderEN(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderEN(node.getLeft());
        System.out.println(node.getData());
        inOrderEN(node.getRight());
    }

    public void preOrderEN(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        preOrderEN(node.getLeft());
        preOrderEN(node.getRight());
    }

    public void postOrderEN(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderEN(node.getLeft());
        postOrderEN(node.getRight());
        System.out.println(node.getData());
    }

    public boolean searchEN(TreeNode node, int key) {
        if (node == null) {
            return false;
        }
        if (node.getData() == key) {
            return true;
        }
        if (node.getData() > key) {
            return searchEN(node.getLeft(), key);
        } else {
            return searchEN(node.getRight(), key);
        }

    }

    public int noOfNodesEN(TreeNode node) {
        int a = 1;
        if (node == null) {
            return 0;
        }
        if (node.getLeft() != null) {
            a = a + noOfNodesEN(node.getLeft());
        }
        if (node.getRight() != null) {
            a = a + noOfNodesEN(node.getRight());
        }
        return a;

    }

    public int branchesEN(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        int a = branchesEN(node.getLeft());
        int b = branchesEN(node.getRight());
        return a + b;
    }

    public int branchEqualsTo(TreeNode node, int k) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }
        int a = 0;
        if (node.getLeft() != null) {
            a += branchEqualsTo(node.getLeft(), k - 1);
        }
        if (node.getRight() != null) {
            a += branchEqualsTo(node.getRight(), k - 1);
        }
        return a;
    }

    public String serialization(TreeNode node) {
        if (node == null) {
            return "X";
        }
        String s1 = serialization(node.getLeft());
        String s2 = serialization(node.getRight());
        return node.getData() + "," + s1 + "," + s2;

    }
}
