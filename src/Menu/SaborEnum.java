package Menu;

public enum SaborEnum{
	CALABRESA("Calabresa", 39.00),
	MUSSARELA("Mussarela", 39.00),
	PORTUGUESA("Portuguesa", 45.00),
	FRANGO("Frango", 40.0);
	
	
	private final String descricao;
	private final double preco;
	
	SaborEnum(String descricao, double preco){
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public static void apresentarMenu() {
        for (SaborEnum sabor : SaborEnum.values()) {
            System.out.println((sabor.ordinal() + 1) + ". " + sabor.getDescricao() + " - R$" + sabor.getPreco());
        }
    }


}
