/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedesign;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author nafees
 */
public abstract class BSTmethods {

    abstract int branches();

    abstract int noOfNodes();

    abstract int noOfLeaf();

    abstract int noOfInternal();

    abstract TreeNode getMax();

    abstract TreeNode getMinimum();

    abstract int getHeight();
   
}
