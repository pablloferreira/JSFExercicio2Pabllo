package br.edu.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.modelo.ControlePabllo;
import br.edu.faculdadedelta.util.ConexaoPabllo;


public class ControleDAOPabllo {

	public void incluir(ControlePabllo cont) throws ClassNotFoundException, SQLException {
		ConexaoPabllo conexao = new ConexaoPabllo();
		Connection conn = conexao.conectarNoBanco();
		String sql = "INSERT INTO conts (descricao, especificacao, departamento, valor, data_cadastro) "
				+ " VALUES (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cont.getDescricao().trim());
		ps.setString(3, cont.getEspecificacao());
		ps.setString(4, cont.getDepartamento());
		ps.setDouble(5, cont.getValor());
		ps.setDate(6, new java.sql.Date(cont.getData_cadastro().getTime()));
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public void alterar(ControlePabllo cont) throws ClassNotFoundException, SQLException {
		ConexaoPabllo conexao = new ConexaoPabllo();
		Connection conn = conexao.conectarNoBanco();
		String sql = "UPDATE conts SET descricao = ?, "
				+ " especificacao = ?, "
				+ " departamento = ?, "
				+ " valor = ?, "
				+ " data_cadastro  = ? "
				+ " WHERE id= ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cont.getDescricao ().trim());
		ps.setString(2, cont.getEspecificacao());
		ps.setString(3, cont.getDepartamento());
		ps.setDouble(4, cont.getValor());
		ps.setDate(5, new java.sql.Date(cont.getData_cadastro().getTime()));
		ps.setLong(6, cont.getId());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public void excluir(ControlePabllo cont) throws ClassNotFoundException, SQLException {
		ConexaoPabllo conexao = new ConexaoPabllo();
		Connection conn = conexao.conectarNoBanco();
		String sql = "DELETE FROM conts WHERE id= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, cont.getId());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public List<ControlePabllo> listar() throws ClassNotFoundException, SQLException {
		ConexaoPabllo conexao = new ConexaoPabllo();
		Connection conn = conexao.conectarNoBanco();
		String sql = "SELECT id, descricao, especificacao, departamento, "
				+ " valor, data_cadastro FROM conts";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<ControlePabllo> listaRetorno = new ArrayList<ControlePabllo>();
 		
		while (rs.next()) {
			ControlePabllo cont = new ControlePabllo();
			cont.setId(rs.getLong("id"));
			cont.setDescricao(rs.getString("descricao").trim());
			cont.setEspecificacao(rs.getString("especificacao"));
			cont.setDepartamento(rs.getString("departamento"));
			cont.setValor(rs.getDouble("valor"));
			cont.setData_cadastro(rs.getDate("data_cadastro"));
			listaRetorno.add(cont);
		}
		rs.close();
		ps.close();
		conn.close();
		
		return listaRetorno;
	}
	
}
