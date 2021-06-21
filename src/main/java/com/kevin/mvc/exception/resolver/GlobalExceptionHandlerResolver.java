package com.kevin.mvc.exception.resolver;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GlobalExceptionHandlerResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		
		switch(response.getStatus()) {
		
			case 400  :
				mv.setViewName("error/400");
				break;
			case 404 :
				mv.setViewName("error/404");
				break;		
			case 500 :
				mv.addObject("exception", ex);
				mv.setViewName("error/error");
				break;
			default:
				mv.addObject("exception", ex);
				mv.setViewName("error/global_error");
		}
		
		/*if (response.getStatus()== response.SC_BAD_REQUEST){
			mv.setViewName("error/400");
		}
		else if (response.getStatus()== response.SC_NOT_FOUND) {
			mv.setViewName("error/404");
		}
		else if (response.getStatus() == response.SC_INTERNAL_SERVER_ERROR) {
			mv.addObject("exception", ex);
			mv.setViewName("error/error");
		}
		else {
		mv.addObject("exception", ex);
		mv.setViewName("error/global_error");
		
		}*/
		
		return mv;
	}

}
