package com.truemeds.truemeds.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truemeds.truemeds.Repository.InputDetailsRepository;
import com.truemeds.truemeds.models.InputDetail;
import com.truemeds.truemeds.service.TruemedsService;


@RestController
@RequestMapping("/api")
public class TruemedsController {

	@Autowired
	TruemedsService truemedService;

	private static final Logger log = LogManager.getLogger(TruemedsController.class);


	@GetMapping("/truemed")
	public ResponseEntity<String> processDetails() {
		log.info("Controller: createTutorial");

	//	try {

			List<InputDetail> input=new ArrayList<InputDetail>();
			input=truemedService.getInputDetails();

			truemedService.processDetails(input);


			return  ResponseEntity.ok("success");// new ResponseEntity<>(null,HttpStatus.OK);
	//	} catch (Exception e) {
		//	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		//}
	}




}
