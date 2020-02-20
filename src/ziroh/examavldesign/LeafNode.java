package ziroh.examavldesign;
/**
 * LeafNode extends Node
 * @author nafees
 */
public class LeafNode extends Node {

    Node parent = null;

    public LeafNode(int key) {
        super(key);
        parent = null;
    }
}
