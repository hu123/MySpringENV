package servlet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
@WebAppConfiguration
public class MySpringServletTest
{
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private MockMvc mockMvc ;
    
    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup( webApplicationContext ).build();
    }
    
    /**
     * 不知道为什么明明就已经将Servlet交给Spring容器管理了,可以用浏览器可以访问到url地址,用Mock测试就不行呢????
     * @throws Exception
     */
    @Test
    public void name() throws Exception
    {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get( "/sayHello" );
    
        ResultActions resultActions = mockMvc.perform( mockHttpServletRequestBuilder );
        resultActions.andExpect( status().isOk() );
    }
}