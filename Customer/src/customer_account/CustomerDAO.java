package customer_account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO {

	public void criar(CustomerTO to){
		String sql = "INSERT INTO tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total) values (?,?,?,?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, to.getId());
			ps.setLong(2, to.getCpf_cnpj());
			ps.setString(3, to.getNome());
			ps.setInt(4, to.getActive());
			ps.setDouble(5, to.getVl_total());
			ps.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<CustomerTO> listarCustomer(){
		ArrayList<CustomerTO> lista = new ArrayList<CustomerTO>();
		String sql = "select * from tb_customer_account where vl_total > 560 and id_customer >= 1500 and id_customer <= 2700 order by vl_total desc";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()){
					CustomerTO to = new CustomerTO();
					to.setId(rs.getInt("id_customer"));
					to.setCpf_cnpj(rs.getLong("cpf_cnpj"));
					to.setNome(rs.getString("nm_customer"));
					to.setActive(rs.getInt("is_active"));
					to.setVl_total(rs.getDouble("vl_total"));
					lista.add(to);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public double carregarMedia(){
		String sql = "select avg(vl_total) as media from tb_customer_account where vl_total > 560 and id_customer >= 1500 and id_customer <= 2700";
		double media = 0.0;
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery();){
				if(rs.next()){
					media = rs.getDouble("media");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return media;
	}
}
