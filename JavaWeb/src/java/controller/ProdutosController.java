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
import model.bean.ProdutoDTO;
import model.dao.ProdutoDAO;

@WebServlet(name = "ProdutosController", urlPatterns = {"/ProdutosController", "/CategoriasController", "/lista-produtos"})
public class ProdutosController extends HttpServlet {

    ProdutoDTO objProdutoDTO = new ProdutoDTO();
    ProdutoDAO objProdutoDAO = new ProdutoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getServletPath();
        if (url.equals("/ProdutosController")) {
            String nextPage = "/WEB-INF/jsp/produtos.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }
        if (url.equals("/CategoriasController")) {
            String nextPage = "/WEB-INF/jsp/categorias.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String url = request.getServletPath();
        if (url.equals("/lista-produtos")) {
            List<ProdutoDTO> produtos = objProdutoDAO.ler();

            Gson gson = new Gson();
            String json = gson.toJson(produtos);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
