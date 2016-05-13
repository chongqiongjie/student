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
//生成表结构
public class TestStudents {
	@Test
	public void testSchemaExport(){
		//创建配置对象
	Configuration config  = new Configuration().configure();
	//创建SchemaExport对象
	SchemaExport export = new SchemaExport(config);
	
	
	export.create(true, true);
	}
	
	
	
	//添加测试数据
	@Test
	public void testSaveStudents(){
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceregistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建sessionFactory
		SessionFactory sessionFactory =  config.buildSessionFactory(serviceregistry);
		Session session = sessionFactory.getCurrentSession();
		//创建事务
		Transaction tx = session.beginTransaction();
		
		Students s1 = new  Students("s0000001","种琼洁","女",new Date(),"陕西");
		Students s2 = new  Students("s0000002","Doris","女",new Date(),"西安");
		Students s3 = new  Students("s0000003","Cario","男",new Date(),"上海");
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		tx.commit();
		sessionFactory.close();
		 
	}
}
