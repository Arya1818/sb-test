package com.bdi.test.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.bdi.test.model.UserInfo;

@Service
public interface UserInfoService extends JpaRepository<UserInfo,Long>{

}
