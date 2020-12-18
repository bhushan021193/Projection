package com.cjc.projection;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class GetSessionFactory {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionf;

	public static SessionFactory getsesssionFactory() {
		if (sessionf == null) {
			Map<String, Object> settings = new HashMap<String, Object>();
			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/projection");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			settings.put(Environment.SHOW_SQL, "true");

			registry = new StandardServiceRegistryBuilder().applySettings(settings).build();
			MetadataSources mds = new MetadataSources(registry);
			
			mds.addAnnotatedClass(Employee.class);
			
			Metadata md = mds.getMetadataBuilder().build();
			sessionf = md.getSessionFactoryBuilder().build();

		}
		return sessionf;

	}

}
