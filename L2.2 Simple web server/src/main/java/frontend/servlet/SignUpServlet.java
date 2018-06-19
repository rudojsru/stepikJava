package frontend.servlet;

import base.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
  private final AccountService accountServices;

    public SignUpServlet(AccountService accountServices) {
        this.accountServices = accountServices;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login =request.getParameter("login");
        String password =request.getParameter("password");

        boolean ifExist=accountServices.signIn(login,password);

        if (login == null || password == null || ifExist!=true){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }



        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("SignedUp");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
