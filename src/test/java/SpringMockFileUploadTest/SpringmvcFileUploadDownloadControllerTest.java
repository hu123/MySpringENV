package SpringMockFileUploadTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.util.Optional;


/**
 * 使用Mock测试的方式来上传文件
 *
 * 如何以Mock的方式来实现文件的上传和下载??????
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/*.xml")
@WebAppConfiguration
public class SpringmvcFileUploadDownloadControllerTest
{
    private static Logger logger = LoggerFactory.getLogger( SpringmvcFileUploadDownloadController.class );
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Autowired
    private RestTemplate restTemplate;
    
    
    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup( webApplicationContext ).build();
    }
    
    
    @Test
    public void fileUploadTest() throws Exception
    {
        /**
         * MockMultipartFile的构造方法的第一个参数是类似于你是用前台表单的name属性  必须和@RequestParam(value = "file", required = false)注解的value属性相同。
         * 否则拿到的MultipartFile对象则为空
         */
        MockMultipartFile mockMultipartFile = new MockMultipartFile( "file","myFile.doc" , "file",new FileInputStream( "E:/commons-fileupload-1.3.jar" ) );
        MockMultipartHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.fileUpload( "/fileUpload","file" ).file( mockMultipartFile );
        mockMvc.perform( mockHttpServletRequestBuilder );

        
        
    }
    
    @Test
    public void fileDownloadTest() throws Exception
    {
        ResponseEntity responseEntity = restTemplate.getForEntity( "http://localhost:8080/responseEntityTest", ResponseEntity.class );
    
        logger.warn( "RESTTemplate拿到的ResponseEntity" + responseEntity );
    }
}