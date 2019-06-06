package com.tts.PotluckAdventures.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class BlogPostController {
	
	@Autowired
	private BlogPostRepository blogPostRepository;

	@GetMapping("/")
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", blogPostRepository.findAll());
		return "blogpost/index";
	}
	
	@GetMapping("/blogpost/new")
	public String newBlog(BlogPost blogPost) {
		return "blogpost/new";
	}
	
	@PostMapping("/blogpost/new")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		blogPostRepository.save(blogPost);
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("body", blogPost.getBody());
		return "blogpost/result";
	}
	
	@DeleteMapping("/blogpost/{id}")
    public String deletePostWithId(@PathVariable long id, BlogPost blogPost) {
        blogPostRepository.deleteById(id);
        return "blogpost/index";

    }
	
	@GetMapping("/blogpost/{id}")
	public String showSinglePostById(@PathVariable long id, Model model) {
		BlogPost blog = blogPostRepository.findById(id).orElse(null);
		model.addAttribute("posts", blog);
		return "blogpost/show";
	}
	
	@GetMapping("/blogpost/edit/{id}")
	public String getpostToEdit(@PathVariable long id, Model model) {
		BlogPost blog = blogPostRepository.findById(id).orElse(null);
		model.addAttribute("posts", blog);
		return "blogpost/edit";
	}
	
	@PutMapping("/blogpost/{id}")
	public String updatePost(@PathVariable long id, BlogPost blogPost, Model model)  {
		
		BlogPost storedPost = blogPostRepository.findById(id).orElse(null);
		storedPost.setAuthor(blogPost.getAuthor());
		storedPost.setTitle(blogPost.getTitle());
		storedPost.setBody(blogPost.getBody());
		blogPostRepository.save(storedPost);
		model.addAttribute("title", storedPost.getTitle());
		model.addAttribute("author", storedPost.getAuthor());
		model.addAttribute("body", storedPost.getBody());
		
		return "blogPost/result";
	}
}

