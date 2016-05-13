package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.Students;
import service.StudentsDao;
import service.impl.StudentsDaoImpl;

public class StudentsAction extends SuperAction {
	
	

	//查询所有学生
	public String query(){
		StudentsDao sdao =new StudentsDaoImpl();
		List<Students> list = sdao.queryAllStudents();
		//放进session中
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
		}return "query_success";
	}
	
	//根据学生姓名查询
	public String queryBySname(){
		//获得传过来的学生编号
		String sname = request.getParameter("sname");
		StudentsDao sdao =new StudentsDaoImpl();
		Students s = sdao.queryStudentsBySid(sname);
		//保存在会话中
		session.setAttribute("queryBySname_students", s);
		return "queryBySname_success";
		
	}
	
	//删除学生
	public String delete(){
		StudentsDao sdao =new StudentsDaoImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
	//添加学生
	public String add() throws Exception{
		Students s = new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDao sdao =new StudentsDaoImpl();
		sdao.addStudents(s);
		return "add_success";
		
	}
	
	//修改学生资料
	public String modify(){
		//获得传过来的学生编号
		String sid = request.getParameter("sid");
		StudentsDao sdao =new StudentsDaoImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//保存在会话中
		session.setAttribute("modify_students", s);
		return "modify_success";
		
	}
	
	//保存修改后的学生资料
	public String save() throws Exception{
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDao sdao =new StudentsDaoImpl();
		sdao.updateStudents(s);
		return "save_success";
		
	}

}
