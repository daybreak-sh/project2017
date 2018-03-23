
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation class Sample */
@WebServlet("/Sample")
public class Sample extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** @see HttpServlet#HttpServlet() */
	public Sample() {
		super();
	}

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final PrintWriter writer = response.getWriter();
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>HelloWorld!!</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("HelloWorld!!(03)");
		writer.append("</body>");
		writer.append("</html>");
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
