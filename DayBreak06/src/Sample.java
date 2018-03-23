
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");

			// DBに接続
			connection = DriverManager.getConnection("jdbc:sqlite:/home/admin/sqlite/DayBreak06.db");
			statement = connection.createStatement();
			
			// HelloWorld文言削除
			final String deleteSql = "delete from sample";
			statement.execute(deleteSql);
			
			// HelloWorld文言作成
			final String createSql = "insert into sample values('HelloWorld')";
			statement.execute(createSql);
			
			// HelloWorld文言更新
			final String updateSql = "update sample set word = 'HelloWorld!!(06)'";
			statement.execute(updateSql);
			
			// HelloWorld文言取得
			final String selectSql = "select * from sample order by word";
			final ResultSet resultSet = statement.executeQuery(selectSql);
			while (resultSet.next()) {
				writer.append(resultSet.getString(1));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		writer.append("</body>");
		writer.append("</html>");
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
