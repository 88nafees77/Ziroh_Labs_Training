/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventhandler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nafees
 */
public class A<T> {
    
    T quan;
    
    A(T val) {
        this.quan = val;
    }
    
    A() {
        
    }
    List<INotify> list = new ArrayList<>();

    public void register() {
        B b = new B();
        C c = new C();
        D d = new D();
        
    }
    
    public void writeMsg() {
        for (INotify notify : list) {
            notify.notifyMsg("Your quantity getting low", quan);
        }
    }
    
}
