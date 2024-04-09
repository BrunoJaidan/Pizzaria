package Pizza;
import Cliente.Cliente;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {
    private Cliente cliente;
    private int tipoPizza;
    private double totalPizzas;
    private Date dataPedido;

    public Pedido(Cliente cliente, int tipoPizza, double totalPizzas) {
        this.cliente = cliente;
        this.tipoPizza = tipoPizza;
        this.totalPizzas = totalPizzas;
        this.dataPedido = new Date();
    }

    public void imprimirComprovante() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        String tipo;
        if (tipoPizza == 1) {
            tipo = "Pizza Inteira";
        } else {
            tipo = "Pizza Meia";
        }
        
        //Calcular o carrinho para ganhar o brinde
        String brinde;
        if(totalPizzas > 40.0) {
        	brinde = "Parabéns! Você ganhou um brinde(Coca-Cola 2L)";
        }else {
        	brinde = "Na compra acima de R$40,00, ganhe um brinde!";
        }
        
        System.out.println("===================================");
        System.out.println("------------ Comprovante de Pedido ------------");
        System.out.println("--------------- Pizzaria Jaidan ---------------");
        System.out.println("Data do Pedido: " + dateFormat.format(dataPedido)); 
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Tipo de Pizza: " + tipo);
        System.out.println("Valor total: R$" + totalPizzas);
        System.out.println("-----------------------------------------------");
        System.out.println(brinde);
	    System.out.println("Pedido finalizado. Obrigado por escolher a nossa pizzaria!");
	    }
	}
