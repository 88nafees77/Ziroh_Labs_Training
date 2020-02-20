/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ziroh.examavldesign;

/**
 * AVL class extends Tree Class
 *
 * @author nafees
 */
public class AVLTree extends Tree {

    public void insert(int key) {
        if (root == null) {
            root = new RootNode(key);
            root.height = 0;
            return;
        }
        root = insert(root, key);
    }

    public Node insert(Node currNode, int key) {
        if (currNode != null) {
            execute(currNode, key);
        }

        Node newnode = new LeafNode(key);
        if (currNode instanceof RootNode) {

            if (currNode.key > key) {
                if (((RootNode) currNode).left != null) {

                    ((RootNode) currNode).left = insert(((RootNode) currNode).left, key);

                } else {
                    ((RootNode) currNode).left = newnode;
                    return currNode;
                }

            } else {
                if (((RootNode) currNode).right != null) {
                    //   execute(currNode, key);
                    ((RootNode) currNode).right = insert(((RootNode) currNode).right, key);

                } else {
                    ((RootNode) currNode).right = newnode;
                    return currNode;
                }
            }

        } else if (currNode instanceof InternalNode) {

            if (currNode.key > key) {
                if (((InternalNode) currNode).left != null) {

                    ((InternalNode) currNode).left = insert(((InternalNode) currNode).left, key);
                } else {
                    ((InternalNode) currNode).left = newnode;

                    return currNode;

                }

            } else {
                if (((InternalNode) currNode).right != null) {
                    // execute(currNode, key);
                    ((InternalNode) currNode).right = insert(((InternalNode) currNode).right, key);

                } else {
                    ((InternalNode) currNode).right = newnode;

                    return currNode;
                }
            }
        } else if (currNode instanceof LeafNode) {
            currNode = leafToInternal((LeafNode) currNode);

            if (currNode.key > key) {

                ((InternalNode) currNode).left = newnode;

                return currNode;

            } else {

                ((InternalNode) currNode).right = newnode;

                return currNode;
            }

        }
        int balance = 0;
        if (currNode instanceof RootNode) {
            ((RootNode) currNode).height = 1 + max(getheight(((RootNode) currNode).left), getheight(((RootNode) currNode).right));
            balance = getBalanceFactor(currNode);
        } else if (currNode instanceof InternalNode) {
            ((InternalNode) currNode).height = 1 + max(getheight(((InternalNode) currNode).left), getheight(((InternalNode) currNode).right));
            balance = getBalanceFactor(currNode);
        } else {
            currNode.height = 0;
        }
        if (currNode instanceof RootNode) {
            if (balance > 1 && key < ((RootNode) currNode).left.key) {
                System.out.println("--...." + rightRightRotate(currNode));
                return rightRightRotate(currNode);
            }
        }
        if (currNode instanceof RootNode) {
            if (balance > 1 && key > ((RootNode) currNode).left.key) {
                System.out.println("--...." + leftLeftRotation(currNode));
                return leftLeftRotation(currNode);
            }
        }

        return currNode;

    }

    public Node rightRightRotate(Node node) {

        if (node instanceof RootNode) {
            Node y = ((RootNode) node).left;
            if (y instanceof InternalNode) {
                if (((InternalNode) y).right == null) {
                    ((InternalNode) y).right = node;
                    y = internalToRoot((InternalNode) y);
                    node = rootToLeaf((RootNode) node);
                }
            }
            if (node instanceof LeafNode) {
                ((LeafNode) node).height = 1;
            }
            if (y instanceof RootNode) {
                ((RootNode) y).height = 1 + max(getheight(((RootNode) y).left), getheight(((RootNode) y).right));
                return y;
            }

        }

        return null;

    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public Node leftLeftRotation(Node node) {
        if (node instanceof RootNode) {
            Node y = ((RootNode) node).right;
            if (y instanceof InternalNode) {
                if (((InternalNode) y).left == null) {
                    ((InternalNode) y).left = node;
                    node = rootToLeaf((RootNode) node);
                    y = internalToRoot((InternalNode) y);
                }
                if (y instanceof RootNode) {
                    ((RootNode) y).height = 1 + max(getheight(((RootNode) y).left), getheight(((RootNode) y).right));
                    return y;
                }
                if (node instanceof LeafNode) {
                    ((LeafNode) node).height = 1;
                }
            }
        }
        return null;
    }

    public void traverse() {
        super.traverse();
    }

    public LeafNode rootToLeaf(RootNode obj) {
        return new LeafNode(obj.key);

    }

    public RootNode internalToRoot(InternalNode obj) {
        return new RootNode(obj.key);

    }
}
