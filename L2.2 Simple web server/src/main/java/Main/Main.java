package Main;

import base.AccountService;
import frontend.AccountServiceImp;
import frontend.servlet.SignInServlet;
import frontend.servlet.SignUpServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService =new AccountServiceImp();
       accountService.signUp("admin","admin");

        ServletContextHandler context= new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder( new SignInServlet(accountService)),"/signin");
        context.addServlet(new ServletHolder( new SignUpServlet(accountService)),"/signup");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("public_html");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[]{resourceHandler, context});

        Server server = new Server(8080);
        server.setHandler(context);
        System.out.println("Server started");
        java.util.logging.Logger.getGlobal().info("Server started\n");
        server.join();

    }

}
