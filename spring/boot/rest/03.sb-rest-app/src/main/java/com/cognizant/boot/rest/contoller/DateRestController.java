package com.cognizant.boot.rest.contoller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateRestController {
	@GetMapping("/date")
      public ResponseEntity<String> sendTodayDateAndTime(){
    	  LocalDateTime date=LocalDateTime.now();
    	  DateTimeFormatter dtFormatter=DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
    	  String responseText=dtFormatter.format(date);
    	 
    	  
    	  //ResponseEntity<String> responseEntity=new ResponseEntity<>(HttpStatus.OK);
    	  //ResponseEntity<String> responseEntity=new ResponseEntity<>(responseText,HttpStatus.OK);
    	  //ResponseEntity<String> responseEntity=new ResponseEntity<>(responseText,HttpStatus.CREATED);
    	  //ResponseEntity<String> responseEntity=new ResponseEntity<>(responseText,HttpStatus.BAD_REQUEST);
    	  
    	  //----------------------to include response header--------------------
    	  HttpHeaders responseHeader = new HttpHeaders();
    	  responseHeader.add("company", "cognizant");
    	  responseHeader.add("region", "india");
    	  
    	//ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, responseHeaders, HttpStatus.OK);
  		//return responseEntity;
  		ResponseEntity<String> responseEntity = ResponseEntity.ok(responseText);
  		//return responseEntity;
  		//return ResponseEntity.ok(responseText);
  		//return ResponseEntity.ok().body(dateTime);
  		return ResponseEntity.badRequest().body(responseText);
    	  
    	 // ResponseEntity<String> responseEntity = new ResponseEntity<>(responseText,responseHeader,HttpStatus.OK);
    	 // return responseEntity;
      }
}
