package svc.seller.mall;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import java.util.ArrayList;

import vo.Product;
import vo.util.svc.ConAndDAO;

public class MallproductService {

	public ArrayList<Product> mallproductGet(int mallID) {
		ConAndDAO conAndDao= daoSetConnection();
		ArrayList<Product>  productList = conAndDao.getDao().mallproductGet(mallID);
		commitOrCloseSvc(conAndDao.getCon());
		
		return productList;
	}
}
