package org.yenbo.leetcode.medium.graph;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;
import org.yenbo.leetcode.UndirectedGraphNode;

public class CloneGraph {
	@Test
	public void test() {
	
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		
		node1.neighbors.add(node2);
		
		node2.neighbors.add(node2);
		
		HashSet<UndirectedGraphNode> original = new HashSet<UndirectedGraphNode>();
		original.add(node0);
		findNode(original, node0);
		
		UndirectedGraphNode answer = cloneGraph(node0);
		HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		set.add(answer);
		findNode(set, answer);
		
		Assert.assertEquals(original.size(), set.size());
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
		if (node == null) {
			return null;
		}
		
		// find all possible nodes
		HashSet<UndirectedGraphNode> original = new HashSet<UndirectedGraphNode>();
		original.add(node);
		findNode(original, node);
		
		// clone all possible nodes
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		UndirectedGraphNode answer = new UndirectedGraphNode(node.label);
		map.put(answer.label, answer);
		
		for (UndirectedGraphNode n: original) {
			if (false == map.containsKey(n.label)) {
				map.put(n.label, new UndirectedGraphNode(n.label));
			}
		}
		
		// assign neighbors
		for (UndirectedGraphNode n: original) {
			
			UndirectedGraphNode tmp = map.get(n.label);
			
			for (UndirectedGraphNode neighbor: n.neighbors) {
				tmp.neighbors.add(map.get(neighbor.label));
			}
		}
		
		return answer;
    }
	
	private void findNode(HashSet<UndirectedGraphNode> original, UndirectedGraphNode node) {
		
		for (UndirectedGraphNode n: node.neighbors) {
			
			if (false == original.contains(n)) {
				original.add(n);
				findNode(original, n);
			}
		}
	}
}
