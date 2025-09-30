package com.cognizant.boot.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties
//@PropertySource("classPath:dbConfig.properties")
//@PropertySource(value ="classPath:dbConfig.properties")

@ConfigurationProperties(prefix = "jdbc")
public class DBConnection {

	private String driverClassName;
	private String url;
	private String usrname;
	private String password;
	
	
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "DBConnection [driverClassName=" + driverClassName + ", url=" + url + ", usrname=" + usrname
				+ ", password=" + password + "]";
	}
	
	
}
