package io.github.oliviercailloux.y2018;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListCourseServlet
 */
@WebServlet(name = "ListCourse", urlPatterns = { "/ListCourse" })
public class ListCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	DatabaseManager DBM;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("items", DBM.getCoursesById().values());
		request.getRequestDispatcher("/pages/coursesList.jsp").forward(request, response);
	}
}
