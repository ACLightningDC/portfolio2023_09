package svc.seller.mall;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import vo.util.svc.ConAndDAO;

public class ShopUpdateService {

	public int shopUpdate(int sellerMallid, String name) {
		ConAndDAO conAndDao= daoSetConnection();
		
		int Check = conAndDao.getDao().shopUpdate(sellerMallid , name);
		
		commitOrCloseSvc(Check , conAndDao.getCon());
		
		return Check;
	}

}
