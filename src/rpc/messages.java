package rpc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import algorithm.ShaEncryption;

/**
 * Servlet implementation class messages
 */
@WebServlet("/messages/*")
public class messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Hashtable<String, String> codeTable = new Hashtable<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public messages() {
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

		String code = request.getPathInfo().substring(1);

		String base = ShaEncryption.sha256Decription(code, codeTable);

		if (base != null) {
			String jsonString = "{\"message\":\"" + base + "\"}";

			JSONObject respObj = null;
			try {
				respObj = new JSONObject(jsonString);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RpcHelper.writeJsonObject(response, respObj);

		}

		else {

			String jsonString = "{\"err_msg\":\"" + "Message not found" + "\"}";

			JSONObject respObj = null;
			try {
				respObj = new JSONObject(jsonString);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			//response.sendError(HttpServletResponse.SC_NOT_FOUND,jsonString);
			RpcHelper.writeJsonObject(response, respObj);
			
			//response.getWriter().append("Served at: ").append(code);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject reqObj = RpcHelper.readJsonObject(request);
		String base = null;
		try {
			base = reqObj.getString("message");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String code = ShaEncryption.sha256(base);
		this.codeTable.put(code, base);
		String jsonString = "{\"digest\":\"" + code + "\"}";

		JSONObject respObj = null;
		try {
			respObj = new JSONObject(jsonString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RpcHelper.writeJsonObject(response, respObj);

	}

}