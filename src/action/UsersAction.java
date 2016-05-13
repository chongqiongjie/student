package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDao;
import service.impl.UsersDaoImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

public class UsersAction  extends SuperAction implements ModelDriven<Users>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Users user = new Users();
	
	
	
	//用户登陆动作
	public String login(){
		
		UsersDao udao = new UsersDaoImpl();
		if(udao.usersLogin(user)){
			
			//在session中保存登陆成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			
			return "login_success";
		}else
		{
			return "login_failure";
		}
	
	} 
	//检查用户名不能为空
	@Override
	public void validate() {
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空");
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "密码长度不少于6位");
		}
		
	}
	@SkipValidation
	//安全退出
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
	

}
