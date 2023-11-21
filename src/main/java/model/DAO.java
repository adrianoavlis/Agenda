package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		Conexao con = new Conexao();

		try {
			con.conectar();
			PreparedStatement pst = con.getConnection()
					.prepareStatement("insert into contatos (nome, fone, email) values (?,?,?)");
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// executar a query
			pst.executeUpdate();
			// fechar conexão
			con.closeConnection();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> contatos = new ArrayList<JavaBeans>();
		Conexao con = new Conexao();
		try {
			con.conectar();
			PreparedStatement pst = con.getConnection().prepareStatement("select * from contatos order by nome");
			ResultSet retornos = pst.executeQuery();

			// sera executado enquanto houver contatos
			while (retornos.next()) {
				JavaBeans contato = new JavaBeans();
				contato.setIdcon(Integer.parseInt(retornos.getString(1)));
				contato.setNome(retornos.getString(2));
				contato.setFone(retornos.getString(3));
				contato.setEmail(retornos.getString(4));

				// populando o Array
				contatos.add(contato);
			}
			con.closeConnection();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// CRUD UPDATE
	// Selecionar o Contato
	public void selecionarContato(JavaBeans contato) throws SQLException {
		Conexao con = new Conexao();
		String read = "select * from contatos where idcon = ?";
		try {
			con.conectar();
			PreparedStatement pst = con.getConnection().prepareStatement(read);
			pst.setInt(1, contato.getIdcon());
			ResultSet retorno = pst.executeQuery();
			if (retorno.next()) {

				contato.setIdcon(retorno.getInt(1));
				contato.setNome(retorno.getString(2));
				contato.setFone(retorno.getString(3));
				contato.setEmail(retorno.getString(4));

				System.out.println(retorno.getString(1));
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e + " erro na query");

		}

	}

	/** Editar um Contato **/
	public void alterarContato(JavaBeans contato) {
		Conexao con = new Conexao();
		try {
			con.conectar();
			PreparedStatement pst = con.getConnection()
					.prepareStatement("update contatos set nome=?, fone=?, email=? where idcon=?");
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setInt(4, contato.getIdcon());
			pst.executeUpdate();
			con.closeConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD DELETE **/
	public void deletarContato(JavaBeans contato) {
		// ;
		Conexao con = new Conexao();
		try {
			con.conectar();
			PreparedStatement pst = con.getConnection().prepareStatement("delete from contatos where idcon=?");
			pst.setInt(1, contato.getIdcon());
			pst.executeUpdate();
			con.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
