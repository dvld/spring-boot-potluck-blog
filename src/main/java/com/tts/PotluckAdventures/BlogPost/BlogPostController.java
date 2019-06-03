package com.tts.PotluckAdventures.BlogPost;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class BlogPostController {
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	private static List<BlogPost> posts = new ArrayList<>();

	@GetMapping("/")
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", posts);
		return "blogpost/index";
	}
	
	private BlogPost blogPost;
	
	@GetMapping("/blogpost/new")
	public String newBlog(BlogPost blogPost) {
		return "blogpost/new";
	}
	
	@PostMapping("/blogpost/new")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		blogPostRepository.save(blogPost);
		posts.add(blogPost);
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("body", blogPost.getBody());
		return "blogpost/result";
	}
	
	@DeleteMapping("/blogpost/{id}")
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
        blogPostRepository.deleteById(id);
        posts.removeIf(posts -> posts.getId().equals(id));
        return "blogpost/index";

    }
	
}

