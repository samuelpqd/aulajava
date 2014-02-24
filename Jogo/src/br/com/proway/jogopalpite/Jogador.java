package br.com.proway.jogopalpite;

import java.util.Scanner;

public class Jogador {
	
	private String nome;
	
	private Palpite palpite;
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String novoNome){
		nome = novoNome;
	}
	
	public Palpite informarNovoPalpite(Scanner leitor){
		System.out.println("Informe um número: ");
		int numero = Integer.parseInt(leitor.nextLine());
		Palpite palpite = new Palpite();
		palpite.setNumero(numero);
		return palpite;
	}

}
