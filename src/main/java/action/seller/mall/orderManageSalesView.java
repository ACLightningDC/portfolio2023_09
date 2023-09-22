package action.seller.mall;

import static util.action.ActionUtil.ActionForwardForUpdate;
import static util.action.ActionUtil.CheckLogin;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import com.google.gson.Gson;

import action.Action;
import svc.seller.mall.OrderManageSalesViewService;
import vo.ActionForward;
import vo.ShoppingCart;

public class orderManageSalesView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 체크
				CheckLogin(request, response); 
				
				HttpSession session =  request.getSession();
				int sellerMallid = (int) session.getAttribute("sellerMallid");
				
				OrderManageSalesViewService orderManageSalesViewservice = new OrderManageSalesViewService();
				ArrayList<ShoppingCart> ShoppingList = orderManageSalesViewservice.orderManageSalesView(sellerMallid); 
				
				int sum = 0;
				for(int i = 0 ; i<ShoppingList.size(); i++) {
					ShoppingCart order = ShoppingList.get(i);
					sum += order.getOrder_count() * order.getPrice();
				}
				//gson 파일 뿌리기
//				String path = request.getContextPath()+"/resource/json/saleDatabase.json";
				
				ServletContext context = request.getServletContext();
				String uploadPath = context.getRealPath("/resource/json/saleDatabase"+sellerMallid+".json");
				
				File file = new File(uploadPath);
				if(!file.exists()) {
					file.createNewFile();
				}
				
				try(PrintWriter out = new PrintWriter(new FileWriter(uploadPath))){
					String jsonShoppingList = new Gson().toJson(ShoppingList);
					out.write(jsonShoppingList);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				//끝
				
				
				String Message = "실패했습니다.";
				ActionForward forward = ActionForwardForUpdate(request, response, 1, Message, "/sellerUser/shoppingMall/orderManage/orderManageSales.jsp" );
				
				request.setAttribute("ShoppingCartList", ShoppingList);
				request.setAttribute("sum", sum);
				
				return forward;
	}

}
