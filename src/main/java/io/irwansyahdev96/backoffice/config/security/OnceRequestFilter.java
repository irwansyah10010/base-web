package io.irwansyahdev96.backoffice.config.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.irwansyahdev96.backoffice.base.constant.SecurityUrl;



@Component
public class OnceRequestFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
        String uri = request.getRequestURI();
        String refererHeader = request.getHeader("Referer");
        
        // check if url isnt referal header
        // Boolean isValidUrl = isValidUrl(uri, refererHeader);

        filterChain.doFilter(request, response);
    }

    /**
     * 
     * @param uri
     * @param referal
     * @throws IOException
     */
    private Boolean isValidUrl(String uri, String referal) throws IOException{
        List<String> onceReqUrls = Arrays.asList(SecurityUrl.ONCE_REQUEST_URL);
        onceReqUrls.replaceAll(s -> s.replace("*", ""));
        onceReqUrls.replaceAll(s -> s.replace("/", ""));

        // check url available on onceReqUrls
        long countOfAvailable = onceReqUrls.stream().filter(t -> uri.contains(t)).count();
        
        // if referal header not null and url available
        if(Optional.ofNullable(referal).isPresent() 
            && countOfAvailable > 0){

            return true;
        }

        return false;
    }
}
