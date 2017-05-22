package com.skilldistillery.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.data.Property;
import com.skilldistillery.data.PropertyDao;

@Controller
public class PropertyController {
	@Autowired
	PropertyDao dao;

	@RequestMapping(path="listProperties.do", method=RequestMethod.GET)
	public ModelAndView getPropertyList() {
		ModelAndView mv = new ModelAndView("/WEB-INF/listOfProperties.jsp");
		List<Property> props = dao.getAllProperties();
		mv.addObject("properties", props);
		return mv;
	}

	@RequestMapping(path="add.do", method=RequestMethod.GET)
	public ModelAndView goToAddView() {
		ModelAndView mv = new ModelAndView("/WEB-INF/addProperty.jsp");
		return mv;
	}

	@RequestMapping(path="addProp.do", method=RequestMethod.POST)
	public String addProperty(@RequestParam String address, @RequestParam Double rent,
			@RequestParam Double purchasePrice) {
		Property newProp = new Property(address, rent, purchasePrice);
		try {
			dao.addProperty(newProp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect: listProperties.do";
	}

	@RequestMapping(path="viewProperty.do", method=RequestMethod.GET)
	public ModelAndView viewProperty(String address) {

		ModelAndView mv = new ModelAndView("/WEB-INF/viewProperty.jsp");
		mv.addObject("property", dao.getPropertyByAddress(address));
		return mv;
	}

	@RequestMapping(path="removeProp.do", method=RequestMethod.POST)
	public String removeProperty(String address) {
		 
		try {
			dao.removeProperty(address);
		} catch (IOException e) {
		 e.printStackTrace();
		}
		return "redirect: listProperties.do";
	}
	
	@RequestMapping(path="edit.do", method=RequestMethod.GET)
	public ModelAndView goToEditView(String address) {
		ModelAndView mv = new ModelAndView("/WEB-INF/editProperty.jsp");
		mv.addObject("property", dao.getPropertyByAddress(address));
		mv.addObject("addressBeforeEdit", address);
		return mv;
	}
	
	@RequestMapping(path="editProperty.do", method=RequestMethod.POST)
	public String editProperty(String addressBeforeEdit, String address, 
			Double rent, Double purchasePrice, Double capRate, Model m) {
	
		dao.editProperty(addressBeforeEdit, address, rent, 
				purchasePrice, capRate);
		m.addAttribute("properties", dao.getAllProperties());
		return "redirect: listProperties.do";
	}

}
