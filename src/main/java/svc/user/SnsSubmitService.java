package svc.user;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import vo.util.svc.ConAndDAO;

public class SnsSubmitService {

	public int snsSubmit(int users_id, String snsId, String snsEmail) {
		ConAndDAO conAndDao= daoSetConnection();
		
		int Check = conAndDao.getDao().snsSubmit(users_id ,snsId , snsEmail);
		
		commitOrCloseSvc(Check , conAndDao.getCon());
		return Check;
	}

	public int usersupdatesnsSubmit(int users_id) {
		ConAndDAO conAndDao= daoSetConnection();
		
		int Check = conAndDao.getDao().usersupdatesnsSubmit(users_id);
		
		commitOrCloseSvc(Check , conAndDao.getCon());
		return Check;
	}

}
