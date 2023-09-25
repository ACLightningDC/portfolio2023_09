package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public interface ActionForJson {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
