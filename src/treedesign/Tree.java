/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedesign;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author nafees
 */
public class Tree extends BSTmethods implements BSTOperations {

    TreeNode root = null;
    //Traversal traversal = new Traversal();

    @Override
    public void insert(int val) { /*this insert method takes value and insert*/

    }

    public boolean search(int key) { //This method is used for searched any key
        BST bst = new BST();
        return bst.searchEN(root, key);

    }

    public int countHeight(int keyy) {
        TreeNode key = new TreeNode();
        key.setData(keyy);
        return countHeight(root, key);
    }

    public int countHeight(TreeNode node, TreeNode key) {
        int count = 0;
        if (node == null) {
            return -1;
        }
        while (node != null) {
            if (node.getData() == key.getData()) {
                return count;
            }
            if (node.getData() > key.getData()) {
                node = node.getLeft();
                count++;
            } else if (node.getData() < key.getData()) {
                node = node.getRight();
                count++;
            }
        }
        return -1;

    }

    @Override
    public void inOrder() { //inorder traversor of BST
        BST bst = new BST();
        bst.inOrderEN(root);

    }

    @Override
    public void preOrder() { //preOrder traversor of BST
        BST bst = new BST();
        bst.preOrderEN(root);

    }

    @Override
    public void postorder() { //postorder traversor of BST
        BST bst = new BST();
        bst.postOrderEN(root);

    }

    @Override
    public int branches() {
        BST bst = new BST();
        return bst.branchesEN(root);

    }

    @Override
    public int noOfNodes() {
        BST bst = new BST();
        return bst.noOfNodesEN(root);

    }

    @Override
    public int noOfLeaf() {
        TreeNode tmp = root;
        if (tmp == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(tmp);
        int leaf = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode temp = queue.poll();
                if (temp.getLeft() == null && temp.getRight() == null) {
                    leaf++;
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }

            }

        }
        return leaf;

    }

    @Override
    public int noOfInternal() {
        TreeNode tmp = root;
        if (tmp == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(tmp);
        int nodes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode temp = queue.poll();
                if (temp.getLeft() != null && temp.getRight() != null || temp.getLeft() != null || temp.getRight() != null) {
                    nodes++;
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }

            }

        }
        return nodes - 1;

    }

    @Override
    public TreeNode getMinimum() {
        TreeNode tmp = root;
        //  tmp=root;
        if (tmp == null) {
            return null;
        }
        while (tmp.getLeft() != null) {
            tmp = tmp.getLeft();
        }
        return tmp;

    }

    @Override
    public TreeNode getMax() {
        TreeNode tmp = root;
        if (tmp == null) {
            return null;
        }
        while (tmp.getRight() != null) {
            tmp = tmp.getRight();
        }
        return tmp;
    }

    @Override
    public int getHeight() {
        BST bst = new BST();
        return bst.getHeightEN(root);
    }

    public void printAllBranches() {
        List<Integer> list = new ArrayList<>();
        printAllBranches(root, list);
    }

    private void printAllBranches(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.getData());
        if (node.getLeft() == null && node.getRight() == null) {
            System.out.println(list);
        }
        printAllBranches(node.getLeft(), list);
        printAllBranches(node.getRight(), list);
        list.remove(list.size() - 1);

    }

    public int maxBranch() {
        return maxBranch(root);
    }

    public int maxBranch(TreeNode node) {
        int count = 0;
        if (node == null) {
            return -1;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }
        int a = 1 + maxBranch(node.getLeft());
        int b = 1 + maxBranch(node.getRight());
        return Math.max(a, b);
    }

    public TreeNode inorderSuccessor(int key) {
        TreeNode suc = null;
        return inorderSuccessor(root, key, suc);
        //return suc;
    }

    private TreeNode inorderSuccessor(TreeNode node, int key, TreeNode suc) {
        if (node == null) {
            return null;
        }
        if (node.getData() == key) {
            if (node.getRight() != null) {
                TreeNode temp = node.getRight();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();

                }
                suc = temp;

            }

        }
        if (node.getData() > key) {
            suc = node;
            inorderSuccessor(node.getLeft(), key, suc);
        } else {
            inorderSuccessor(node.getRight(), key, suc);
        }
        return suc;
    }

    public TreeNode inorderPrecessor(int key) {
        TreeNode pre = null;
        return inorderPrecessor(root, key, pre);
    }

    private TreeNode inorderPrecessor(TreeNode node, int key, TreeNode pre) {
        if (node == null) {
            return null;
        }
        if (node.getData() == key) {
            if (node.getLeft() != null) {
                TreeNode temp = node.getLeft();
                while (temp.getRight() != null) {
                    temp = temp.getRight();

                }
                pre = temp;

            }

        } else {
            if (node.getData() < key) {
                pre = node;
                inorderPrecessor(node.getRight(), key, pre);
            } else {
                inorderPrecessor(node.getLeft(), key, pre);
            }
        }
        return pre;

    }

    public int branchEqualsTo(int k) {
        BST bst = new BST();
        return bst.branchEqualsTo(root, k);
    }

    public String serialization() {
        BST bst = new BST();
        return bst.serialization(root);
    }

    public void minSumBranch() {
        int min = 10000;
        int sum = 0;

        System.out.println(minSumBranch(root));
    }

    public int minSumBranch(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int a = minSumBranch(node.getLeft());
        int b = minSumBranch(node.getRight());
        if (a < b) {
            a = a + node.getData();
            return a;
        } else {
            b = b + node.getData();
            return b;
        }

    }

    public void maxSumBranch() {
        int max = 0;
        System.out.println(maxSumBranch(root));
    }

    public int maxSumBranch(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int a = maxSumBranch(node.getLeft());
        int b = maxSumBranch(node.getRight());
        if (a > b) {
            a = a + node.getData();
            return a;
        } else {
            b = b + node.getData();
            return b;
        }

    }

    public int leftMostSibling(int k) {
        int height = countHeight(k);
        if (height == -1) {
            return -1;
        }
        return leftMostSibling(root, height, k);
    }

    public int leftMostSibling(TreeNode node, int h, int k) {
        if (node == null || node.getData() == k) {
            return -1;
        }
        while (h != 0 && node != null) {
            if (node.getLeft() != null) {
                node = node.getLeft();
                h = h - 1;
            } else {
                node = node.getRight();
                h = h - 1;
            }
            if (node.getData() == k) {
                return -1;
            }
        }
        return node.getData();
    }

    public int rightMostSibling(int k) {
        int height = countHeight(k);
        if (height == -1) {
            return -1;
        }
        return rightMostSibling(root, height, k);
    }

    public int rightMostSibling(TreeNode node, int h, int k) {
        if (node == null || node.getData() == k) {
            return -1;
        }
        while (h != 0 && node != null) {
            if (node.getRight() != null) {
                node = node.getRight();
                h = h - 1;
            } else {
                node = node.getLeft();
                h = h - 1;
            }
            if (node.getData() == k) {
                return -1;
            }
        }
        return node.getData();
    }

    public int secondleftMostSibling(int key) {
        int height = countHeight(key);
        if (height == -1) {
            return -1;
        }
        int k = 1;
        return secondleftMostSibling(root, height, k);
    }

    public int secondleftMostSibling(TreeNode node, int h, int k) {
        if (node == null) {
            return 0;
        }
        if (h == 0 && k == 0) {
            return node.getData();
        }
        if (h == 0 && k != 0) {
            k--;
        }
        secondleftMostSibling(node.getLeft(), h - 1, k);
        return secondleftMostSibling(node.getRight(), h - 1, k);

    }

    public void pathPrint() {
        List<Integer> list = new ArrayList<>();
        int sum1 = maxSumBranch(root);
        int sum = 0;
        pathPrint(root, sum, list, sum1);
    }

    public void pathPrint(TreeNode node, int sum, List<Integer> list, int maxSum) {
        if (node == null) {
            return;
        }
        sum = sum + node.getData();
        list.add(node.getData());
        if (maxSum == sum) {
            System.out.println(list);
        }
        if (node.getLeft() != null) {
            pathPrint(node.getLeft(), sum, list, maxSum);
        }
        if (node.getRight() != null) {
            pathPrint(node.getRight(), sum, list, maxSum);
        }
        list.remove(list.size() - 1);
    }

}
