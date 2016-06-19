package com.campus02.ald.routefinder;

import java.util.List;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

public class Tiefensuche {
	
	private int start;
	private int ziel;
	private GraphLoader gl;
	private ListGraph g;
		
	
	//private ListGraph lg=new ListGraph(numVertices, directed)
	
	public Tiefensuche(int start, int ziel, GraphLoader gl) {
		super();
		this.start = start;
		this.ziel = ziel;
		this.gl=gl;
		this.g=gl.getGraph();
		
	}
	
	public String findByTiefenSucheRekursiv() {
		String weg="";
		System.out.println(g.numVertices());
		boolean[] visited = new boolean[g.numVertices()];
		int[] pred = new int[g.numVertices()];
		
		// pred[5] = 0
		// Wir besuchen 5 über 0
		
		_findByTiefenSucheRekursiv(start, ziel, visited, pred);
		
		for(int i=0; i<pred.length; i++) {
			//System.out.println(i + " über " + pred[i]);
			weg+=i + " über " + pred[i] + " ";
		}
		return weg;
	}
	
	private boolean _findByTiefenSucheRekursiv(int current, int nach, boolean[] visited, int[] pred) {
		
		if (current == nach) return true;
	
		visited[current] = true;
		
		List<WeightedEdge> nachbarn = g.getEdges(current);
		for(WeightedEdge n: nachbarn) {
			
			if (!visited[n.vertex]) {
				pred[n.vertex] = current;
				
				boolean found = _findByTiefenSucheRekursiv(n.vertex, nach, visited, pred);
				if (found) return true;
				
			}
		}
		return false;
	}
	
	
	
	
	
	
//	
//	public ArrayList<Integer>search()
//	{
//		edgelist=(ArrayList<WeightedEdge>) g.getEdges(start);
//		for (WeightedEdge weightedEdge : edgelist) 
//		{
//			search(weightedEdge.vertex);
//		}
//		return null;	
//	}
//	
////	public ArrayList<Integer>search(int current)
//	{
//		if(current==ziel)
//		{
//			return visetedNode;
//		}
//		visetedNode.add(current);
//		search(current+1);
//	}
//	
	

}
