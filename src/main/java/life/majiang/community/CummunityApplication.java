package life.majiang.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "life.majiang.community.mapper.ning")
public class CummunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CummunityApplication.class, args);
    }

}
