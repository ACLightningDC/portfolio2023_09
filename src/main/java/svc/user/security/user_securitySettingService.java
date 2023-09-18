package svc.user.security;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import vo.util.svc.ConAndDAO;

public class user_securitySettingService {


	public int user_securitySetting(int users_id, String ipAddress, String model) {
		
		
		ConAndDAO conAndDao= daoSetConnection();
		
		int Check = conAndDao.getDao().user_securitySetting(users_id , ipAddress , model);
		
		commitOrCloseSvc(Check , conAndDao.getCon());
		
		return Check;
	}
	
}
