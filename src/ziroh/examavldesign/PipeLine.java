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
public interface PipeLine {

    void execute(Node node, int key);

    void setNext(PipeLine successor);

    PipeLine getNext();
}
