package org.yenbo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public int val;
	public List<Node> neighbors;
	
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	
	 public Node(int _val, ArrayList<Node> _neighbors) {
		 val = _val;
		 neighbors = _neighbors;
	 }
}
