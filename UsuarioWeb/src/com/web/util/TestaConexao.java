package com.web.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TestaConexao {

	public static void main(String[] args) {
		try (Connection con = FabricaConexao.getConexao()) {
			if(con!=null) {
				JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!", "Postgres", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!", "Postgres", JOptionPane.ERROR_MESSAGE);
		}
	}
}
