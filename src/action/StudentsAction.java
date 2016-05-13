package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.Students;
import service.StudentsDao;
import service.impl.StudentsDaoImpl;

public class StudentsAction extends SuperAction {
	
	

	//��ѯ����ѧ��
	public String query(){
		StudentsDao sdao =new StudentsDaoImpl();
		List<Students> list = sdao.queryAllStudents();
		//�Ž�session��
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
		}return "query_success";
	}
	
	//����ѧ��������ѯ
	public String queryBySname(){
		//��ô�������ѧ�����
		String sname = request.getParameter("sname");
		StudentsDao sdao =new StudentsDaoImpl();
		Students s = sdao.queryStudentsBySid(sname);
		//�����ڻỰ��
		session.setAttribute("queryBySname_students", s);
		return "queryBySname_success";
		
	}
	
	//ɾ��ѧ��
	public String delete(){
		StudentsDao sdao =new StudentsDaoImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
	//���ѧ��
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
	
	//�޸�ѧ������
	public String modify(){
		//��ô�������ѧ�����
		String sid = request.getParameter("sid");
		StudentsDao sdao =new StudentsDaoImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//�����ڻỰ��
		session.setAttribute("modify_students", s);
		return "modify_success";
		
	}
	
	//�����޸ĺ��ѧ������
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
