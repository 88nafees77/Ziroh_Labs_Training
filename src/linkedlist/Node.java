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
public class Node {

    int color=0;
    int vertices;
    int distance;
    Node next = null;

    public int getColor() {
        return color;
    }

    public Node(int v) {
        this.vertices = v;
    }

    public Node() {

    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
