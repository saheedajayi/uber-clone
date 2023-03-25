package africa.semicolon.uberClone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UberCloneApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testDatabaseConnection(){
		DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://127.0.0.1:3306/", "root", "Saheed&Ajayi123");

		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
			assertThat(connection).isNotNull();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
