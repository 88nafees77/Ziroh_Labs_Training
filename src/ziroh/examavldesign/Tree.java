package ziroh.examavldesign;

public class Tree {

    Node root = null;
    PipeLine pipe;

    public void setPipe(PipeLine p) {
        if (pipe == null) {
            pipe = p;
        } else {
            PipeLine tmp = pipe;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(p);
        }
    }

    private void execute(Node node, int data) {
        if (pipe != null) {
            PipeLine head = pipe;
            while (head != null) {
                head.execute(node, data);
                head = head.getNext();
            }
        }

    }

    public void insert(int key) {
        if (root == null) {
            root = new RootNode(key);
            root.height = 0;
            return;
        }
        root = insert(root, key);
    }

    private Node insert(Node currNode, int key) {

        Node newnode = new LeafNode(key);
        if (currNode instanceof RootNode) {

            if (currNode.key > key) {
                if (((RootNode) currNode).left != null) {
                    execute(newnode, key);
                    ((RootNode) currNode).left = insert(((RootNode) currNode).left, key);
                    //  currNode = ((RootNode) currNode).left;

                } else {
                    ((RootNode) currNode).left = newnode;
                    return currNode;
                }

            } else {
                if (((RootNode) currNode).right != null) {
                    execute(newnode, key);
                    ((RootNode) currNode).right = insert(((RootNode) currNode).right, key);

                } else {
                    ((RootNode) currNode).right = newnode;
                    return currNode;
                }
            }

        } else if (currNode instanceof InternalNode) {

            if (currNode.key > key) {
                if (((InternalNode) currNode).left != null) {
                    execute(newnode, key);
                    ((InternalNode) currNode).left = insert(((InternalNode) currNode).left, key);
                } else {
                    ((InternalNode) currNode).left = newnode;

                    return currNode;

                }

            } else {
                if (((InternalNode) currNode).right != null) {
                    execute(newnode, key);
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

        } else {
            return currNode;
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

        return currNode;

    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }
        while (node != null) {
            if (node instanceof RootNode) {
                if (((RootNode) node).key == key) {
                    return true;
                }
                if (((RootNode) node).key > key) {
                    node = ((RootNode) node).left;
                } else {
                    node = ((RootNode) node).right;
                }
            } else if (node instanceof InternalNode) {
                if (((InternalNode) node).key == key) {
                    return true;
                }
                if (((InternalNode) node).key > key) {
                    node = ((InternalNode) node).left;
                } else {
                    node = ((InternalNode) node).right;
                }
            } else if (node instanceof LeafNode) {
                if (((LeafNode) node).key == key) {
                    return true;
                } else {
                    return false;
                }
            }

        }
        return false;

    }

    public InternalNode leafToInternal(LeafNode obj) {
        return new InternalNode(obj.key);

    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node node) {
        if (node == null) {
            return;
        }
        if (node instanceof RootNode) {
            System.out.println(((RootNode) node).height);
        }

    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public int getheight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        if (node instanceof RootNode) {
            return getheight(((RootNode) node).left) - getheight(((RootNode) node).right);
        }
        if (node instanceof InternalNode) {
            return getheight(((InternalNode) node).left) - getheight(((InternalNode) node).right);
        } else {
            return 0;

        }

    }

    public void removePipeLine(Class line) {
        if (pipe != null) {

            while (pipe != null && pipe.getClass() == line) {
                pipe = pipe.getNext();
            }
            PipeLine head = pipe.getNext();
            PipeLine pre = pipe;
            while (head != null) {
                if (head.getClass() == line) {
                    pre.setNext(head.getNext());
                    head = pre.getNext();
                    continue;
                }

                pre = head;
                head = head.getNext();
            }
        }
    }

}
