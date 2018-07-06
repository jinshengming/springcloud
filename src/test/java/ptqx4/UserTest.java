package ptqx4;

import com.alibaba.fastjson.JSON;
import net.htjs.pt4.AppStart;
import net.htjs.pt4.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppStart.class})
public class UserTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

//    @Autowired
//    private RedisTemplate redisTemplate;

    @Before
    public void setUp(){
        // 初始化
        this.mvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void login() throws Exception{
        String url = "/user/login";
        User user = new User();
        user.setUserName("jsm0410@163.com");
        user.setUserPwd("13ley0.0");
        String json = JSON.toJSONString(user);
        invoke(url, json);
    }

    @Test
    public void insertTest() throws Exception{
        String url = "/user/insert";
        User user = new User();
        user.setUserId(6234);
        user.setUserName("user1");
        user.setUserPwd("user1");
        String json = JSON.toJSONString(user);
        invoke(url, json);
    }

    @Test
    public void redisTest(){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("name", "11100");
//        valueOperations.set("age", "15");
//        valueOperations.set("address", "上海");
    }

    public void invoke(String url, String json) throws Exception {
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
