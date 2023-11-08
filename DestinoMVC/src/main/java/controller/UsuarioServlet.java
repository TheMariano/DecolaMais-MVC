package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;

@WebServlet(urlPatterns = {"/usuario", "/usuario-create", "/usuario-edit", "/usuario-update", "/usuario-delete"})
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UsuarioServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/usuario-create":
                request.getRequestDispatcher("/contato.html").forward(request, response);
                break;
            case "/usuario-edit":
                break;
            case "/usuario-update":
                break;
            case "/usuario-delete":
                break;
            default:
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        UsuarioDao usuario = new UsuarioDao();
        usuario.setNome(nome);
        usuario.setEmail(email);

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.create(usuario);
        response.sendRedirect("contato.html");
    }
}
