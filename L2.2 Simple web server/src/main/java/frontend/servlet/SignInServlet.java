package frontend.servlet;

import base.AccountService;
import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet{

    private final AccountService accountServices;

    public SignInServlet(AccountService accountServices) {
        this.accountServices = accountServices;
    }

    public void doPost (HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {

        String login =request.getParameter("login");
        String password =request.getParameter("password");

        boolean loggedIn =accountServices.signIn(login,password);
        response.setContentType("text/html;charset=utf-8");

        if (loggedIn){
            response.getWriter().println("Authorized");
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.getWriter().println("Unathorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
