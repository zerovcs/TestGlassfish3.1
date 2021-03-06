package si.test.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ServletReturnJson
 */
@WebServlet("/ServletReturnJson")
public class ServletReturnJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReturnJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ReturnObject returnObject = new ReturnObject();
		returnObject.x = "X value";
		returnObject.y = 123;
		returnObject.list = new ArrayList<>();
		returnObject.list.add("list item 1");
		returnObject.list.add("list item 2");
		returnObject.list.add("list item 3");
		returnObject.list.add("list item 4");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(returnObject));
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().write(mapper.writeValueAsString(returnObject));
	}

	public static class ReturnObject
	{
		private String x;
		private int y;
		private List<String> list;
		public String getX() {
			return x;
		}
		public void setX(String x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public List<String> getList() {
			return list;
		}
		public void setList(List<String> list) {
			this.list = list;
		}
		
	}
}
