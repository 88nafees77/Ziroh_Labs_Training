/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedesign;

import java.util.Scanner;
import treedesign.redixtree.RedixTree;
import treedesign.threadedbinarytree.ThreadedBST;

/**
 * 3
 * 43334234
 *
 * @author nafees
 */
public class Maintree {  //this will be our main method

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree tree = new BST();
        System.out.println("insert Value");
        int data;

        tree.insert(15);
        tree.insert(12);
        tree.insert(20);
        tree.insert(10);
        tree.insert(14);
        tree.insert(25);
        tree.insert(18);
        tree.insert(13);
        //tree.pathPrint();
        tree.pathPrint();

        // BST bst1=new BST();
        // tree.maxSumBranch();
      //  System.out.println(tree.secondleftMostSibling(18));

        //tree.inOrder();
   /*     ThreadedBST bst = new ThreadedBST();
         bst.insert(15);
         bst.insert(12);
         bst.insert(20);
         bst.insert(10);
         bst.insert(14);
         bst.insert(25);
         // System.out.println(bst.inorderSuccessor(12));
         bst.inOrder();
         // bst.branches();*/
        //     RedixTree redixTree=new RedixTree();
        //   redixTree.insert(8);
    }

}
