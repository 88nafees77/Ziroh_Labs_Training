package ziroh.examavldesign;

public class Node {

    int key;
    int height;
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
