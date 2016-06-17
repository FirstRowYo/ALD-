package com.campus02.ald.datastructures;
import java.util.ArrayList;
import java.util.List;


public class ListGraph extends Graph {

	private ArrayList<WeightedEdge>[] graph; //Liste der verbunden gewichteten Knoten
	private int numVertices; //Anzahl der Knoten
	private boolean directed; //gerichtet oder nicht, werden wir nicht verwenden
	
	@SuppressWarnings("unchecked") //Konstruktor
	public ListGraph(int numVertices, boolean directed) {
		graph = new ArrayList[numVertices];
		for (int i=0; i < numVertices; i++)
			graph[i] = new ArrayList<WeightedEdge>();
		this.numVertices = numVertices;
		this.directed = directed;
	}
	
	//Getter
	public int numVertices() {
		return numVertices;
	}
	
	//Findet raus ob es zwischen u(AusgangsKnoten) und v(ZielKnoten) einen Weg gibt
	private WeightedEdge findEdge(int u, int v) {
		for (int i=0; i < graph[u].size(); i++) {
			if (graph[u].get(i).vertex == v)
				return graph[u].get(i);
		}
		return null;
	}
	
	public boolean hasEdge(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		return pv != null;
	}
	
	public int getEdgeWeight(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		return pv.weight;
	}

	
	public void addEdge(int u, int v) {
		addEdge(u, v, 1);
	}
	
	//neuen Weg zu einem Knoten hinzufügen
	public void addEdge(int u, int v, int weight) {
		WeightedEdge pv = new WeightedEdge(v, weight);
		graph[u].add(pv);
		if (!directed) {
			pv = new WeightedEdge(u, weight);
			graph[v].add(pv);
		}
	}
	


	public void removeEdge(int u, int v) {
		WeightedEdge pv = findEdge(u, v);
		graph[u].remove(pv);
		if (!directed) {
			pv = findEdge(v, u);
			graph[u].remove(pv);
		}
	}

	public List<WeightedEdge> getEdges(int v) {
		return graph[v];
	}
}
