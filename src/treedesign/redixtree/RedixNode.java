/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedesign.redixtree;

/**
 *
 * @author nafees
 */
public class RedixNode {

    private String data;
    private RedixNode leftChild = null;
    private RedixNode rightChild = null;
    private boolean bool;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public RedixNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RedixNode leftChild) {
        this.leftChild = leftChild;
    }

    public RedixNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RedixNode rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
