package br.com.ricardo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ricardo.jdbc.ConnectionFactory;
import br.com.ricardo.modelBean.Contato;

public class ContatoDAO {

	private Connection connection;

	public ContatoDAO() {
		ConnectionFactory conexao = new ConnectionFactory();

		connection = conexao.getConnection();
	}

	public void Create(Contato contato) {

		try {

			String sql = "insert into contatos (nome,email,endereco) values(?,?,?)";
			// retorna obj de instrucao

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());

			stmt.executeUpdate();
			// connection.commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Contato> pesquisar(int id) {

		ResultSet rs = null;
		// Result rs = null;
		List<Contato> contatos = new ArrayList<>();
		try {

			String sql = "select nome,email,endereco from contatos where id =  " + id;
			// retorna obj de instrucao
			PreparedStatement stmt = connection.prepareStatement(sql);
			// stmt.setInt(4,contato.getId());

			rs = stmt.executeQuery();

			while (rs.next()) {
				Contato c = new Contato();
				// c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));

				contatos.add(c);
				// System.out.println(c.getId());
				System.out.println(c.getNome());
				System.out.println(c.getEmail());
				System.out.println(c.getEndereco());

			}

			// connection.commit();
			JOptionPane.showMessageDialog(null, "Id com sucesso!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar id");
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return contatos;

	}

	public List<Contato> listar() {

		ResultSet rs = null;
		List<Contato> contatos = new ArrayList<>();
		try {

			String sql = "select nome,email,endereco from contatos ";
			// retorna obj de instrucao
			PreparedStatement stmt = connection.prepareStatement(sql);
			// stmt.setInt(4,contato.getId());

			rs = stmt.executeQuery();

			while (rs.next()) {
				Contato c = new Contato();
				// c.setId(rs.getInt("id"));
				System.out.println();
				// System.out.println("Nome : "+
				// c.setNome(rs.getString("nome")));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));

				contatos.add(c);
				System.out.println(c.getNome());
				System.out.println(c.getEmail());
				System.out.println(c.getEndereco());

			}

			// connection.commit();
			JOptionPane.showMessageDialog(null, "Listagem  com sucesso!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar");
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return contatos;

	}

	public void Update(Contato contato) {

		try {

			String sql = "update  contatos set nome = ? ,email = ? ,endereco = ?  where id = ?";
			// retorna obj de instrucao

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setLong(4, contato.getId());

			stmt.executeUpdate();
			// connection.commit();
			JOptionPane.showMessageDialog(null, "update  com sucesso!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Remover(long id) {

		try {

			String sql = "delete from contatos where id=?";
			// retorna obj de instrucao

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, id);

			stmt.executeUpdate();
			// connection.commit();
			JOptionPane.showMessageDialog(null, "Apagado  com sucesso!!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao apagar registro");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
