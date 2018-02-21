package entrega;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Alta
 */
@WebServlet("/zonaUsuarios/Alta")
public class Alta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Llega al servlet GET");
		String action=(request.getPathInfo()!=null?request.getPathInfo():"/22_envioPaquetes");
        HttpSession sesion = request.getSession();
        if(action.equals("/22_envioPaquetes")){
            sesion.invalidate();
            response.sendRedirect("/22_envioPaquetes");
        }else{
           
        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
//		java.util.Date stringFecha=new java.util.Date(request.getParameter("fecha"));
		
		String origen= request.getParameter("origen");
		String destino= request.getParameter("destino");
		String tamano= request.getParameter("tamano");
		//String fecha=request.getParameter("fecha");
		String fechaDate = request.getParameter("fecha");
		SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = formato.parse(fechaDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		java.sql.Date fecha = new java.sql.Date(date.getTime());
		//Date fechaDate = request.getParameter("fecha");
//		SimpleDateFormat formato1= new SimpleDateFormat("yyyy-MM-dd");
//		formato1.format(fechaDate);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enviopaquetes", "root", "");
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO envios (origen,destino,tamano,fecha) VALUES (?,?,?,?)"); 
		ps.setString(1, origen);
		ps.setString(2, destino);
		ps.setString(3, tamano);
		ps.setDate(4,  fecha);
		int insertar= ps.executeUpdate();
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		response.sendRedirect("exito.jsp");
		
	}

}
