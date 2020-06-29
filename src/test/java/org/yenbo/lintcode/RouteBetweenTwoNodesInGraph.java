package org.yenbo.lintcode;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class RouteBetweenTwoNodesInGraph {

	@Test
	public void test1() {
		
		DirectedGraphNode a = new DirectedGraphNode(1);
		DirectedGraphNode b = new DirectedGraphNode(2);
		DirectedGraphNode c = new DirectedGraphNode(3);
		DirectedGraphNode d = new DirectedGraphNode(4);
		DirectedGraphNode e = new DirectedGraphNode(5);
		
		a.neighbors.add(b);
		a.neighbors.add(d);
		
		b.neighbors.add(c);
		b.neighbors.add(d);
		
		d.neighbors.add(e);
		
		ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		
		Assert.assertTrue(hasRoute(graph, b, e));
	}
	
	@Test
	public void test2() {
		
		DirectedGraphNode a = new DirectedGraphNode(1);
		DirectedGraphNode b = new DirectedGraphNode(2);
		DirectedGraphNode c = new DirectedGraphNode(3);
		DirectedGraphNode d = new DirectedGraphNode(4);
		DirectedGraphNode e = new DirectedGraphNode(5);
		
		a.neighbors.add(b);
		a.neighbors.add(d);
		
		b.neighbors.add(c);
		b.neighbors.add(d);
		
		d.neighbors.add(e);
		
		ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		
		Assert.assertFalse(hasRoute(graph, d, c));
	}
	
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
			DirectedGraphNode s, DirectedGraphNode t) {
		
		if (graph == null || graph.isEmpty()) {
			return false;
		}
		
		DirectedGraphNode node = null;
		
		for (DirectedGraphNode n: graph) {
			
			if (n.label == s.label) {
				node = n;
				break;
			}
		}
		
		if (node == null) {
			return false;
		} else {
			return findNode(node, t.label);
		}
		
	}
	
	private boolean findNode(DirectedGraphNode start, int label) {
		
		if (start.label == label) {
			return true;
		}
		
		for (DirectedGraphNode n: start.neighbors) {
			if (findNode(n, label)) {
				return true;
			}
		}
		
		return false;
	}
}
