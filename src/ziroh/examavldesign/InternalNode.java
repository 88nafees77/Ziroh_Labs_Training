package ziroh.examavldesign;

public class InternalNode extends Node {

    Node parent, left, right;

    public InternalNode(int key) {
        super(key);
        parent = null;
        left = null;
        right = null;

    }
}
