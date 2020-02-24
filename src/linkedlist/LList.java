/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Nafees Abdullah
 */
public class LList implements LinkedListMethods {
    
    Node head = null;
    
    @Override
    public void add(int key) {
        push(key, head);
    }
    
    private void push(int key, Node ptr) {
        Node newnode = new Node(key);
        if (ptr == null) {
            ptr = newnode;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newnode;
        }
    }
    
    @Override
    public int remove() {
        return -1;
    }

    public void traverse(Node node) {
        traverse(head, node);
    }

    private void traverse(Node root, Node node) {
        
    }
    
}
