package Pizza;

import java.util.Scanner;

public class FormaPagamentos {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static String escolherFormaPagamento() {
		System.out.println("Escolha a forma de pagamento");
		System.out.println("1. Pix");
		System.out.println("2. Débito");
		System.out.println("3. Crédito");
		System.out.println("4. Dinheiro");
		System.out.println("===================================");
		
		int formaPagamento = scanner.nextInt();
		scanner.nextLine();
		
		switch (formaPagamento) {
		
		case 1: 
			System.out.println("Pagamento PIX, realizado com sucesso!");
			return "Pix";
		case 2:
			System.out.println("Pagamento Débito, realizado com sucesso!");
			return "Débito";
		case 3:
			System.out.println("Pagamento Crédito, realizado com sucesso!");
			return "Crédito";
		case 4:
			System.out.println("Pagamento Dinheiro, realizado com sucesso!");
			return "Dinheiro";
		default:
			System.out.println("Opção de pagamento inválida.");
			return null;
		}
	}
}	
	
