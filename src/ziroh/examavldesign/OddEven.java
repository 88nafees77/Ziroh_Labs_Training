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
public class OddEven implements PipeLine {

    private PipeLine successor = null;

    @Override
    public void execute(Node node, int key) {
        if (key % 2 == 0) {
            System.out.println(key + "is a even");
        } else {
            System.out.println(key + "is a odd");
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
