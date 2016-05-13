package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;//�Ự����ģʽ
	//��֤����ģʽ
	private MyHibernateSessionFactory(){
		
	}
	//���еľ�̬��������ûỰ����ģʽ
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			Configuration config = new Configuration().configure();
			//��������ע�����
			ServiceRegistry serviceregistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//����sessionFactory
			 sessionFactory =  config.buildSessionFactory(serviceregistry);
			
			return sessionFactory;
		}else{
			return sessionFactory;
		}
	
	}
}
