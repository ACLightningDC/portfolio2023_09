package svc.user;

import static util.svc.SvcUtil.commitOrCloseSvc;
import static util.svc.SvcUtil.daoSetConnection;

import vo.Users;
import vo.util.svc.ConAndDAO;

public class MyImformationUpdateaService {
	

	


	public int myImformationUpdate(Users inputuser) {
		ConAndDAO conAndDao= daoSetConnection();
		
		int Check = conAndDao.getDao().myImformationUpdate(inputuser);
		
		commitOrCloseSvc(Check , conAndDao.getCon());
		
		return Check;
	}}
