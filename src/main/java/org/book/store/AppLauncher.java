package org.book.store;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.glassfish.jersey.servlet.ServletContainer;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppLauncher {

    public static void main(String[] args) {
        startServer();
    }

    static void startServer() {
        final Server server = new Server(8080);
        final Path resourcePath = Paths.get(".", "ui").toFile().exists() ?
                Paths.get(".", "ui") : Paths.get("src", "ui");
        try {

            final ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
            servletContextHandler.setContextPath("/");
            servletContextHandler.setBaseResource(Resource.newResource(resourcePath.toAbsolutePath()));
            servletContextHandler.setWelcomeFiles(new String[] { "books.html" });
            server.setHandler(servletContextHandler);

            final ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/api/*");
            servletHolder.setInitOrder(0);
            servletHolder.setInitParameter(
                    "jersey.config.server.provider.packages",
                    "org.book.store.service"
            );

            ServletHolder holderDef = new ServletHolder("default", DefaultServlet.class);
            holderDef.setInitParameter("dirAllowed","true");
            servletContextHandler.addServlet(holderDef, "/");

            server.start();
            server.join();
        } catch (Exception ex) {
            System.out.println("Could not start the server");
            ex.printStackTrace();
            System.exit(1);
        } finally {
            server.destroy();
        }
    }
}
