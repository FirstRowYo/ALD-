package com.campus02.ald.routefinder;

public class Demo {

	public static void main(String[] args) {
		
		GraphLoader gl = new GraphLoader();

		Tiefensuche t = new Tiefensuche(2, 5, gl);
		System.out.println(t.findByTiefenSucheRekursiv());

		System.out.println();
		
		Breitensuche b = new Breitensuche(2, 5, gl);
		System.out.println(b.findByBreitenSuche());
		
		System.out.println();
		
		Dijkstra d = new Dijkstra(1, 4, gl);
		System.out.println(d.findByDijkstra());
		
	}	

}
