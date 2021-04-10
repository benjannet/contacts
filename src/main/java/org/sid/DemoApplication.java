package org.sid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;
  
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
@Override
public void run(String...arg0) throws Exception {
	DateFormat df =new SimpleDateFormat("dd/MM/yyyy");
	contactRepository.save(new Contact("Ben jannet","Abdelkader",df.parse("05/12/1986"),"benjnnn@gmail.com",055555,"dgfbf"));
	contactRepository.save(new Contact("sassi","Mohamed",df.parse("10/06/1992"),"gyly@gmail.com",77882,"dgfbf"));
	contactRepository.save(new Contact("ben salem","farouk",df.parse("05/07/1997"),"kylpl@gmail.com",055555,"dgfbf"));
	contactRepository.findAll().forEach(c->{
		System.out.println(c.getNom());
		
});
	
	// TODO AutcontactRepositoryo-generated method stub
	
}

}
