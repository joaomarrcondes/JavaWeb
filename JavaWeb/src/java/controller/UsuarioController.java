package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.UsuarioDTO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
@WebServlet(name = "LoginController", urlPatterns = {"/usuario-login", "/usuario-cadastro", "/cadastro", "/users", "/login"})
public class UsuarioController extends HttpServlet {

    UsuarioDTO objUsuarioDTO = new UsuarioDTO();
    UsuarioDAO objUsuarioDAO = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getServletPath();
        if (url.equals("/usuario-login")) {
            String nextPage = "/WEB-INF/jsp/login.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/usuario-cadastro")) {
            String nextPage = "/WEB-INF/jsp/cadastro.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/cadastro")) {
            doPost(request, response);
        } else if (url.equals("/login")) {
            String nextPage = "/WEB-INF/jsp/home.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String url = request.getServletPath();
        if (url.equals("/users")) {
            List<UsuarioDTO> users = objUsuarioDAO.ler();

            Gson gson = new Gson();
            String json = gson.toJson(users);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        objUsuarioDTO.setNome(request.getParameter("Nome"));
        objUsuarioDTO.setSenha(request.getParameter("Senha"));
        objUsuarioDTO.setUsuario(request.getParameter("Usuario"));
        objUsuarioDTO.setTelefone(request.getParameter("Telefone"));
        objUsuarioDTO.setData_nascimento(request.getParameter("Data"));
        objUsuarioDTO.setCpf(request.getParameter("Cpf"));
        objUsuarioDAO.inserir(objUsuarioDTO);
        String path = "/WEB-INF/jsp/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

}
