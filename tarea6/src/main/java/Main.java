import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
/**
 * Clase Main
 * @author alvaro suarez
 * @version 1.0.20150225
 * @since 1.0.20150225
 */
public class Main extends HttpServlet{
  /**
   * doGet
   * @param req HttpServletRequest
   * @param resp HttpServletResponse
   * @throws ServletException excepcion
   * @throws IOException excepcion
   */ 
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      showHome(req,resp);   
  }
  /**
   * Prepara los datos a mostrar
   * @param req HttpServletRequest
   * @param resp HttpServletResponse
   * @throws IOException excepcion
   */  
  private void showHome(HttpServletRequest req, HttpServletResponse resp) throws IOException{
      show("1",new XCalculador(1),req,resp);     
      show("2",new XCalculador(2),req,resp);
      show("3",new XCalculador(3),req,resp);
  }
  
  /**
   * Muestra los datos
   * @param testName String
   * @param cd XCalculador
   * @param req HttpServletRequest
   * @param resp HttpServletResponse
   * @throws IOException excepcion
   */
  private void show(String testName,XCalculador cd,HttpServletRequest req, HttpServletResponse resp) throws IOException{      
      resp.getWriter().print("\n _____________________________________________________");
      resp.getWriter().print("\n TEST " + testName);
      resp.getWriter().print("\n x: " + cd.getLimiteF());
      //resp.getWriter().print("\n M:  " + cd.getM() + " L: " + cd.getL());
      //resp.getWriter().print("\n VL: " + cd.getvL());
      resp.getWriter().print("\n _____________________________________________________");
              
  }

    /**
     * Metodo main
     * @param args String[]
     * @throws Exception excepcion
     */
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