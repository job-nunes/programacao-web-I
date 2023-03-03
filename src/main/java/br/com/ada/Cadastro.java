package br.com.ada;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String placa = req.getParameter("placa");
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        String tipo = req.getParameter("tipo");
        String ano = req.getParameter("ano");

        if(placa.equals("") || modelo.equals("") || marca.equals("") || ano.equals("") || tipo.equals("")){
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>Digite todos os campos</h3>");
        } else {
            req.setAttribute("placa", placa);
            req.setAttribute("modelo", modelo);
            req.setAttribute("marca", marca);
            req.setAttribute("ano", ano);
            req.setAttribute("tipo", tipo);
            RequestDispatcher rd = req.getRequestDispatcher("data.jsp");
            rd.forward(req, resp);
        }

    }
}
