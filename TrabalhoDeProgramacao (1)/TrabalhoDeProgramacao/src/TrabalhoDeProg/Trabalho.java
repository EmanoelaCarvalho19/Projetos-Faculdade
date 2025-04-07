package TrabalhoDeProg;

import java.util.Locale;
import java.util.Scanner;

public class Trabalho {
	/* Nomes:
	 * Emanoela Carvalho Santos.
	 * Gabriel Lima de Oliveira, 
	 * Yago Xavier da Costa. 
	 * 
	 */
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		int opcoes = 0;
		double resultado;
		double arroz = 16.00;
		double feijao = 15.00;
		double carne = 23.00;
		int qtdUm;
		int opcaoDeComida;
		double[] vectList = new double[1];
		int[] quantityArroz = new int[1];
		quantityArroz[0] = 0;
		int[] quantityFeijao = new int[1];
		quantityFeijao[0] = 0;
		int[] quantityCarne = new int[1];
		quantityCarne[0] = 0;

		do {
			System.out.println("Bem vindo (a)! ");
			System.out.println("Digite um número para acessar algum menu:");
			System.out.println("[1] Iniciar compras");
			System.out.println("[2] Itens da compra ");
			System.out.println("[3] Sair");
			System.out.println("Qual a sua opção? ");
			opcoes = leitor.nextInt();

			if (opcoes == 1) {
				System.out.println("[1] Arroz R$" + arroz);
				System.out.println("[2] Feijão R$" + feijao);
				System.out.println("[3] Carne R$" + carne);
				System.out.println("[4] finalizar compra ");
				System.out.println("voce deseja comprar quais itens:");
				opcaoDeComida = leitor.nextInt();

				if (opcaoDeComida == 1) {
					resultado = arroz;
					System.out.println("quantas unidades?");
					qtdUm = leitor.nextInt();
					quantityArroz[0] = qtdUm;
					resultado = resultado * qtdUm;
					System.out.println("voce deseja comprar mais coisas?(s/n)");
					char decision = leitor.next().charAt(0);
					vectList[0] = resultado;
					if (decision == 's' || decision == 'S') {
						do {
							System.out.println("[1] Arroz R$" + arroz);
							System.out.println("[2] Feijão R$" + feijao);
							System.out.println("[3] Carne R$" + carne);
							System.out.println("[4] finalizar compra ");
							System.out.println("voce deseja comprar quais itens:");
							opcaoDeComida = leitor.nextInt();

							if (opcaoDeComida == 1) {
								System.out.println("voce deseja quantas quantidades a mais:");
								qtdUm = leitor.nextInt();
								resultado = resultado + (arroz * qtdUm);
								vectList[0] = resultado;
								quantityArroz[0] = qtdUm;

							} else if (opcaoDeComida == 2) {
								System.out.println("voce deseja quantas quantidades a mais: ");
								qtdUm = leitor.nextInt();
								resultado = resultado + (feijao * qtdUm);
								vectList[0] = resultado;
								quantityFeijao[0] = qtdUm;

							} else if (opcaoDeComida == 3) {
								System.out.println("voce deseja quantas quantidades a mais: ");
								qtdUm = leitor.nextInt();
								resultado = resultado + (carne * qtdUm);
								vectList[0] = resultado;
								quantityCarne[0] = qtdUm;
							}

						} while (opcaoDeComida != 4);
					}

				} else if (opcaoDeComida == 2) {
					resultado = feijao;
					System.out.println("quantas unidades?");
					qtdUm = leitor.nextInt();
					resultado = resultado * qtdUm;
					System.out.println("voce deseja comprar mais coisas?(s/n)");
					char decision = leitor.next().charAt(0);
					vectList[0] = resultado;
					quantityFeijao[0] = qtdUm;

					if (decision == 's' || decision == 'S') {
						do {
							System.out.println("[1] Arroz R$" + arroz);
							System.out.println("[2] Feijão R$" + feijao);
							System.out.println("[3] Carne R$" + carne);
							System.out.println("[4] finalizar compra ");
							System.out.println("voce deseja comprar quais itens:");
							opcaoDeComida = leitor.nextInt();

							if (opcaoDeComida == 1) {
								System.out.println("voce deseja quantas quantidades a mais:");
								qtdUm = leitor.nextInt();
								resultado = resultado + (arroz * qtdUm);
								vectList[0] = resultado;
								quantityArroz[0] = qtdUm;
							} else if (opcaoDeComida == 2) {
								System.out.println("voce deseja quantas quantidades a mais: ");
								qtdUm = leitor.nextInt();
								resultado = resultado + (feijao * qtdUm);
								vectList[0] = resultado;
								quantityFeijao[0] = qtdUm;
							} else if (opcaoDeComida == 3) {
								System.out.println("voce deseja quantas quantidades a mais: ");
								qtdUm = leitor.nextInt();
								resultado = resultado + (carne * qtdUm);
								vectList[0] = resultado;
								quantityCarne[0] = qtdUm;
							}

						} while (opcaoDeComida != 4);
					}

				} else if (opcaoDeComida == 3) {
					resultado = carne;
					System.out.println("quantas unidades?");
					qtdUm = leitor.nextInt();
					resultado = resultado * qtdUm;
					System.out.println("voce deseja comprar mais coisas?(s/n)");
					char decision = leitor.next().charAt(0);
					vectList[0] = resultado;
					quantityCarne[0] = qtdUm;

					if (decision == 's' || decision == 'S') {
						do {
							System.out.println("[1] Arroz R$" + arroz);
							System.out.println("[2] Feijão R$" + feijao);
							System.out.println("[3] Carne R$" + carne);
							System.out.println("[4] finalizar compra ");
							System.out.println("voce deseja comprar quais itens:");
							opcaoDeComida = leitor.nextInt();

							if (opcaoDeComida == 1) {
								System.out.println("voce deseja quantas quantidades a mais:");
								qtdUm = leitor.nextInt();
								resultado = resultado + (arroz * qtdUm);
								vectList[0] = resultado;
								quantityArroz[0] = qtdUm;
							} else if (opcaoDeComida == 2) {
								System.out.println("voce deseja quantas quantidades a mais: ");
								qtdUm = leitor.nextInt();
								resultado = resultado + (feijao * qtdUm);
								vectList[0] = resultado;
								quantityFeijao[0] = qtdUm;
							} else if (opcaoDeComida == 3) {
								System.out.println("voce deseja quantas quantidades a mais: ");
								qtdUm = leitor.nextInt();
								resultado = resultado + (carne * qtdUm);
								vectList[0] = resultado;
								quantityCarne[0] = qtdUm;
							}

						} while (opcaoDeComida != 4);
					}
				}
			} else {
				if (opcoes == 2) {
					mostrarArroz(quantityArroz);
					System.out.println("QUANTIDADES:");
					System.out.printf("1-Arroz: " + mostrarArroz(quantityArroz)+ " Unidades" + " Valor parcial: R$%.2f%n" ,(quantityArroz[0] * arroz));
					System.out.println();
					mostrarFeijao(quantityFeijao);
					System.out.printf("2-Feijao: " + mostrarFeijao(quantityFeijao)+" Unidades"+ " Valor parcial:R$%.2f%n" ,(quantityFeijao[0] * feijao));
					System.out.println();
					mostrarCarne(quantityCarne);
					System.out.printf("3-Carne: " + mostrarCarne(quantityCarne)+ " Unidades"+ " Valor parcial: R$%.2f%n" ,(quantityCarne[0] * carne));
					System.out.println();
					mostrarLista(vectList);
					System.out.printf("A COMPRA TOTALIZOU: R$%.2f%n", mostrarLista(vectList));
					System.out.println();
					
				}
			}

		} while (opcoes != 3);

		System.out.println("Muito obrigado pela preferencia volte sempre!");

	}

	public static double mostrarLista(double result[]) {
		for (int i = 0; i < 2; i++) {
			return result[i];
		}
		return 0;
	}

	public static int mostrarArroz(int quantityArroz[]) {

		for (int i = 0; i < 2; i++) {
			return quantityArroz[i];
		}
		return 0;
	}

	public static int mostrarFeijao(int quantityFeijao[]) {
		for (int i = 0; i < 2; i++) {
			return quantityFeijao[i];
		}
		return 0;
	}

	public static int mostrarCarne(int quantityCarne[]) {
		for (int i = 0; i < 2; i++) {
			return quantityCarne[i];
		}
		return 0;
	}

}


