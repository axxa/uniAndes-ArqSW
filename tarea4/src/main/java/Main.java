/******************************************************************/
/* Program Assignment:  4                                         */
/* Name:                Alvaro Suarez                             */
/* Date:                14 Feb 2015                                */
/* Description:         Programa que calcula la regresion lineal, */
/*                      coeficientes de correlacion y prediccion  
/*                      mejorada dado un tamaño de proxy          */
/******************************************************************/
import java.io.IOException;
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
    @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      showHome(req,resp);   
  }

  private void showHome(HttpServletRequest req, HttpServletResponse resp) throws IOException{
      show("1",new CalculadoraDatos(1),req,resp);     
      show("2",new CalculadoraDatos(2),req,resp);
  }
  private void show(String testName,CalculadoraDatos cd,HttpServletRequest req, HttpServletResponse resp) throws IOException{
      resp.getWriter().print("\n _____________________________________________________");
      resp.getWriter().print("\n TEST " + testName);
      resp.getWriter().print("\n VS: " + cd.getvS() + "  S: "+ cd.getS());
      resp.getWriter().print("\n M:  " + cd.getM() + " L: " + cd.getL());
      resp.getWriter().print("\n VL: " + cd.getvL());
      resp.getWriter().print("\n _____________________________________________________");
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