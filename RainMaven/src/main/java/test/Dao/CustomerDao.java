package test.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import test.beans.Customer;

public class CustomerDao {
	
	
	JdbcTemplate t1;
	

	public void setT1(JdbcTemplate t1) {
		this.t1 = t1;
	}


	public int registerinfo(Customer c1) 
	{
		return t1.update("insert into customer(cname,cemail,cphone,cpass,ccpass) values('"+c1.getCname()+"','"+c1.getCemail()+"','"+c1.getCphone()+"','"+c1.getCpass()+"','"+c1.getCcpass()+"')");
		
	}
	public List<Customer> displayinfo()
	{
		return t1.query("select * from customer", new RowMapper<Customer>() 
		{

			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
			
				Customer ch = new Customer();
				ch.setCid(rs.getInt(1));
				ch.setCname(rs.getString(2));
				ch.setCemail(rs.getString(3));
				ch.setCphone(rs.getString(4));
				ch.setCpass(rs.getString(5));
				ch.setCcpass(rs.getString(6));
				
				
				return ch;
			}
			
			 
		});

	}


	public int deleteinfo(int id) 
	{
		return t1.update("delete from customer where cid='"+id+"' ");
		
		
	}


	public List<Customer> editdata(int id) 
	{
		return t1.query("select * from customer where cid='"+id+"'", new RowMapper<Customer>() 
		{

			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
			
				Customer ch = new Customer();
				ch.setCid(rs.getInt(1));
				ch.setCname(rs.getString(2));
				ch.setCemail(rs.getString(3));
				ch.setCphone(rs.getString(4));
				ch.setCpass(rs.getString(5));
				ch.setCcpass(rs.getString(6));
				
				
				return ch;
			}
			
			 
		});
		
	}


	public int updatecustomerinfo(Customer c1) 
	{
		return t1.update("update customer set cname='"+c1.getCname()+"',cemail='"+c1.getCemail()+"',cphone='"+c1.getCphone()+"',cpass='"+c1.getCpass()+"',ccpass='"+c1.getCcpass()+"' where cid='"+c1.getCid()+"' ");
		
		
	}
	
	
	} 