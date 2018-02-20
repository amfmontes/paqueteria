package llevarPaquete;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LlamadaTabla
 */
@WebServlet("/LlamadaTabla")
public class LlamadaTabla extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LlamadaTabla() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");

		
		List<PedidoPojo> listaEnvios = new ArrayList<PedidoPojo>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enviopaquetes", "root", "");

			// //CONSULTAR UN REGISTRO
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM envios where origen='"+ origen + "' and destino= '"+ destino+"'");
			// PreparedStatement ps2 = conn.prepareStatement("SELECT destino FROM envios WHERE origen=? AND destino=?"); 
			
		//	ps.setString(1, origen);
			//ps.setString(2, destino);
	
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PedidoPojo pedido = new PedidoPojo();
				pedido.setIdEnvio(rs.getInt("idEnvio"));
				pedido.setOrigen(rs.getString("origen"));
				pedido.setDestino(rs.getString("destino"));
				pedido.setTamano(rs.getString("tamano"));
				pedido.setFecha(rs.getString("fecha"));
				listaEnvios.add(pedido);
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// request.getSession();
		request.setAttribute("listaEnvios", listaEnvios);
		request.getSession().setAttribute("origen", origen);
		request.getSession().setAttribute("destino", destino);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/presentacionTabla.jsp");
		rd.forward(request, response);

		// response.sendRedirect("presentacionTabla.jsp");
	}

}
