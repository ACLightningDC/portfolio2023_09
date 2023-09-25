package svc.json.seller;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import java.util.ArrayList;

import vo.Product;
import vo.util.svc.ConAndDAO;

public class MallProductSeletService {


	public ArrayList<Product> mallProductSelet(int id) {
		ConAndDAO conAndDao= daoSetConnection();
		
		ArrayList<Product> productList = conAndDao.getDao().getProductList(id);
		
		commitOrCloseSvc(conAndDao.getCon());
		
		return productList ;
	}
	
	
}
