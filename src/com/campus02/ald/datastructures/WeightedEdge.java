package com.campus02.ald.datastructures;

public class WeightedEdge {
	public int vertex; //nächster Knoten
	public int weight; //Weg dort hin

	public WeightedEdge(int v, int weight) {
		this.vertex = v;
		this.weight = weight;
	}
}
