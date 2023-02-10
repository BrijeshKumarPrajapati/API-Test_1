import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import com.connection.Conn;

public class UsersServelet extends HttpServlet { 
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setStatus(204);
		//resp.setHeader("Content-Type", "application/json");
		/*try {
			resp.getOutputStream().println(new JSONObject().put("id","10").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setStatus(200);
		resp.setHeader("Content-Type", "application/json");
		try {
			resp.getOutputStream().println(new JSONObject().put("id","10").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(200);
		resp.setHeader("Content-Type", "application/json");
		try {
			resp.getOutputStream().println(new JSONObject().put("name", "Brijesh").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String jsonBody = new BufferedReader(new InputStreamReader(request.getInputStream())).lines()
					.collect(Collectors.joining("\n"));
			// System.out.println("This is json body"+jsonBody);
			JSONObject jObj = new JSONObject(jsonBody);
			// System.out.println("this is json object"+jObj);
			Connection con = Conn.getCon();
			System.out.println("Connection is : " + con);
			PreparedStatement stmt = con.prepareStatement("insert into emp (name,gender) values(?,?)");

			stmt.setString(1, jObj.getString("name"));
			stmt.setString(2, jObj.getString("gender"));
			int i = stmt.executeUpdate();
			System.out.println(i + "records inserted");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	public String home() {
		return "This is my seet home";
	}
}