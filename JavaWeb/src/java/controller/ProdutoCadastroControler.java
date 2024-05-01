package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.bean.ProdutoDTO;
import model.dao.ProdutoDAO;

@WebServlet(name = "CadastroControler", urlPatterns = {"/CadastroControler"})
public class ProdutoCadastroControler extends HttpServlet {

    ProdutoDTO objProdutoDTO = new ProdutoDTO();
    ProdutoDAO objProdutoDAO = new ProdutoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/CadastroController")) {
            doPost(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part filePart = request.getPart("imagem");
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageBytes = outputStream.toByteArray();

        objProdutoDTO.setNome(request.getParameter("nome"));
        objProdutoDTO.setCategoria_id(Integer.parseInt(request.getParameter("categoria_id")));
        objProdutoDTO.setValor(Float.parseFloat(request.getParameter("valor")));
        objProdutoDTO.setImgBlob(imageBytes);
        objProdutoDAO.inserir(objProdutoDTO);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
