/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedesign.redixtree;

import treedesign.Tree;

/**
 *
 * @author nafees
 */
public class RedixTree extends Tree {

    RedixNode root = new RedixNode();
    RedixNode curr = null;

    public void insert(int val) {
        curr = root;
        String stringVal = changeBit(val);
        for (int i = 0; i < stringVal.length(); i++) {
            RedixNode newnode = new RedixNode();
            while (curr != null) {
                if (stringVal.charAt(i) == '0') {
                    if (curr.getLeftChild() != null) {

                    } else {
                        curr.setLeftChild(newnode);
                        curr = newnode;
                        curr.setData(curr.getData() + stringVal.charAt(i));
                        System.out.println(curr.getData());
                    }
                } else {
                    if (curr.getRightChild() != null) {

                    } else {
                        curr.setRightChild(newnode);
                        curr = newnode;
                        curr.setData(curr.getData() + stringVal.charAt(i));
                        System.out.println(curr.getData());
                    }
                }
            }

        }

    }

    public String changeBit(int k) {
        String str = "";
        while (k != 0) {
            int temp = k % 2;
            str = str + temp;
            k = k / 2;
        }
        return str;
    }

}
