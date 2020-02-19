/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedesign.threadedbinarytree;

import javax.swing.tree.TreeNode;
import treedesign.Tree;

/**
 *
 * @author nafees
 */
public class ThreadedBST extends Tree {

    TNode root = null;

    public void insert(int val) {
        TNode newnode = new TNode();
        newnode.setData(val);
        newnode.setLeft(null);
        newnode.setRight(null);
        newnode.setInSuccessor(null);
        if (root == null) {
            root = newnode;
            root.setInSuccessor(newnode);
        } else {
            TNode ptr = new TNode();
            TNode curr = null;
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
            TNode temp = inOrderSuccessor(val);
            newnode.setInSuccessor(temp);

        }

    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println("node "+node.getData());
        if(node.getInSuccessor()!=null)
        System.out.println("nodeS "+node.getInSuccessor().getData());
        inOrder(node.getRight());
    }

    public TNode inOrderSuccessor(int key) {
        TNode suc = null;
        return inOrderSuccessor(root, key, suc);
    }

    private TNode inOrderSuccessor(TNode node, int key, TNode suc) {
        if (node == null) {
            return null;
        }
        if (node.getData() == key) {
            if (node.getRight() != null) {
                TNode temp = node.getRight();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();

                }
                suc = temp;

            }

        }
        if (node.getData() > key) {
            suc = node;
            inOrderSuccessor(node.getLeft(), key, suc);
        } else {
            inOrderSuccessor(node.getRight(), key, suc);
        }
        return suc;
    }

}
