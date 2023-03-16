package controller;

import java.util.concurrent.Semaphore;

public class PistaThread extends Thread{
	int escuderia;
	int carro;
	Semaphore semaforoPista;
	Semaphore semaforoEscuderia;
		
	public PistaThread(int escuderia, int carro, Semaphore semaforoPista, Semaphore semaforoEscuderia) {
		this.carro = carro;
		this.escuderia = escuderia;
		this.semaforoPista = semaforoPista;
		this.semaforoEscuderia = semaforoEscuderia;
	}
	
	@Override
	public void run() {
		try {
			semaforoPista.acquire();
			entraPista();
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		finally {
			semaforoPista.release();
		}
	}
	
	
	public void entraPista() {
		System.out.println("O carro "+carro+ " da escuderia "+escuderia+" entrou na pista.");
		System.out.println("O carro "+carro+ " da escuderia "+escuderia+" saiu da pista.");
	}
}
