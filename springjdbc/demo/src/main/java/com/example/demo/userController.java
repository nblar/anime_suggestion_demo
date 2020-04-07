package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jdbc.jdbc;
import com.example.demo.jdbc.reterive;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("send")
public class userController {

	
	
	@GetMapping(produces= { MediaType.APPLICATION_XML_VALUE,  MediaType.APPLICATION_JSON_VALUE })
	public  ResponseEntity<extractData> getuser()
	{
	
	 jdbc obj=new jdbc();
	 extractData d=new extractData();
	 Integer i=new Integer(obj.getdata());
		d.setId(i.toString());
		
		 return new ResponseEntity<extractData>(d,HttpStatus.OK);
	     
	}
	
	 @PostMapping(consumes=
	    	{ MediaType.APPLICATION_XML_VALUE,  MediaType.APPLICATION_JSON_VALUE }, 
	    	produces= { MediaType.APPLICATION_XML_VALUE,  MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<inputData> createUser(@RequestBody recData userDetails)
	{
		 inputData d=new inputData();
		 d.setId(userDetails.getId());
		return new ResponseEntity<inputData>(d, HttpStatus.OK);
	}
	
}
