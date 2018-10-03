package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.model.Usuario;
import com.web.util.FabricaConexao;

public class UsuarioDAO {
	private static final String INSERT_USUARIO = "INSERT INTO USUARIO (NOME, LOGIN, MATRICULA) VALUES ( ?, ?, ?)";
	private static final String UPDATE_USUARIO = "UPDATE USUARIO SET NOME = ?, LOGIN = ?, MATRICULA = ? WHERE ID = ?";
	private static final String DELETE_USUARIO = "DELETE FROM USUARIO WHERE ID = ?";
	private static final String LISTAR_USUARIO = "SELECT * FROM USUARIO";
	private static final String SEARCH_USUARIO_BYID = "SELECT * FROM USUARIO WHERE ID = ?";
	private static final String SEARCH_USUARIO = "SELECT * FROM USUARIO WHERE NOME LIKE ? OR LOGIN LIKE ?";

	public boolean insereUsuario(Usuario usuario) {
		try (Connection conn = new FabricaConexao().getConexao()) {
			PreparedStatement query = conn.prepareStatement(INSERT_USUARIO);
			query.setString(1, usuario.getNome());
			query.setString(2, usuario.getLogin());
			query.setString(3, usuario.getMatricula());
			return !query.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletaUsuario(int idUsuario) {
		try (Connection conn = new FabricaConexao().getConexao()) {
			PreparedStatement query = conn.prepareStatement(DELETE_USUARIO);
			query.setInt(1, idUsuario);
			return !query.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean atualizaUsuario(Usuario usuario) {
		try (Connection conn = new FabricaConexao().getConexao()) {
			PreparedStatement query = conn.prepareStatement(UPDATE_USUARIO);
			query.setString(1, usuario.getNome());
			query.setString(2, usuario.getLogin());
			query.setString(3, usuario.getMatricula());
			query.setInt(4, usuario.getId());
			return !query.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Usuario> listaUsuarios() {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario usuario;
		try (Connection conn = new FabricaConexao().getConexao()) {
			PreparedStatement query = conn.prepareStatement(LISTAR_USUARIO);
			ResultSet rs = query.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setMatricula(rs.getString("matricula"));
				listaUsuarios.add(usuario);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	public Usuario buscaUsuarioId(int idUsuario) {
		Usuario usuario = null;
		try (Connection conn = new FabricaConexao().getConexao()) {
			PreparedStatement query = conn.prepareStatement(SEARCH_USUARIO_BYID);
			query.setInt(1, idUsuario);
			ResultSet rs = query.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setMatricula(rs.getString("matricula"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public ArrayList<Usuario> buscaUsuario(String txt) {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario usuario;
		try (Connection conn = new FabricaConexao().getConexao()) {
			PreparedStatement query = conn.prepareStatement(SEARCH_USUARIO);
			query.setString(1, "%" + txt.toUpperCase() + "%");
			query.setString(2, "%" + txt.toUpperCase() + "%");
			ResultSet rs = query.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setMatricula(rs.getString("matricula"));
				listaUsuarios.add(usuario);	}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}
}