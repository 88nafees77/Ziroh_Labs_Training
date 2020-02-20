package ziroh.examavldesign;

public class MainAvl {

    public static void main(String[] args) {
        Tree tree = new AVLTree();
        tree.setPipe(new CoPrime());
        tree.insert(10);
        tree.insert(6);
        tree.insert(3);
        tree.traverse();

    }
}
