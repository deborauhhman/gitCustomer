package customer_account;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
				
		if(JOptionPane.showConfirmDialog(null, "Deseja cadastrar? ", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			
			int id = Integer.parseInt(JOptionPane.showInputDialog("Digite seu ID: "));
			long cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite seu CPF ou CNPJ: "));
			String nome = JOptionPane.showInputDialog("Digite um Nome: ");
			int act = Integer.parseInt(JOptionPane.showInputDialog("Ativo? (1:Sim, 0:Não): "));
			double vlTotal = Double.parseDouble(JOptionPane.showInputDialog("Valor Total: "));
			Customer cli = new Customer(id, cpf, nome, act, vlTotal);
			cli.criar();
		}
		
		String f = "";		
		CustomerDAO d = new CustomerDAO();
		d.listarCustomer();
		ArrayList<CustomerTO> lista = d.listarCustomer();
		for(CustomerTO to:lista){
			f = f + "\n\nID: " + to.getId() + "\nNome: " + to.getNome() + "\nCPF ou CNPJ: " + to.getCpf_cnpj() + "\nAtivo? 1=Sim, 0=Não: " + to.getActive() +
					"\nValor: " + to.getVl_total();
		}
		
		JOptionPane.showMessageDialog(null, "Média: " + d.carregarMedia() + "\n" + f);
	}

}
