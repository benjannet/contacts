package org.sid.web;
import org.sid.dao.ContactRepository;
import java.util.List;
import java.util.Optional;

import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.domain.AbstractPageRequest;


@RestController 
@CrossOrigin("*")
public class ContactRestService {
	@Autowired 
	private ContactRepository contactRepository ;
	
	//  liste des contacts 
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List <Contact> getcontacts(){
		return contactRepository.findAll();
		
	}
	
	
	
	
	
	
	
	
	
	
	// chercher un contact par son id 
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Optional<Contact>  getcontacts(@PathVariable Long id ){
		return contactRepository.findById (id);
		
	}
	
	

	@RequestMapping(value="/chercherContacts",method=RequestMethod.GET)
	public Page<Contact> chercher(
		
	@RequestParam(name="mc",defaultValue="") String mc,
	@RequestParam(name="page",defaultValue="0") int page,
	@RequestParam(name="size",defaultValue="5") int size)
	{
		
		return contactRepository.chercher(mc,new PageRequest(page,size,Sort.by(mc) ) {
			
		
		} 
		
				);
			
		
		
		
				
		
    }
	
	
	
	//Ajouter du contact 
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contact  save(@RequestBody Contact c){
		return contactRepository.save(c);
		
	}
	
	
	//supression de contact 
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id ){
		contactRepository.deleteById(id);
		return  true;
		
	}
	
	

	//Mise à jour  du contact 
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact  save(@PathVariable Long id,@RequestBody Contact c){
		c.setId(id); 
		return contactRepository.save(c);
		
	}
	
	


	
	
	
	
	
	


	
	

}
