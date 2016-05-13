package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
//���ɱ�ṹ
public class TestStudents {
	@Test
	public void testSchemaExport(){
		//�������ö���
	Configuration config  = new Configuration().configure();
	//����SchemaExport����
	SchemaExport export = new SchemaExport(config);
	
	
	export.create(true, true);
	}
	
	
	
	//��Ӳ�������
	@Test
	public void testSaveStudents(){
		Configuration config = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceregistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//����sessionFactory
		SessionFactory sessionFactory =  config.buildSessionFactory(serviceregistry);
		Session session = sessionFactory.getCurrentSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		Students s1 = new  Students("s0000001","�����","Ů",new Date(),"����");
		Students s2 = new  Students("s0000002","Doris","Ů",new Date(),"����");
		Students s3 = new  Students("s0000003","Cario","��",new Date(),"�Ϻ�");
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		tx.commit();
		sessionFactory.close();
		 
	}
}
