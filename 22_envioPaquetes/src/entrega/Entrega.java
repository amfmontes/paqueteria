package entrega;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import llevarPaquete.PedidoPojo;

/**
 * Servlet implementation class Entrega
 */
@WebServlet("/Entrega")
public class Entrega extends HttpServlet {
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Entrega() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

//	private final String nombreUsuario= "admin";
//	private final String password = "123" ;

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//me llega la url "proyecto/index/out"
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
		String nombre= request.getParameter("nombre");
		String password= request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enviopaquetes", "root", "");
			
		//HABRA QUE HACE PAGINA DE REGISTROS Y ESTO IRA ALLI
//		PreparedStatement ps = conn.prepareStatement("INSERT INTO usuarios (nombre,password) VALUES (?,?)"); 
//		ps.setString(1, nombre);
//		ps.setString(2, pass);
//		
//		int insertar= ps.executeUpdate();
		
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios where nombre='"+ nombre + "' and password= '"+ password+"'");
			
		ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
		
		if(nombre.equals(rs.getString("nombre")) && password.equals(rs.getString("password"))){
			HttpSession session = request.getSession();
			System.out.println("entro en el if");
			session.setAttribute("nombre", nombre);
			response.sendRedirect("zonaUsuarios/pedido.jsp");
		}else{
			//He comprobado que esta parte no la hace-> Mirarlo
			System.out.println("fallo en el if");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Nombre o contraseña inválidos.</font>");
		
			    		    		
     				}
		 }
		 conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	request.getSession().setAttribute("pass", pass);
	}//el del metodo POST

}//el de la clase
