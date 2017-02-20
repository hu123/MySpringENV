package springdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * 利用MockMvc进行测试.......
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application.xml", "classpath:spring/spring-mvc.xml" })
@WebAppConfiguration
public class SpringMockMvcTestTest
{
    
    @Autowired
    private WebApplicationContext webApplicationContext ;
    
    private MockMvc mockMvc ;
    
    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup( webApplicationContext ).build();
    }
    
    @Test
    public void name() throws Exception
    {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get( "/sayHello" );
    
        mockHttpServletRequestBuilder.param( "username", "tom" ).param( "password", "jessica" );
        ResultActions resultActions = mockMvc.perform( mockHttpServletRequestBuilder );
        resultActions.andExpect( status().isOk() );
    }
}