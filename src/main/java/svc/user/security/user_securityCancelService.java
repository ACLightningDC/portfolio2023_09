package svc.user.security;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import vo.util.svc.ConAndDAO;

public class user_securityCancelService {

	public int user_securityCancel(int users_id) {
		ConAndDAO conAndDao= daoSetConnection();
		
		int Check = conAndDao.getDao().user_securityCancel(users_id);
			Check = conAndDao.getDao().userIdSecurityCancel(users_id);
		
		commitOrCloseSvc(Check , conAndDao.getCon());
		
		return Check;
	}

}
