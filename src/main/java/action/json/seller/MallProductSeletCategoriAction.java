package action.json.seller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import action.ActionForJson;
import svc.json.seller.MallProductSeletService;
import vo.Product;

public class MallProductSeletCategoriAction implements ActionForJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String jsonString = null;
		
		String type="음식";
		
		MallProductSeletCategoriService mallProductSeletCategoriService  = new MallProductSeletCategoriService();
		ArrayList<Product> ProductList =  mallProductSeletCategoriService.mallProductCategoriSelet(type);
		
		jsonString = new Gson().toJson(ProductList);
		
		return jsonString;
	}

}
