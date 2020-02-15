package com.syslog.manager.SyslogSimulator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.syslog.manager.SyslogSimulator.api.SimulatorSettings;
import com.syslog.manager.SyslogSimulator.api.Syslog;
import com.syslog.manager.SyslogSimulator.service.SyslogService;



@RestController
public class SyslogSimController {
	@Autowired
	private SyslogService service;
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	
	public ResponseEntity<String> startSyslogGeneration(
			@RequestBody SimulatorSettings settings
			) {
		System.out.println("Start Call receieved");
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		headers.add("Access-Control-Max-Age", "1209600");
		service.generateSyslog(settings.getInterval(), settings.getCount());
		return new ResponseEntity<String>("Started",headers, HttpStatus.OK);
	}
	@RequestMapping(value = "/stop", method = RequestMethod.POST)
	public ResponseEntity<String> stopSyslogGeneration() {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		headers.add("Access-Control-Max-Age", "1209600");
		return new ResponseEntity<String>("Stopped",headers, HttpStatus.OK);
	}
	@RequestMapping(value = "/syslog", method = RequestMethod.GET)
	public ResponseEntity<List<Syslog>> getSyslogs(/*
			@RequestParam(value = "unit", defaultValue = "hour") String unit,
			@RequestParam(value = "value", defaultValue = "24") int value,
			@RequestParam(value = "limit", defaultValue = "100") int limit,
			@RequestParam(value = "offset", defaultValue = "0") int offset,
			@RequestParam(value = "sort_by", defaultValue = "+id") String sort_by*/
			//@RequestParam Map<String, String> parameters
			//@QuerydslPredicate(root = Syslog.class) Predicate predicate,
            //Pageable pageable
            ) {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		headers.add("Access-Control-Max-Age", "1209600");
		return new ResponseEntity<List<Syslog>>(service.findSyslogs(),headers, HttpStatus.OK);
	}
}

