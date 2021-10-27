package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	
	//객체 생성
	private static SqlSessionFactory sqlSessionFactory;
		
	static {
			
		//마이바티스 Configuration XML 파일의 경로
		String res = "mybatis/mybatis-config.xml";
		
		try {
			//Configuration XML파일을 이용한 입력 스트림 생성
			Reader reader = Resources.getResourceAsReader(res);
			
			//싱글톤 유지 코드
			if(sqlSessionFactory == null) {
				
				//입력 스트림으로 읽어들인 설정파일을 이용하여 SqlSessionFactory객체 생성
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
			
	}
	
	//private 생성자 ( 위에 static이후에 다른 객체 생성이 되지 않게 private생성자를 만들어 준다 )
	private MyBatisConnectionFactory() {}

	public static SqlSessionFactory getSqlSessionFactory() {
			return sqlSessionFactory;
	}









}