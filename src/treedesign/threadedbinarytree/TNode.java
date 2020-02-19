/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedesign.threadedbinarytree;

/**
 *
 * @author nafees
 */
public class TNode {

    private int data;
    private TNode left = null;
    private TNode right = null;
    private TNode inSuccessor = null;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getInSuccessor() {
        return inSuccessor;
    }

    public void setInSuccessor(TNode inSuccessor) {
        this.inSuccessor = inSuccessor;
    }

}
