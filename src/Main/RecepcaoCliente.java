package Main;
import java.util.Scanner;
import Cliente.Cliente;
import Pizza.Pizza;
import Menu.SaborEnum;
import Pizza.Pizza;

public class RecepcaoCliente {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Métodos da Pizzaria
		Cliente cliente = Cliente.recepcionarCliente();
		SaborEnum.apresentarMenu();
		Pizza.escolherPedido(cliente);
		
	    sc.close();
	}
}
