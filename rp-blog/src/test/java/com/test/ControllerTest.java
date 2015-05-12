package com.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;

@Controller
public class ControllerTest {

	/**
	 * 返回json value
	 * @return
	 */
	@RequestMapping(value={"test1/id","test2/id"},produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView returnMAV(){
		ModelAndView mav=new ModelAndView();
		
		return mav;
	}
	
	@RequestMapping(value={"test1/id","test2/id"},produces=MediaType.APPLICATION_JSON_VALUE)
	public String returnMAV(Model model,HttpServletRequest request,HttpServletResponse response){
		model.addAttribute("requestKey", "requestValue");
		return "viewname";
	}
	
	public ResponseEntity<Map<String,Object>> returnEntity(){
		Map<String,Object> res=Maps.newHashMap();
		res.put("", "");
		ResponseEntity<Map<String,Object>> entity=new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		return null;
	}
	
	
	
}
