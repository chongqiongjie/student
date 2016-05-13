package service;

import java.util.List;

import entity.Students;

public interface StudentsDao {
	//��ѯ����ѧ������
	public List<Students> queryAllStudents();
	//���ݱ�Ų�ѯѧ������
	public Students queryStudentsBySid(String sid);
	//����ѧ��������ѯ
	public Students queryStudentsBySname(String sname);
	//���ѧ������
	public boolean addStudents(Students s);
	//�޸�ѧ������
	public boolean updateStudents(Students s);
	//ɾ��ѧ������
	public boolean deleteStudents(String sid);
	
}
