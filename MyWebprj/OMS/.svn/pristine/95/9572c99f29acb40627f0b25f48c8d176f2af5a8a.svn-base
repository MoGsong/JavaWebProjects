package com.gxnu.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class UTF8Filter implements Filter{

    
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest)arg0; 
        HttpServletResponse resp = (HttpServletResponse)arg1;

        req.setCharacterEncoding("UTF-8");
       
        
        CharacterRequest characterRequest = new CharacterRequest(req);
        
        arg2.doFilter(characterRequest,resp);
    }
}

class CharacterRequest extends HttpServletRequestWrapper{
    private HttpServletRequest request;

    public CharacterRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if(value == null){
            return null;
        }else{
            String method = request.getMethod();
            if("get".equalsIgnoreCase(method)){
                try{
                    value = new String(value.getBytes("iso-8859-1"),"UTF-8") ;
                }catch(UnsupportedEncodingException e){
                    throw new RuntimeException(e);
                }
            }
        }
        return value;
    }
}
