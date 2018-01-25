package fi.haagahelia.course.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.Category;
import fi.haagahelia.course.Bookstore.domain.repository.BookRepository;
import fi.haagahelia.course.Bookstore.domain.repository.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository cRepo;

	@RequestMapping("/index")
	public String greeting(Model model) {
		List<Book> books = (List<Book>) repository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
	  @RequestMapping(value = "/")
	  public String root() {
	    return "redirect:index";
	}
	@RequestMapping("/login")
	public String loginPage() {
		
		return "login";
	}

	@RequestMapping("/add")
	public String addBook(Model model) {
		List<Category>categories=(List<Category>) cRepo.findAll();
		model.addAttribute("book", new Book());
		model.addAttribute("categories",categories);
			
		return "addBook";
	}

	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		Book book = (Book) repository.findOne(bookId);
		List<Category>categories=(List<Category>) cRepo.findAll();
		model.addAttribute("categories",categories);
		model.addAttribute("book", book);
		return "addBook";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.delete(bookId);
		return "redirect:../index";
	}
	
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public String save(@ModelAttribute Book book) {
	    repository.save(book);
	    return "redirect:index";
	}
	 @RequestMapping(value = "/logout", method = RequestMethod.POST)
	  public String logout() {
	   
	    return "redirect:index";
	}
}
