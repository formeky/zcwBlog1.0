package xyz.formeky.zcwblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zcw
 */
@MapperScan("xyz.formeky.zcwblog.mapper")
@SpringBootApplication
public class ZcwBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcwBlogApplication.class, args);
    }

}
