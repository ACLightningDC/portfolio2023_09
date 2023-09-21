package action.seller.product;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.seller.product.ProductAddService;
import vo.ActionForward;
import vo.Product;

public class productAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("images");
		
		File dir = new File(uploadPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		int size = 1024*1024*10;
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath 
				, size ,"utf-8", new DefaultFileRenamePolicy());
		
		HttpSession session = request.getSession();
		
		int sellerMall_id = (int) session.getAttribute("sellerMallid");
		int price = Integer.parseInt(multi.getParameter("price")); 
		String name = multi.getParameter("name");
		String kind = multi.getParameter("kind");
		String img = multi.getFilesystemName("img");
		
		Product product = new Product();
		product.setSellerMall_id(sellerMall_id);
		product.setPrice(price);
		product.setName(name);
		product.setKind(kind);
		product.setImg(img);
		
		ProductAddService productAddService = new ProductAddService();
		int success = productAddService.addproduct(product);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();	
		ActionForward forward = null;
		
		if(success > 0  ) {
			System.out.println("success 작동");
			forward = new ActionForward("productManage.shop", true); 
		}else {
			out.println("<script>");
			out.println("alert('제품 추가에 실패했습니다.');");
			out.println("history.back()");
			out.println("</script>");
		}
		System.out.println("forward 이전");
		return forward;
	}

}
