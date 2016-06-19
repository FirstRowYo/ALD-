package com.campus02.ald.routefinder;

import java.util.List;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

public class Tiefensuche {
	
	private int start;
	private int ziel;
	private ListGraph graph; //war mal nur "g"
	
	public Tiefensuche(int start, int ziel, GraphLoader gl) {
		super();
		this.start = start;
		this.ziel = ziel;
		this.graph=gl.getGraph();
	}
	
	public String findByTiefenSucheRekursiv() {
		String weg="";
		boolean[] visited = new boolean[graph.numVertices()];
		int[] pred = new int[graph.numVertices()];
		
		_findByTiefenSucheRekursiv(start, ziel, visited, pred);
		
		for(int i=0; i<pred.length; i++) {
			weg+=i + " ueber " + pred[i] + " \n";
			
		}
		return weg;
	}
	
	private boolean _findByTiefenSucheRekursiv(int current, int nach, boolean[] visited, int[] pred) {
		if (current == nach) return true;
	
		visited[current] = true;
		
		List<WeightedEdge> nachbarn = graph.getEdges(current);
		for(WeightedEdge n: nachbarn) {
			
			if (!visited[n.vertex]) {
				pred[n.vertex] = current;
				
				boolean found = _findByTiefenSucheRekursiv(n.vertex, nach, visited, pred);
				if (found) return true;
			}
		}
		return false;
	}

}
