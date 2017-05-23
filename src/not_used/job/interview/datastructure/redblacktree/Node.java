package iurii.job.interview.datastructure.redblacktree;

public class Node<K extends Comparable<K>, V> {
	private K key;
	private V value;
	private Node<K,V> left, right;
	private int count = 1;
	
	// color of link to parent 
	private boolean isRed;
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public Node(K key, V value, boolean isRed) {
        this(key,value);
        this.isRed = isRed;
    }

	public Node<K, V> getLeft() {
		return left;
	}

	public void setLeft(Node<K, V> left) {
		this.left = left;
	}

	public Node<K, V> getRight() {
		return right;
	}

	public void setRight(Node<K, V> right) {
		this.right = right;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean isRed) {
        this.isRed = isRed;
    }
	
}
