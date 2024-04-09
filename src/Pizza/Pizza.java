package Pizza;

import Menu.SaborEnum;
import java.util.Scanner;

import Cliente.Cliente;

public class Pizza {
    private static final Scanner scanner = new Scanner(System.in);

    public static void escolherPedido(Cliente cliente) {
        double totalPizzas = 0;
        int contadorPizzas = 0;
        boolean continuarPedido = true;
        int tipoPizza = 0;

        while (continuarPedido) {
        	System.out.println("===================================");
            System.out.println("Escolha o tipo de pizza que você deseja:");
            System.out.println("1. Pizza inteira");
            System.out.println("2. Pizza meia");
            System.out.println("3. Remover uma Pizza");
            System.out.println("===================================");
            
            tipoPizza = scanner.nextInt();
            scanner.nextLine();

            switch (tipoPizza) {
                case 1:
                    totalPizzas += escolherPizzaInteira();
                    contadorPizzas++;
                    break;
                case 2:
                    totalPizzas += escolherPizzaMeia();
                    contadorPizzas++;
                    break;   
                case 3:
                	if (contadorPizzas > 0) {
                		totalPizzas -= removerPizza();
                		contadorPizzas--;
                	}else {
                		System.out.println("Você ainda não adicionou nenhuma pizzas para remover.");
                	}
                default:
                    System.out.println("Opção inválida. Digite 1 para pizza inteira, 2 para pizza meia ou 3 para remover uma pizza.");
            }

            System.out.println("Você gostaria de escolher outra pizza? (s/n): ");
            String resposta = scanner.nextLine();
            continuarPedido = resposta.equalsIgnoreCase("s");
            
        }
        
        String formaPagamentoStr = FormaPagamentos.escolherFormaPagamento();
        if (formaPagamentoStr != null) {
        Pedido pedido = new Pedido(cliente, tipoPizza, totalPizzas); 
		pedido.imprimirComprovante();
        }
    }
    
    
    private static double removerPizza() {
    	System.out.println("Informe o valor da pizza que deseja remover: ");
    	double precoRemovido = scanner.nextDouble();
    	scanner.nextLine();
    	System.out.println("Pizza removida com sucesso!");
    	return precoRemovido;
    }

    private static double escolherPizzaInteira() {
        SaborEnum saborEscolhido = encontrarSabor();

        if (saborEscolhido != null) {
            System.out.println("Você escolheu a pizza: " + saborEscolhido.getDescricao());

            System.out.println("Informe a quantidade de pizzas desejada: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            double precoPizza = saborEscolhido.getPreco();
            double precoTotal = precoPizza * quantidade;

            System.out.println("Preço total da pizza: R$" + precoTotal);
            return precoTotal;
        } else {
            System.out.println("Erro: sabor não encontrado. Favor informar um sabor válido.");
            return 0.0;
        }
    }

    private static double escolherPizzaMeia() {
        SaborEnum saborEscolhido1 = encontrarSabor();
        SaborEnum saborEscolhido2 = encontrarSabor();

        if (saborEscolhido1 != null && saborEscolhido2 != null) {
            System.out.println("Você escolheu os sabores: " + saborEscolhido1.getDescricao() + " e " + saborEscolhido2.getDescricao());

            System.out.println("Informe a quantidade de pizzas desejada: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            double precoPizza1 = saborEscolhido1.getPreco();
            double precoPizza2 = saborEscolhido2.getPreco();

            double precoTotal = Math.max(precoPizza1, precoPizza2) * quantidade;

            System.out.println("Preço total da pizza: R$" + precoTotal);
            return precoTotal;
        } else {
            System.out.println("Erro: um ou ambos os sabores não estão disponíveis em nosso cardápio.");
            return 0.0;
        }
    }

    private static SaborEnum encontrarSabor() {
        System.out.println("Escolha o sabor da pizza:");
        for (SaborEnum sabor : SaborEnum.values()) {
            System.out.println((sabor.ordinal() + 1) + ". " + sabor.getDescricao() + " - R$" + sabor.getPreco());
        }

        int numeroSabor = scanner.nextInt();
        scanner.nextLine();

        for (SaborEnum sabor : SaborEnum.values()) {
            if (sabor.ordinal() + 1 == numeroSabor) {
                return sabor;
            }
        }
        return null;
    }
}
