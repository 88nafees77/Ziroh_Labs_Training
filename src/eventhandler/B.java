/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventhandler;

/**
 *
 * @author nafees
 */
public class B<T> implements INotify<T> {

    @Override
    public void notifyMsg(String msg, T val) {

        System.out.println(msg + val);
    }

}
