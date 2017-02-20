package springmvcpackage;

import SpringBean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MyController
{
    
    @RequestMapping(value = "/sayHello")
    public String sayHello(HttpServletRequest httpServletRequest)
    {
        String username = httpServletRequest.getParameter( "username" );
        String password = httpServletRequest.getParameter( "password" );
        System.out.println( "用户名是:" + username + "密码是:" + password );
        
        return "index";
    }
    
    
//    @RequestMapping(value = "/")
//    public String formInputValidation()
//    {
//        return "form";
//    }
    
    @RequestMapping(value = "/checkFormInput")
    public String checkInputValidation(@Valid Person person, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "form";
        }
        
        
        return "results";
    }
    
}
