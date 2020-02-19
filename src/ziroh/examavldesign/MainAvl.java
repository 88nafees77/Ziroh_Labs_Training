package ziroh.examavldesign;

public class MainAvl {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.setPipe(new CoPrime());
        tree.setPipe(new OddEven());
        tree.setPipe(new Prime());
        tree.insert(10);
        tree.insert(20);
        tree.insert(7);
        tree.insert(40);
        tree.insert(50);
        //      tree.removePipeLine(OddEven.class);
        tree.traverse();
        System.out.println(tree.search(40));

    }
}
