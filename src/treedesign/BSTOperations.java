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
// This is our abstract class,if we want to add more method in future
//we can easily add into this class
public interface BSTOperations {

    abstract void insert(int val);

    abstract boolean search(int key);

    abstract void inOrder();

    abstract void preOrder();

    abstract void postorder();

}
