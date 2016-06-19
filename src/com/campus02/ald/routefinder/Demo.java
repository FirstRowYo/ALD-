package com.campus02.ald.routefinder;

import java.util.ArrayList;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

public class Demo {

	public static void main(String[] args) {
		
		GraphLoader gl = new GraphLoader();
		
		ListGraph graph =gl.getGraph();

		
		Tiefensuche t=new Tiefensuche(1, 4, gl);
		String weg=t.findByTiefenSucheRekursiv();
		System.out.println(weg);

	}

}
