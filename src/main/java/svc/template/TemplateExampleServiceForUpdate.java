package svc.template;

import static util.svc.SvcUtil.*;

import vo.util.svc.ConAndDAO;

public class TemplateExampleServiceForUpdate {
	public void Template(){
		
		ConAndDAO conAndDao= daoSetConnection();
		
		int Check = 0;
		
		commitOrCloseSvc(Check , conAndDao.getCon());
	}
	public void TemplatenoUpdate(){
		
		ConAndDAO conAndDao= daoSetConnection();
		
		commitOrCloseSvc(conAndDao.getCon());
	}
}
