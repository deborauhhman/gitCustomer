package customer_account;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Customer implements Serializable{

	private int id;
	private long cpf_cnpj;
	private String nome;
	private int active;
	private double vl_total;
	
	public Customer(int id, long cpf_cnpj, String nome, int active, double vl_total){
		setId(id);
		setCpf_cnpj(cpf_cnpj);
		setNome(nome);
		setActive(active);
		setVl_total(vl_total);
	}
	
	public Customer(){
		
	}
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
	
	public void criar(){
		CustomerDAO dao = new CustomerDAO();
		CustomerTO to = new CustomerTO();
		to.setId(id);
		to.setCpf_cnpj(cpf_cnpj);
		to.setNome(nome);
		to.setActive(active);
		to.setVl_total(vl_total);
		dao.criar(to);
	}

}
