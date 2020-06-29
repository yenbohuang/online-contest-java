package org.yenbo.lintcode;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class TopologicalSorting {

	@Test
	public void test1() {
		
		DirectedGraphNode n0 = new DirectedGraphNode(0);
		DirectedGraphNode n1 = new DirectedGraphNode(1);
		DirectedGraphNode n2 = new DirectedGraphNode(2);
		DirectedGraphNode n3 = new DirectedGraphNode(3);
		DirectedGraphNode n4 = new DirectedGraphNode(4);
		DirectedGraphNode n5 = new DirectedGraphNode(5);
		
		n0.neighbors.add(n1);
		n0.neighbors.add(n2);
		n0.neighbors.add(n3);
		
		n1.neighbors.add(n4);
		
		n2.neighbors.add(n4);
		n2.neighbors.add(n5);
		
		n3.neighbors.add(n4);
		n3.neighbors.add(n5);
		
		ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
		graph.add(n0);
		graph.add(n1);
		graph.add(n2);
		graph.add(n3);
		graph.add(n4);
		graph.add(n5);
		
		ArrayList<DirectedGraphNode> answer = topSort(graph);
		Assert.assertEquals(6, answer.size());
	}
	
	@Test
	public void test2() {
		//{0,1,3#1#2,0,1,3,4#3,1#4,0,1,3}
		DirectedGraphNode n0 = new DirectedGraphNode(0);
		DirectedGraphNode n1 = new DirectedGraphNode(1);
		DirectedGraphNode n2 = new DirectedGraphNode(2);
		DirectedGraphNode n3 = new DirectedGraphNode(3);
		DirectedGraphNode n4 = new DirectedGraphNode(4);
		
		n0.neighbors.add(n1);
		n0.neighbors.add(n3);
		
		n2.neighbors.add(n0);
		n2.neighbors.add(n1);
		n2.neighbors.add(n3);
		n2.neighbors.add(n4);
		
		n3.neighbors.add(n1);
		
		n4.neighbors.add(n0);
		n4.neighbors.add(n1);
		n4.neighbors.add(n3);
		
		ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
		graph.add(n0);
		graph.add(n1);
		graph.add(n2);
		graph.add(n3);
		graph.add(n4);
		
		ArrayList<DirectedGraphNode> answer = topSort(graph);
		Assert.assertEquals(5, answer.size());
	}
	
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        
		// http://en.wikipedia.org/wiki/Topological_sorting#Algorithms
		
		// Empty list that will contain the sorted elements
		ArrayList<DirectedGraphNode> sortedArrayList = new ArrayList<DirectedGraphNode>();
		
		if (graph == null || graph.isEmpty()) {
			return sortedArrayList;
		}
		
		// Set of all nodes with no incoming edges
		HashMap<Integer, DirectedGraphNode> map = new HashMap<Integer, DirectedGraphNode>();
		HashMap<Integer, Integer> hasIncomingEdgesMap = new HashMap<Integer, Integer>();
		
		for (DirectedGraphNode n: graph) {
			
			if (false == hasIncomingEdgesMap.containsKey(n.label)) {
				map.put(n.label, n);
			}
			
			for (DirectedGraphNode child: n.neighbors) {
				
				if (hasIncomingEdgesMap.containsKey(child.label)) {
					hasIncomingEdgesMap.put(child.label, hasIncomingEdgesMap.get(child.label) + 1);
				} else {
					hasIncomingEdgesMap.put(child.label, 1);
				}
				
				map.remove(child.label);
			}
		}
		
		while (false == map.isEmpty()) {
			
			DirectedGraphNode n = map.values().iterator().next();
			sortedArrayList.add(n);
			map.remove(n.label);
			
			for (DirectedGraphNode node: graph) {
				
				if (node.label == n.label) {
					
					for (DirectedGraphNode m: node.neighbors) {
						
						int numOfIncomingEdges = hasIncomingEdgesMap.get(m.label) - 1;
						hasIncomingEdgesMap.put(m.label, numOfIncomingEdges);
						
						if (numOfIncomingEdges == 0) {
							map.put(m.label, m);
						}
					}
					
					node.neighbors.clear();
				}
			}
		}
		
		return sortedArrayList;
    }
}
