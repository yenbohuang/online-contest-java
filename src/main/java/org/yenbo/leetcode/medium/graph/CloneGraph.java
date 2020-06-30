package org.yenbo.leetcode.medium.graph;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.Node;

/**
 * https://leetcode.com/problems/clone-graph/
 * @author user
 *
 */
public class CloneGraph {
	
	@Test
	public void test() {
	
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		
		node1.neighbors.add(node2);
		
		node2.neighbors.add(node2);
		
		HashSet<Node> original = new HashSet<Node>();
		original.add(node0);
		findNode(original, node0);
		
		Node answer = cloneGraph(node0);
		HashSet<Node> set = new HashSet<Node>();
		set.add(answer);
		findNode(set, answer);
		
		Assert.assertEquals(original.size(), set.size());
	}
	
	public Node cloneGraph(Node node) {
        
		if (node == null) {
			return null;
		}
		
		// find all possible nodes
		HashSet<Node> original = new HashSet<Node>();
		original.add(node);
		findNode(original, node);
		
		// clone all possible nodes
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		Node answer = new Node(node.val);
		map.put(answer.val, answer);
		
		for (Node n: original) {
			if (false == map.containsKey(n.val)) {
				map.put(n.val, new Node(n.val));
			}
		}
		
		// assign neighbors
		for (Node n: original) {
			
			Node tmp = map.get(n.val);
			
			for (Node neighbor: n.neighbors) {
				tmp.neighbors.add(map.get(neighbor.val));
			}
		}
		
		return answer;
    }
	
	private void findNode(HashSet<Node> original, Node node) {
		
		for (Node n: node.neighbors) {
			
			if (false == original.contains(n)) {
				original.add(n);
				findNode(original, n);
			}
		}
	}
}
