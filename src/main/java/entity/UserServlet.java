package entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@SuppressWarnings("unused")
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private List<User> users = new ArrayList<>();

    public UserServlet() {}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		var nome = request.getParameter("nome");
		var fase = request.getParameter("fase");
		var pontuacao = request.getParameter("pontuacao");
		
		if(request.getParameter("id") == null) {
			var user = new User(getId(), nome, fase, pontuacao);
			this.users.add(user);
			response.sendRedirect("http://localhost:8080/ifpe-cadastro/UserServlet?acao=listar");
		
		} else {
			var idUser=Integer.parseInt(request.getParameter("id"));
			var userAtualizado = new User(idUser, nome, fase, pontuacao);
			this.atualizaCadastro(userAtualizado);
			response.sendRedirect("http://localhost:8080/ifpe-cadastro/UserServlet?acao=listar");
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 		
			var acao = request.getParameter("acao");
			
			if(acao.equals("listar")) {
				
				request.setAttribute("users", this.users);
				request.getRequestDispatcher("/WEB-INF/views/lista-users.jsp").forward(request, response);
				return;
			}
			
			if(acao.equals("editar")) {
				
				request.setAttribute("user", this.getUserById(Integer.parseInt(request.getParameter("id"))));
				request.getRequestDispatcher("/WEB-INF/views/atualizacao.jsp").forward(request, response);
				return;
			}
			
			if(acao.equals("remover")) {
				
				this.removeUser(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("users", this.users);
				request.getRequestDispatcher("/WEB-INF/views/lista-users.jsp").forward(request, response);
				return;
			}
				
	}
    
	private void removeUser(int id) {
		this.users.remove(this.getUserById(id));
	}

	private User  getUserById(int id) {
		for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	private int getId() {
		return this.users.size()+1;
	}
	
	private void atualizaCadastro(User user) {
		var indice = this.users.indexOf(getUserById(user.getId()));
		this.users.set(indice, user);
	}
}
