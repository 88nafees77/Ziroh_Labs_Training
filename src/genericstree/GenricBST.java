/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericstree;

/**
 *
 * @author nafees
 */
public class GenricBST<T extends Comparable<T>> {
//BST<int> bst=new GenricBST<int>():

    Node<T> root = null;

    public void insert(T key) {
        Node<T> newnode = new Node<>();
        newnode.setValue(key);
        newnode.setLeftChild(null);
        newnode.setRightChild(null);
        if (root == null) {
            root = newnode;
        } else {
            Node<T> ptr = new Node<>();
            ptr = root;
            Node<T> curr = null;      
            while (ptr != null) {
                curr = ptr;
                int comp = key.compareTo(ptr.getValue());
                System.out.println(comp);
                if (comp == 1) {
                    ptr = ptr.getRightChild();
                } else {
                    ptr = ptr.getLeftChild();
                }
            }
            if (curr.getValue().compareTo(key)==-1) {
                curr.setRightChild(newnode);
            } else {
                curr.setLeftChild(newnode);
            }

        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        System.out.println(node.getValue());
        inOrder(node.getRightChild());
    }

}
