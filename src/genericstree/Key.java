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
public class Key implements Comparable<Key> {

    int value;
    String name;

    @Override
    public int compareTo(Key key) {
        
         // System.out.println(this.value<key.value);
          return 0;
    }

}
