package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread {

	private int id;
	private String equipe;
	private double voltaFinal;
	private Semaphore semaforo = new Semaphore(5);
	private static int Mercedes = 0;
	private static int Ferrari = 0;
	private static int McLaren = 0;
	private static int RedBull = 0;
	private static int Haas = 0;
	private static int RacingPoint = 0;
	private static int Williams = 0;
	private static double[] vet = new double[14];
	private static int[] vetId = new int[14];
	private static String[] vetEquipe = new String[14];
	private static int permisao = 0;

	public ThreadFormula1(String vetEquipe, int id) {

		this.equipe = vetEquipe;
		this.voltaFinal = 0;
		this.id = id;
	}

	public void run() {

///////////////////////////////////////	Seção Crítica ///////////////////////////////////////
		try {
			if (Mercedes == 0 & equipe.contains("Mercedes")) {
				semaforo.acquire();
				Mercedes = 1;
				Pista();
				Mercedes = 0;
			} else if (Ferrari == 0 & equipe.contains("Ferrari")) {
				semaforo.acquire();
				Ferrari = 1;
				Pista();
				Ferrari = 0;
			} else if (McLaren == 0 & equipe.contains("McLaren")) {
				semaforo.acquire();
				McLaren = 1;
				Pista();
				McLaren = 0;
			} else if (RedBull == 0 & equipe.contains("RedBull")) {
				semaforo.acquire();
				RedBull = 1;
				Pista();
				RedBull = 0;
			} else if (Haas == 0 & equipe.contains("Haas")) {
				semaforo.acquire();
				Haas = 1;
				Pista();
				Haas = 0;
			} else if (RacingPoint == 0 & equipe.contains("RacingPoint")) {
				semaforo.acquire();
				RacingPoint = 1;
				Pista();
				RacingPoint = 0;
			} else if (Williams == 0 & equipe.contains("Williams")) {
				semaforo.acquire();
				Williams = 1;
				Pista();
				Williams = 0;
			} else {
				sleep(3000);
				if (Mercedes == 0 & equipe.contains("Mercedes")) {
					semaforo.acquire();
					Mercedes = 1;
					Pista();
					Mercedes = 0;
				} else if (Ferrari == 0 & equipe.contains("Ferrari")) {
					semaforo.acquire();
					Ferrari = 1;
					Pista();
					Ferrari = 0;
				} else if (McLaren == 0 & equipe.contains("McLaren")) {
					semaforo.acquire();
					McLaren = 1;
					Pista();
					McLaren = 0;
				} else if (RedBull == 0 & equipe.contains("RedBull")) {
					semaforo.acquire();
					RedBull = 1;
					Pista();
					RedBull = 0;
				} else if (Haas == 0 & equipe.contains("Haas")) {
					semaforo.acquire();
					Haas = 1;
					Pista();
					Haas = 0;
				} else if (RacingPoint == 0 & equipe.contains("RacingPoint")) {
					semaforo.acquire();
					RacingPoint = 1;
					Pista();
					RacingPoint = 0;
				} else if (Williams == 0 & equipe.contains("Williams")) {
					semaforo.acquire();
					Williams = 1;
					Pista();
					Williams = 0;
				} else {
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("Caso essa mensagem apareçaa, significa que deu errado. Tente novamente.");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			try {
				sleep(5000);
				Random numero = new Random();
				sleep((long) (numero.nextInt(999) + 1));
				for (int i = 0; i < 13; i++) {
					for (int y = i + 1; y < 14; y++) {
						if (vet[i] > vet[y]) {
							double ajudante = vet[i];
							vet[i] = vet[y];
							vet[y] = ajudante;
							int ajudante2;
							ajudante2 = vetId[i];
							vetId[i] = vetId[y];
							vetId[y] = ajudante2;
							String ajudante3;
							ajudante3 = vetEquipe[i];
							vetEquipe[i] = vetEquipe[y];
							vetEquipe[y] = ajudante3;
						}
					}
				}
				sleep((long) (numero.nextInt(999) + 1));
				if (permisao == 0) {
					permisao++;
					System.out.println("");
					System.out.println("O grid de largada é:");
					System.out.println("");
					for (int i = 0; i < 14; i++) {
						System.out.println("O carro id: " + (vetId[i] + 1) + " da equipe " + vetEquipe[i]
								+ " está na posição " + (i + 1) + " de largada, com sua volta mais rápida feita em: "
								+ vet[i] + " minutos;");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
///////////////////////////////////////	Seção Crítica ///////////////////////////////////////
	}

	public void Pista() {

		Random numero = new Random();
		double tempoVolta = 1000000000;
		for (int volta = 0; volta < 3; volta++) {
			double velocidade = (3 + (numero.nextDouble() * (numero.nextInt(20) + 10)));
			System.out.println("O carro da " + equipe + " Id: " + (id + 1) + " completou a volta " + (volta + 1)
					+ " em " + velocidade + " minutos");
			if (velocidade < tempoVolta) {
				tempoVolta = velocidade;
			}
		}
		voltaFinal = tempoVolta;
		vet[id] = voltaFinal;
		vetId[id] = id;
		vetEquipe[id] = equipe;
	}
}