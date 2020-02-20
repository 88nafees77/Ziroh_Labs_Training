package ziroh.examavldesign;

public class Tree {

    Node root = null;
    PipeLine pipe;

    /**
     *
     * @param setPipe methods is used for store the reference of PipeLine class
     * object;
     */
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

    /**
     * execute method() is responsible for run the all methods from the pipeLine
     *
     * @param node current Node
     * @param data key to be inserted
     */
    public void execute(Node node, int data) {
        if (pipe != null) {
            PipeLine head = pipe;
            while (head != null) {
                head.execute(node, data);
                head = head.getNext();
            }
        }

    }

    /**
     *
     * @param key
     */
    public void insert(int key) {
        if (root == null) {
            root = new RootNode(key);
            root.height = 0;
            return;
        }
        root = insert(root, key);
    }

    /**
     *
     * @param currNode root node
     * @param key
     * @return type will be Node
     */
    private Node insert(Node currNode, int key) {
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
                    //   execute(currNode, key);
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

        } else {
            return currNode;
        }
        return currNode;

    }

    /**
     *
     * @param key is to search into the search method
     * @return type of search method is boolean,if key is available then it wil
     * return true otherwise it should return false
     */
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

    /**
     *
     * @param obj LeafNode type object
     * @return type is Internal Node
     */
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

    /**
     *
     * @param node current node
     * @return type is int
     */
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

    /**
     * this method is used for remove the object from the pipeline
     *
     * @param line is a Pipeline type object
     */
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
