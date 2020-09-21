package view;

import controller.ThreadFormula1;

public class Pista {

	public static void main(String[] args) {
		
		String vetEquipe[] = {"Mercedes", "Ferrari", "McLaren", "RedBull", "Haas", "RacingPoint", "Williams"};
		for (int i=0; i<14; i++) {
			if (i<=6) {
				String equipe = vetEquipe[i];
				Thread threadFormula1 = new ThreadFormula1(equipe, i);
				threadFormula1.start();
			} else {
				String equipe = vetEquipe[i-7];
				Thread threadFormula1 = new ThreadFormula1(equipe, i);
				threadFormula1.start();
			}
		}
	}
}
