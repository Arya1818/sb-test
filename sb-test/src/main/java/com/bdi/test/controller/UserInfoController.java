package com.bdi.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bdi.test.model.UserInfo;
import com.bdi.test.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;


@RestController 
@Slf4j
public class UserInfoController {
	@Autowired
	private UserInfoService uis;
	
	@RequestMapping(value="/userinfos", method=RequestMethod.GET)
	public List<UserInfo> getUserInfoList(){
		return uis.findAll();
	}
	@RequestMapping(value="/userinfos/{ui_num}", method=RequestMethod.GET)
	public UserInfo getUserInfo(@PathVariable("ui_num") int ui_num){
		log.info("ui_num=>{}", ui_num);
		UserInfo ui = new UserInfo();
		ui.setUI_NUM(ui_num);
		Example<UserInfo> uiE = Example.of(ui);
		if(!uis.findOne(uiE).isPresent()) {
			return null;
		}
		return uis.findOne(uiE).get();
	}
}
