package action.json.seller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import action.ActionForJson;
import svc.json.seller.MallProductSeletService;
import vo.Product;

public class MallProductSeletAction implements ActionForJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jsonString = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		MallProductSeletService mallProductSeletService  = new MallProductSeletService();
		ArrayList<Product> ProductList =  mallProductSeletService.mallProductSelet(id);
		
		jsonString = new Gson().toJson(ProductList);
		
		return jsonString;
	}

}
