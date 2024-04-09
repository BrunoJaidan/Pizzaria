package Cliente;
import java.util.Scanner;
import java.util.logging.Logger;

public class Cliente {
	private static final Logger logger = Logger.getLogger(Cliente.class.getName());
	private static final Scanner sc = new Scanner(System.in);
	private String nome;
	private String telefone;
	
	
	public Cliente(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//Cadastrar cliente
	public static  Cliente recepcionarCliente(){
		System.out.println("Bem-vindo(a) à Pizzaria!");
		
		System.out.println("Por favor, informe seu nome: ");
		String nomeCliente = sc.nextLine();
		
		System.out.println("Informe seu telefone: ");
		String telefoneCliente = sc.nextLine();
		
		Cliente cliente = new Cliente(nomeCliente, telefoneCliente);
		System.out.println("Cliente cadastrado com sucesso...");
		logger.info("Seja Bem vindo(a)"+ nomeCliente);
		return cliente;
	}
}
