package config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBManager {
    private static DBManager instance = new DBManager();
    private Connection conn;
    private SqlSessionFactory factory;
    
    private DBManager() {
    	
		String resource = "config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			conn = factory.openSession(true).getConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public static DBManager getInstance() {
    	if(instance == null)
    		instance = new DBManager();
    	return instance;
    }
    public SqlSession getSession() {
		return factory.openSession(true);
	}
    
	public Connection getConn() {
		return conn;
	}
	public void close(ResultSet rs, PreparedStatement pstmt) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
