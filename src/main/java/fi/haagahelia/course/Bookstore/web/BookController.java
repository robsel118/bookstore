package fi.haagahelia.course.Bookstore.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class BookController {
	
	@RequestMapping("/index")
	public String greeting() {
        return "Welcome to theindex page";
    }
}
