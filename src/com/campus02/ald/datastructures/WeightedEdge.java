package com.campus02.ald.datastructures;
//maut Enabled
public class WeightedEdge 
{
	public int vertex; //naechster Knoten => Ziel der Kante
	public int weight; //Weg dort hin
	public boolean maut;
	public int mautkosten;

	public WeightedEdge(int v, int weight,boolean maut, int mautkosten)
	{
		this.vertex = v;
		this.weight = weight;
		this.maut = maut;
		this.mautkosten = mautkosten;
	}
}
