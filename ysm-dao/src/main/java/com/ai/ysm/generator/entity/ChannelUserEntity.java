package com.ai.ysm.generator.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author asiainfo
 *  
 * @date 2018-01-03 15:37:17
 */
public class ChannelUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String name;
	//
	private String phonenum;
	//
	private String address;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	/**
	 * 获取：
	 */
	public String getPhonenum() {
		return phonenum;
	}
	/**
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
}
