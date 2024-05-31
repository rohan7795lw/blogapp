package com.demo.bloagapp.blogapp.comments;

import org.springframework.stereotype.Service;

@Service
public class CommentService {

	private final CommentsRepository commentRepository;

	public CommentService(CommentsRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

}
