package com.campus02.ald.routefinder;

public class Demo {

	public static void main(String[] args) {
		
		GraphLoader gl = new GraphLoader();

		Tiefensuche t = new Tiefensuche(2, 5, gl);
		String weg = t.findByTiefenSucheRekursiv();
		
		System.out.println(weg);
		System.out.println();
		
		//Weg von hinten durchgehen. 5 �ber 0 - 0 �ber 2 - fertig.
		Breitensuche b = new Breitensuche(1, 5, gl);
		System.out.println(b.findByBreitenSuche());
	}	

}
