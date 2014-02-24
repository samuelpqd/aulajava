package br.com.proway.jogopalpite;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Jogo {
	
	// visibilidade(privada) tipo(Jogador) nome(jogador)
	private Jogador jogador;
	private Palpite palpitemaquina;
	
	private Jogador criarJogador(Scanner leitor){
		System.out.println("Informe seu nome de Jogador: ");
		String nome=leitor.nextLine();
		Jogador jogador = new Jogador();
		jogador.setNome(nome);
		return jogador;
	}
	
	private Palpite gerarPalpite(){
		Random random = new Random();
		Palpite palpitemaquina = new Palpite();
		palpitemaquina.setNumero(random.nextInt(10));
		return palpitemaquina;
	}
	
	private boolean validarPalpite(Palpite palpiteJogador){
		return palpitemaquina.getNumero()==palpiteJogador.getNumero();
	}
	
	//loop game
	public void jogar(){
		Scanner leitor = new Scanner(System.in);
		
		// criar um palpite da maquina
		palpitemaquina = gerarPalpite();
		
		// criar um jogador
		jogador = criarJogador(leitor);
		// desenvolver logica do jogo
		
		boolean acertou = false;
		
		for (int idx=0;idx<3;idx++){
			if (idx>0){
				System.out.println("Nova Tentativa");
			}
			Palpite palpiteJogador = jogador.informarNovoPalpite(leitor);
			acertou=validarPalpite(palpiteJogador);
			if(acertou){
				break;
			}
		}
		if (acertou){
			System.out.println("Parabéns "+jogador.getNome());
			System.out.println("Você acertou!");
			JOptionPane.showMessageDialog(null,"Parabéns! "+jogador.getNome()+" Você acertou!");
		} else {
			System.out.println("Que pena "+jogador.getNome());
			System.out.println("O numero era "+palpitemaquina.getNumero());
			JOptionPane.showMessageDialog(null,jogador.getNome()+", Você não acertou, o numero era "+palpitemaquina.getNumero());
		}
		
		leitor.close();
	}
	
	
	

}
