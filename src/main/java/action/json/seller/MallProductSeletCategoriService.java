package action.json.seller;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import java.util.ArrayList;

import vo.Product;
import vo.util.svc.ConAndDAO;

public class MallProductSeletCategoriService {

	public ArrayList<Product> mallProductCategoriSelet(String type) {
		ConAndDAO conAndDao= daoSetConnection();
		
		System.out.println(type);
		
		ArrayList<Product> productList = conAndDao.getDao().getProductCategoriList(type);
		
		commitOrCloseSvc(conAndDao.getCon());
		
		return productList ;
		
	}

}
