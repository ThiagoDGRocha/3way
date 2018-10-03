package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.UsuarioDAO;
import com.web.model.Usuario;

/*
 * Thiago Guimarães
 */

@WebServlet("/user")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String INSERIR_OU_EDITAR = "usuario.jsp";
	private static final String LISTAR_USUARIOS = "listaUsuarios.jsp";
	private static final String FALHA = "falha.jsp";
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("deletar")) {
			int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
			usuarioDAO.deletaUsuario(usuarioId);
			forward = LISTAR_USUARIOS;
			request.setAttribute("usuarios", usuarioDAO.listaUsuarios());
		} else if (action.equalsIgnoreCase("editar")) {
			int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
			Usuario usuario = usuarioDAO.buscaUsuarioId(usuarioId);
			forward = INSERIR_OU_EDITAR;
			request.setAttribute("usuario", usuario);
		} else if (action.equalsIgnoreCase("listarUsuarios")) {
			forward = LISTAR_USUARIOS;
			request.setAttribute("usuarios", usuarioDAO.listaUsuarios());
		} else {
			forward = INSERIR_OU_EDITAR;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setLogin(request.getParameter("usuarioLogin"));
		usuario.setMatricula(request.getParameter("usuarioMatricula"));
		usuario.setNome(request.getParameter("usuarioNome"));
		String usuarioId = request.getParameter("usuarioId");
		String usuarioBusca = request.getParameter("usuarioBusca");
		List<Usuario> usuarios = new ArrayList<>();

		if ((usuarioId == null || usuarioId.isEmpty()) && usuarioBusca == null) {
			usuarioDAO.insereUsuario(usuario);
			usuarios = usuarioDAO.listaUsuarios();
		} else if (usuarioBusca != null) {
			usuarios = usuarioDAO.buscaUsuario(usuarioBusca);
		} else {
			usuario.setId(Integer.parseInt(usuarioId));
			usuarioDAO.atualizaUsuario(usuario);
			usuarios = usuarioDAO.listaUsuarios();
		}
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher view = request.getRequestDispatcher(LISTAR_USUARIOS);
		view.forward(request, response);
	}
}