package entrega;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Entrega
 */
@WebServlet("/Entrega")
public class Entrega extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String nombreUsuario = "admin";
	private final String password = "password";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Entrega() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
		String nombre= request.getParameter("nombre");
		String pass= request.getParameter("password");
		
	//	request.getSession().setAttribute("pass", pass);
		
		if(nombreUsuario.equals(nombre) && password.equals(pass)){
			HttpSession session = request.getSession();
			System.out.println("entro en el if");
			session.setAttribute("nombre", nombre);
			response.sendRedirect("pedido.jsp");
		}else{
			System.out.println("fallo en el if");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
		
			    		    		
     				}
	}//el del metodo POST

}//el de la clase
