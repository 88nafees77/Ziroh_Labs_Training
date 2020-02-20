/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziroh.examavldesign;

/**
 *
 * @author nafees
 */
public class CoPrime implements PipeLine {

    private PipeLine successor = null;

    @Override
    public void execute(Node node, int key) {
        int nodeVal = node.getKey();
        int coPrime = 0;
        for (int i = 1; i < nodeVal; i++) {
            if (nodeVal % i == 0 && nodeVal % i == 0) {
                coPrime = i;
            }
        }
        if (coPrime == 1) {
            System.out.println(node.getKey() + "  " + "and " + key + " " + "are coPrime");
        } else {
            System.out.println(node.getKey() + "  " + "and " + key + " " + "are not coPrime");
        }
        System.out.println("------------------");
        if (getNext() != null) {
            this.getNext().execute(node, key);
        }
    }

    @Override
    public PipeLine getNext() {
        return successor;
    }

    @Override
    public void setNext(PipeLine successor) {
        this.successor = successor;
    }

}
