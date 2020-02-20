package ziroh.examavldesign;

public class Node {

    /**
     * PipeLine head contains head of the list
     * height contains height of the current node
     * 
     */
    int key;
    int height=1;
    PipeLine head;

    public Node(int key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
