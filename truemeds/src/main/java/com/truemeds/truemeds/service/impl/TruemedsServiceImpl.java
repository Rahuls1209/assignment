package com.truemeds.truemeds.service.impl;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truemeds.truemeds.Repository.InputDetailsRepository;
import com.truemeds.truemeds.Repository.OutputDetailsRepository;
import com.truemeds.truemeds.controller.TruemedsController;
import com.truemeds.truemeds.models.InputDetail;
import com.truemeds.truemeds.models.OutputDetail;
import com.truemeds.truemeds.service.TruemedsService;

@Service
public class TruemedsServiceImpl implements TruemedsService {

	

	@Autowired
	InputDetailsRepository inputDetailsRepository;
	
	@Autowired
	OutputDetailsRepository outputDetailsRepository;
	
	private static final Logger log = LogManager.getLogger(TruemedsServiceImpl.class);

	@Override
	public List<InputDetail> getInputDetails() {

		List<InputDetail> input = inputDetailsRepository.findAll();

		return input;
	}

	@Override
	public void processDetails(List<InputDetail> input) {
		

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		List<OutputDetail> output = new ArrayList<OutputDetail>();

		for (int t = 0; t < input.size(); t++) {

			String s = input.get(t).getInput();

			StringBuilder sb = new StringBuilder(s);
	        int i = 0;
	        int j = 1;
	        int count = 0;
	        
	        while(j < s.length()-1) {
	                if(s.charAt(i) == s.charAt(j)) {
	                        j++;
	                        if(s.charAt(i) == s.charAt(j)) {
	                                continue;
	                        }
	                        else {
	                                sb.replace(i, j, "");
	                                count++; 
	                                s = sb.toString();
	                                i=0;
	                                j=1;
	                        }
	                }
	                else {
	                        i++;
	                        j++;
	                }
	        }

			output.add(new OutputDetail(count,dtf.format(now),"Rahul Singh",sb.toString()));
		}
		

		outputDetailsRepository.saveAll(output);
		System.out.println(output);
		
		

	}
	
	

}
