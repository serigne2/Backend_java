package com.Filrouge.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.Filrouge.webapp.model.Session;
import com.Filrouge.webapp.service.SessionService;

@RestController
public class SessionController {
	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(method=RequestMethod.GET,value="/sessions")
	public List<Session> getSession() {
	
		return sessionService.getSession();
	}
	@RequestMapping(method=RequestMethod.GET,value="/session/{id}")
	public Session getSession(@PathVariable long id) {
		return  sessionService.getsession(id)	;
     
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/session/{id}")
	public void deleteSession(@PathVariable long id) {
		
		sessionService.deleteSession(id);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/sessions")
	public void addSession(@RequestBody Session session) {
		sessionService.addSession(session);
	}
	@RequestMapping(method= RequestMethod.PUT, value="/session/{id}")
     public void updateSession(@RequestBody Session session, @PathVariable long id) {
    	 sessionService.updateSession(session, id);
     }
	

}