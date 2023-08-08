

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registert
 */
@WebServlet("/registert")
public class registert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("fname").concat(" "+request.getParameter("lname"));
		String uName = request.getParameter("uname");
		String pass = String.valueOf(request.getParameter("password"));
		String mobile = request.getParameter("number");
		String mail = request.getParameter("email");
		String Date = request.getParameter("date");
		String genders = request.getParameter("gender");
		String addresss = request.getParameter("address");
		String plase = request.getParameter("city");
		String langtemp [] = request.getParameterValues("language");
		String lang="";
		for (int i = 0; i < langtemp.length; i++) {
			if (!lang.isEmpty()) {
				lang=lang.concat(" "+langtemp[i]);
			}
			else {
				lang=langtemp[i];
			}
		}
		String quli = request.getParameter("course");
		if (connectivity.register(name,uName,pass,mobile,mail,Date,genders,addresss,plase,lang,quli)) {

			out.print(" successfully registered");
			
			}
		else {
			out.print(" user name already exist");
			RequestDispatcher rd = request.getRequestDispatcher("register.html");
			rd.include(request, response);
		}
	}

}
