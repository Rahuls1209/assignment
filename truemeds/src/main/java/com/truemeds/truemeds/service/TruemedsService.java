package com.truemeds.truemeds.service;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import com.truemeds.truemeds.models.InputDetail;

@Service
public interface TruemedsService {

	public List<InputDetail> getInputDetails();

	public void processDetails(List<InputDetail> input);

}
