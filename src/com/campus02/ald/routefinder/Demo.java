package com.campus02.ald.routefinder;

public class Demo {

	public static void main(String[] args) {
		
		GraphLoader gl = new GraphLoader();

		Tiefensuche t = new Tiefensuche(0, 2, gl);
		String weg = t.findByTiefenSucheRekursiv();
		System.out.println(weg);
	}

}
