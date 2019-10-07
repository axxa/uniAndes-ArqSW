/******************************************************************/
/* Program Assignment:  3                                         */
/* Name:                Alvaro Suarez                             */
/* Date:                9 Feb 2015                                */
/* Description:         Programa que calcula la regresion lineal, */
/*                      coeficientes de correlacion y prediccion  
/*                      mejorada dado un tamaño de proxy          */
/******************************************************************/
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * es la clase main encargada de ejecutar todos los procedimientos
 *
 */
public class Main extends HttpServlet
{
   //private PathJavaExplorer pje;
    @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      showHome(req,resp);   
  }

  private void showHome(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
        List<CalculadoraDatos> cd = new LinkedList<CalculadoraDatos>();
        cd.add(new CalculadoraDatos(1));
        cd.add(new CalculadoraDatos(2));
        cd.add(new CalculadoraDatos(3));
        cd.add(new CalculadoraDatos(4));
        for (int i =0;i<cd.size();i++){
            int aux = i+1;
            resp.getWriter().print("\n _____________________________________________________");
            resp.getWriter().print("\n TEST " +  aux);
            resp.getWriter().print("\n Beta0: " + cd.get(i).getBeta0() + " Beta1: "+ cd.get(i).getBeta1());
            resp.getWriter().print("\n rxy:    " + cd.get(i).getRxy() + " r2: "+ cd.get(i).getR2());
            resp.getWriter().print("\n yk:     " + cd.get(i).getYk());
            resp.getWriter().print("\n _____________________________________________________");
        }
    
  }
  public static void main(String[] args) throws Exception {
    
    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new Main()),"/*");
    server.start();
    server.join();     
  }
}