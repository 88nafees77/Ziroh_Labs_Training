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
public class GenricMainClass {
    public static void main(String[] args){
        GenricBST<Integer> gbst =new GenricBST<Integer>();
        gbst.insert(7);
        gbst.insert(8);
        gbst.insert(6);
        gbst.insert(10);
        gbst.inOrder();
        
    }
}
