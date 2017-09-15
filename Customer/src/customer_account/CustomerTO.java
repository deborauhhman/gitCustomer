package customer_account;

public class CustomerTO {
	private int id;
	private long cpf_cnpj;
	private String nome;
	private int active;
	private double vl_total;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public long getCpf_cnpj() {
		return cpf_cnpj;
	}
	
	public void setCpf_cnpj(long cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getActive() {
		return active;
	}
	
	public void setActive(int active) {
		this.active = active;
	}
	
	public double getVl_total() {
		return vl_total;
	}
	
	public void setVl_total(double vl_total) {
		this.vl_total = vl_total;
	}

	
}
