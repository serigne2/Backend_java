package com.Filrouge.webapp.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Filrouge.webapp.model.Session;
import com.Filrouge.webapp.repository.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	//Afaire attention après car c'est pas forcément static je l'ai fait p ca march
    public List<Session> getSession(){
    	List<Session> sessions = new ArrayList<>();
    	sessionRepository.findAll().forEach(session -> {
    		sessions.add(session);
    	});
    	
    	return sessions;
    	
    	
    	
    }
    public Session getsession(long id) {
        // TODO Auto-generated method stub
        return sessionRepository.findById(id).orElse(null);
    }
    public  void deleteSession(long id) {
    	//attention à static
    	sessionRepository.deleteById(id);
	}
    public void addSession(Session session) {
    	sessionRepository.save(session);
	}
	public void updateSession (Session session, long id) {
		sessionRepository.save(session);
	}
}

