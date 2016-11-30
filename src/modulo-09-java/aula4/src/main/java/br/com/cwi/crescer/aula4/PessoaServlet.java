package br.com.cwi.crescer.aula4;

import java.io.IOException;
import java.io.PrintWriter;
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
    private PessoaBean pessoaBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter();) {
            out.append("<table class=\"table table-hover\"><thead><tr><th>Nome</th></tr></thead><tbody>");
            
            pessoaBean.findAll().forEach(p-> {
                out.append("<tr><td>").append(p.getNmPessoa()).append("</td></tr>");
            });
            
            out.append("</tbody></table>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String nome = req.getParameter("nome");
        if (nome != null) {
            final Pessoa pessoa = new Pessoa();
            pessoa.setNmPessoa(nome);
            pessoaBean.insert(pessoa);
        }
        resp.sendRedirect("/aula4");
    }

    
    
}
