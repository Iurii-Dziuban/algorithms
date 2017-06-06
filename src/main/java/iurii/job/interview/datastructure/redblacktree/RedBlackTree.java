package iurii.job.interview.datastructure.redblacktree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

// not compelete implementation . hibbard deletion is not mentioned
public class RedBlackTree<K extends Comparable<K>, V> {
    // copied from BST
    private Node<K, V> root;

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node<K, V> current = root;
        while (current != null) {
            if (current.getKey().compareTo(key) == 0) {
                return current.getValue();
            } else {
                if (current.getKey().compareTo(key) > 0) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
        }
        throw new NoSuchElementException();
    }

    public int size() {
        return size(root);
    }

    private int size(Node<K, V> node) {
        if (node == null) {
            return 0;
        } else {
            return node.getCount();
        }
    }

    public int rank(K key) {
        return rank(key, root);
    }

    private int rank(K key, Node<K, V> node) {
        if (node == null) {
            return 0;
        }
        int cmp = node.getKey().compareTo(key);
        if (cmp == 0) {
            return size(node.getLeft());
        }
        if (cmp < 0) {
            return rank(key, node.getRight()) + size(node.getLeft()) + 1;
        } else {
            return rank(key, node.getLeft());
        }
    }

    public Iterator<K> iterator() {
        Queue<K> keys = new ArrayDeque<K>();
        inorder(keys, root);
        return keys.iterator();
    }

    private void inorder(Queue<K> keys, Node<K, V> node) {
        if (node == null) {
            return;
        }
        inorder(keys, node.getLeft());
        keys.add(node.getKey());
        inorder(keys, node.getRight());
    }

    public K floor(K key) {
        Node<K, V> node = floor(root, key);
        if (node == null) {
            return null;
        } else {
            return node.getKey();
        }
    }


    private Node<K, V> floor(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        } else {
            int cmp = node.getKey().compareTo(key);
            if (cmp == 0) {
                return node;
            }
            if (cmp > 0) {
                return floor(node.getLeft(), key);
            } else {
                Node<K, V> right = floor(node.getRight(), key);
                if (right == null) {
                    return node;
                } else {
                    return right;
                }
            }
        }
    }

    public K ceiling(K key) {
        Node<K, V> node = ceiling(root, key);
        if (node == null) {
            return null;
        } else {
            return node.getKey();
        }
    }


    private Node<K, V> ceiling(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        } else {
            int cmp = node.getKey().compareTo(key);
            if (cmp == 0) {
                return node;
            }
            if (cmp < 0) {
                return ceiling(node.getRight(), key);
            } else {
                Node<K, V> left = ceiling(node.getLeft(), key);
                if (left == null) {
                    return node;
                } else {
                    return left;
                }
            }
        }
    }
    //end copied from bst

    private boolean isRed(Node<K, V> node) {
        if (node == null) {
            return false;
        }
        return node.isRed();
    }

    private Node<K, V> rotateLeft(Node<K, V> h) {
        assert isRed(h.getRight());
        Node<K, V> x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        x.setRed(h.isRed());
        h.setRed(true);
        return x;
    }

    private Node<K, V> rotateRight(Node<K, V> h) {
        assert isRed(h.getLeft());
        Node<K, V> x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        x.setRed(h.isRed());
        h.setRed(true);
        return x;
    }

    private void flipColors(Node<K, V> h) {
        assert !isRed(h);
        assert isRed(h.getLeft());
        assert isRed(h.getRight());
        h.setRed(true);
        h.getLeft().setRed(false);
        h.getLeft().setRed(false);
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<K, V>(key, value, true);
        }
        int cmp = key.compareTo(node.getKey());
        if (cmp == 0) {
            node.setValue(value);
        } else {
            if (cmp > 0) {
                node.setRight(put(node.getRight(), key, value));
            } else {
                node.setLeft(put(node.getLeft(), key, value));
            }
        }
        node.setCount(1 + size(node.getLeft()) + size(node.getRight()));
        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && !isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }
        return node;
    }

    public void hibbardDelete(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        root = delete(key, root);
    }

    private Node<K, V> delete(K key, Node<K, V> node) {
        if (node == null) {
            return null;
        }
        int cmp = node.getKey().compareTo(key);
        if (cmp < 0) {
            delete(key, node.getRight());
            return node;
        } else if (cmp > 0) {
            node.setLeft(delete(key, node.getLeft()));
        } else {
            if (node.getRight() == null) {
                return node.getLeft();
            }
            Node<K, V> current = node;
            node = min(current.getRight());
            node.setRight(deleteMin(current.getRight()));
            node.setLeft(current.getLeft());
        }
        node.setCount(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node.getRight();
        } else {
            node.setLeft(deleteMin(node.getLeft()));
            node.setCount(1 + size(node.getLeft()) + size(node.getRight()));
            return node;
        }
    }

    private Node<K, V> min(Node<K, V> right) {
        if (right == null) {
            return null;
        }
        if (right.getLeft() == null) {
            return right;
        }
        return min(right.getLeft());
    }


}
