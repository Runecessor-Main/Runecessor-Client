package Runecessor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class NodeList {

	public NodeList() {
		head = new Node();
		head.prev = head;
		head.next = head;
	}

	public void sort(Comparator<Node> comparator) {
		List<Node> list = new ArrayList<>();

		for (Node node = getFirst(); node != null; node = getNext()) {
			list.add(node);
		}
		list.sort(comparator);

		removeAll();

		for (Node node : list) {
			insertTail(node);
		}
	}

	public void insertHead(Node node) {
		if (node.next != null)
			node.unlink();
		node.next = head.next;
		node.prev = head;
		node.next.prev = node;
		node.prev.next = node;
	}

	public void insertTail(Node node) {
		if (node.next != null)
			node.unlink();
		node.next = head;
		node.prev = head.prev;
		node.next.prev = node;
		node.prev.next = node;
	}

	public Node popHead() {
		Node node = head.prev;
		if (node == head) {
			return null;
		}
		else {
			node.unlink();
			return node;
		}
	}

	public Node reverseGetFirst() {
		Node node = head.prev;
		if (node == head) {
			current = null;
			return null;
		}
		else {
			current = node.prev;
			return node;
		}
	}

	public Node getFirst() {
		Node node = head.next;
		if (node == head) {
			current = null;
			return null;
		}
		else {
			current = node.next;
			return node;
		}
	}

	public Node reverseGetNext() {
		Node node = current;
		if (node == head) {
			current = null;
			return null;
		}
		else {
			current = node.prev;
			return node;
		}
	}

	public Node getNext() {
		Node node = current;
		if (node == head) {
			current = null;
			return null;
		}
		current = node.next;
		return node;
	}

	public void removeAll() {
		if (head.prev == head)
			return;
		do {
			Node node = head.prev;
			if (node == head)
				return;
			node.unlink();
		}
		while (true);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("[");
		for (Node node = getFirst(); node != null; node = getNext()) {
			builder.append(String.format("%s,", node));
		}
		builder.append("]");

		return builder.toString();
	}

	private final Node head;

	private Node current;
}
