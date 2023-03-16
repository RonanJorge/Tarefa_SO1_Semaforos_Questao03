/* Você foi contratado para automatizar um treino de Fórmula 1.
 * As regras estabelecidas pela direção da provas são simples:
 * “No máximo 5 carros das 7 escuderias (14 carros no total)
 * presentes podem entrar na pista simultaneamente, mas apenas
 * um carro de cada equipe. O segundo carro deve ficar à espera,
 * caso um companheiro de equipe já esteja na pista. Cada piloto
 * deve dar 3 voltas na pista. O tempo de cada volta deverá ser
 * exibido e a volta mais rápida de cada piloto deve ser
 * armazenada para, ao final, exibir o grid de largada, ordenado
 * do menor tempo para o maior.” */

package view;

import java.util.concurrent.Semaphore;

import controller.PistaThread;

public class Principal {
	
	public static void main(String[] args) {
		int totalEscuderias = 7;
		int totalCarros = 2;
		Semaphore semaforoPista = new Semaphore(5);
		Semaphore semaforoEscuderia = new Semaphore(1);
		for(int i = 1; i <= totalEscuderias; i++) {
			for(int j = 1; j <= totalCarros; j++) {
				Thread carro = new PistaThread(i, j, semaforoPista, semaforoEscuderia);
				carro.start();
			}
		}
	}
}

