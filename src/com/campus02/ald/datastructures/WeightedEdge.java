package com.campus02.ald.datastructures;

public class WeightedEdge 
{
	public int vertex; //naechster Knoten => Ziel der Kante
	public int weight; //Weg dort hin

	public WeightedEdge(int v, int weight) 
	{
		this.vertex = v;
		this.weight = weight;
	}
}
