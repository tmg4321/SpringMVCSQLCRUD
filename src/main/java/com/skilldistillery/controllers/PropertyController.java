package com.skilldistillery.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.data.Property;
import com.skilldistillery.data.PropertyDao;

@Controller
public class PropertyController {
	@Autowired
	PropertyDao dao;

	@RequestMapping(path = "listProperties.do", method = RequestMethod.GET)
	public ModelAndView getPropertyList() {
		ModelAndView mv = new ModelAndView("/WEB-INF/views/listOfProperties.jsp");
		List<Property> props = dao.getAllProperties();
		mv.addObject("properties", props);
		return mv;
	}

	@RequestMapping(path = "add.do", method = RequestMethod.GET)
	public ModelAndView goToAddView() {
		ModelAndView mv = new ModelAndView("/WEB-INF/views/addProperty.jsp");
		return mv;
	}

	@RequestMapping(path = "addProperty.do", method = RequestMethod.POST)
	public String addProperty(Property newProp) {

		try {
			dao.addProperty(newProp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect: listProperties.do";
	}

	@RequestMapping(path = "viewProperty.do", method = RequestMethod.GET)
	public ModelAndView viewProperty(String address) {

		ModelAndView mv = new ModelAndView("/WEB-INF/views/viewProperty.jsp");
		mv.addObject("property", dao.getPropertyByAddress(address));
		return mv;
	}

	@RequestMapping(path = "removeProp.do", method = RequestMethod.POST)
	public String removeProperty(String address) {
		System.out.println(dao.getPropertyByAddress(address));
		 try {
		 dao.removeProperty(address);
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		return "redirect: listProperties.do";
	}

}