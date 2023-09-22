package svc.seller.order;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import vo.Delivery;
import vo.util.svc.ConAndDAO;

public class orderCheckFormService {

	public Delivery orderCheckForm(int delivery_id) {
		
		ConAndDAO conAndDao= daoSetConnection();
		Delivery del = null;
		del = conAndDao.getDao().orderCheckForm(delivery_id);
		
		commitOrCloseSvc(conAndDao.getCon());
		
		return del;
	}
	
}
