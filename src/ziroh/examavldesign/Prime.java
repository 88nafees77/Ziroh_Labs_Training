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
public class Prime implements PipeLine {

    private PipeLine successor = null;

    @Override
    public void execute(Node node, int key) {
        int flag = 0;
        for (int i = 2; i < Math.sqrt(key); i++) {
            if (key % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println(key + "  " + "is a prime");
        } else {
            System.out.println(key + "  " + "is not a prime");
        }
        System.out.println("------------------");
        if (getNext() != null) {
            this.getNext().execute(node, key);
        }
    }

    @Override
    public void setNext(PipeLine successor) {
        this.successor = successor;
    }

    @Override
    public PipeLine getNext() {
        return successor;
    }

}
