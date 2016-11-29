package br.com.cwi.crescer.aula4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Carlos H. Nonnemacher
 */
@WebServlet(name = "pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    @EJB
    private PessoaBean bean;

    List<String> nomes = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("nome");
        if (parameter != null) {
            nomes.add(parameter);
        }
        try (PrintWriter writer = response.getWriter();) {

            for (String s : nomes) {
                writer.append(s).append("<br/>");
            };
        }

    }

}
