package xyz.formeky.zcwblog;

import cn.dev33.satoken.secure.SaSecureUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZcwBlogApplicationTests {

    @Test
    void contextLoads() {

        System.out.println(SaSecureUtil.md5("zyx18780694397"));
    }

}
