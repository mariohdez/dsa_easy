package array;

public class MyHashMap {
	private LinkedList[]indexToValueMap;
	private static int CAPACITY = 100;

	public MyHashMap() {
		this.indexToValueMap = new LinkedList[CAPACITY]; 

		for (int i = 0; i < CAPACITY; ++i) {
			this.indexToValueMap[i] = new LinkedList();
		}
	}

	public void put(int key, int value) {
		int hashKey = this.getHash(key);

		LinkedList ll = this.indexToValueMap[hashKey];

		if (ll.isEmpty()) {
			ll.insertAtTail(new Node(key, value));
		} else {
			Node nodeToOverride = ll.search(key);

			if (nodeToOverride == null) {
				ll.insertAtTail(new Node(key, value));
			} else {
				nodeToOverride.setValue(value);
			}
		}
	}

	public int get(int key) {
		int hashKey = getHash(key);

		LinkedList ll = this.indexToValueMap[hashKey];

		if (ll.isEmpty()) {
			return -1;
		}

		Node node = ll.search(key);

		if (node == null) {
			return -1;
		}

		return node.getValue();
	}

	public void remove(int key) {
		int hashKey = this.getHash(key);

		LinkedList ll = this.indexToValueMap[hashKey];

		if (ll.isEmpty()) {
			return;
		}

		Node nodeToRemove = ll.search(key);

		if (nodeToRemove == null) {
			return;
		}

		ll.remove(nodeToRemove);
	}

	private int getHash(int key) {
		return key % CAPACITY;
	}

	public class LinkedList {
		private int size = 0;
		private Node dummyHead = new Node(-1, -1);
		private Node dummyTail = new Node(-1, -1);

		public LinkedList() {
			dummyHead.setNext(dummyTail);
		}

		public int getSize() {
			return this.size;
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public void insertAtTail(Node nodeToInsert) {
			Node tempBefore = this.dummyTail.getPrevious();
			tempBefore.setNext(nodeToInsert);
			nodeToInsert.setPrevious(tempBefore);
			nodeToInsert.setNext(this.dummyTail);
			this.dummyTail.setPrevious(nodeToInsert);
			this.size++;
		}

		public void remove(Node nodeToRemove) {
			Node prev = nodeToRemove.getPrevious();
			Node next = nodeToRemove.getNext();
			prev.setNext(next);
			next.setPrevious(prev);
			this.size--;
		}

		public Node search(int key) {
			Node cur = this.dummyHead;

			while (cur != null) {
				if (cur.getKey() == key) {
					return cur;
				}

				cur = cur.getNext();
			}

			return null;
		}
	}

	public class Node {
		private int key;
		private int value;
		private Node next;
		private Node previous;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.previous = null;
		}

		public int getKey() {
			return this.key;
		}

		public int getValue() {
			return this.value;
		}

		public Node getNext() {
			return this.next;
		}

		public Node getPrevious() {
			return this.previous;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}
	}
}
