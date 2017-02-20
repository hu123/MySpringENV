package SpringMockFileUploadTest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


/**
 * 使用Mock测试实现文件上传的功能.....
 * 顺便练习一下SpringMVC上传文件的API
 */
@Controller
public class SpringmvcFileUploadDownloadController
{
    private static Logger logger = LoggerFactory.getLogger( SpringmvcFileUploadDownloadController.class );
    
    /**
     * 文件上传
     */
    @RequestMapping("/fileUpload")
    public String fileUploadMethod(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) throws IOException
    {
        logger.warn( "上传文件" );
        
        String string = file.getOriginalFilename();
        
        byte[] bytes = string.getBytes( "iso-8859-1" );
        
        String value = new String( bytes, "utf-8" );
        logger.warn( "文件名是" + value );
        
        File targetFile = new File( "E:/SpringMVCFileUpload/" + value );
        
        //        if(!targetFile.exists())
        //        {
        //            targetFile.mkdirs();
        //        }
        file.transferTo( targetFile );
        
        
        return "fileUploadResult";
    }
    
    
    /**
     * 使用SpringMVC下载文件......
     */
    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String path = "E:/commons-fileupload-1.3.jar";
        File file = new File( path );
        HttpHeaders httpHeaders = new HttpHeaders();
        String fileName = new String( "downloadedFile.jar".getBytes( "utf-8" ), "iso-8859-1" );
        httpHeaders.setContentDispositionFormData( "attachment", fileName );
        httpHeaders.setContentType( MediaType.APPLICATION_OCTET_STREAM );
        return new ResponseEntity<byte[]>( FileUtils.readFileToByteArray( file ), httpHeaders, HttpStatus.CREATED );
    }
    
    
    @RequestMapping("/responseEntityTest")
    public ResponseEntity<String> responseEntityTest()
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set( "User-Agent", "Mozilla/5.0" );
        
        return new ResponseEntity( "helloworld", httpHeaders, HttpStatus.OK );
    }
    
}
