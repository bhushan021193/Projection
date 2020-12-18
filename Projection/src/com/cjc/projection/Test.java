package com.cjc.projection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class Test {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projection", "root", "root");

		// String sql = "insert into employee values(92,'abhilash',80000)";

		// String sql1 = "ALTER TABLE employee DROP ADDR112 VARCHAR(200) NOT NULL";
		// Adding single column in existing table

		// String sql11 = "SELECT SUBSTRING( name, 1, 3 ) FROM employee;";
		// getting 1st 3 digits of column where 1 is starting point and 3 is no of digits

		//String sql2 = "ALTER TABLE employee DROP ADDR1";// to drop single column
		//String sql2="SELECT name ,salary,id FROM employee WHERE name in ('prasad','chetan') group by salary";
		//joins kk
		String sql2="SELECT COUNT(id) FROM employee ";
		Statement smt = con.createStatement();
		ResultSet rs=smt.executeQuery(sql2);
		
		while (rs.next()) {
			
			System.out.println(rs.getString(1));
//			System.out.println(rs.getString(2));
//			System.out.println(rs.getString(3));
		}
		// smt.execute(sql1);

//		ResultSet rs = smt.executeQuery(sql11);
//
//		while (rs.next()) {
//			System.out.println(rs.getString(1)); // or rs.getString("column name");
//		}

		// getting list of employee whose salary is greater than 50000
//		GetSessionFactory gs = new GetSessionFactory();
//		Session session = gs.getsesssionFactory().openSession();
//		Criteria c = session.createCriteria(Employee.class);
//		c.add(Restrictions.gt("salary", 80000));
//		System.out.println("list");
//		System.out.println(c.list());
//		Criteria c1 = session.createCriteria(Employee.class);
//		
//		
//		// getting single column
//		c1.setProjection(Projections.property("salary"));
//		System.out.println(c1.list());
//		System.out.println(c1.list().isEmpty());
	}

}
