package svc.user;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import vo.util.svc.ConAndDAO;

public class SnsLoginService {

	public int snsLoginService(String snsId, String snsEmail) {
		
		ConAndDAO conAndDao= daoSetConnection();
		int users_id = conAndDao.getDao().ForSnsLoginGetUsers_id(snsId , snsEmail);
		commitOrCloseSvc(conAndDao.getCon());
		
		return users_id;
	}

}
