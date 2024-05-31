package com.demo.bloagapp.blogapp.articles;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.bloagapp.blogapp.articles.dtos.CreateArticleRequest;
import com.demo.bloagapp.blogapp.articles.dtos.UpdateArticleRequest;
import com.demo.bloagapp.blogapp.users.UserService;
import com.demo.bloagapp.blogapp.users.UsersRepository;

@Service
public class ArticleService {

	private final ArticleRepository articleRepository;
	private final UsersRepository userRepository;

	public ArticleService(ArticleRepository articleRepository, UsersRepository userRepository) {
		this.articleRepository = articleRepository;
		this.userRepository = userRepository;

	}

	public Iterable<ArticleEntity> getAllArticles(ArticleEntity article) {
		return articleRepository.findAll();

	}

	public ArticleEntity getArticleBySlug(String slug) {
		var article = articleRepository.findBySlug(slug);
		if (article == null) {
			throw new ArticleNotFoundException(slug);
		}
		return article;
	}

	public Optional<ArticleEntity> getArticleById(Long id) {
		var article = articleRepository.findById(id);
		if (article == null) {
			throw new ArticleNotFoundException(id.toString());
		}
		return article;
	}

	public ArticleEntity createArticle(CreateArticleRequest article, Long authorId) {

		var user = userRepository.findById(authorId).orElseThrow(() -> new UserService.UserNotFoundException(authorId));

		return articleRepository.save(ArticleEntity.builder().title(article.getTitle())
				.slug(article.getTitle().toLowerCase().replaceAll("\\s+", "-")).subtitle(article.getSubtitle())
				.body(article.getBody()).author(user).build());
	}

	public ArticleEntity updateArticle(Long id, UpdateArticleRequest article) {

		ArticleEntity existingArticle = getArticleById(id)
				.orElseThrow(() -> new ArticleNotFoundException(id.toString()));

		if (article.getTitle() != null) {
			existingArticle.setTitle(article.getTitle());
			existingArticle.setSlug(article.getTitle().toLowerCase().replaceAll("\\s+", "-"));
		}

		if (article.getSubtitle() != null)
			existingArticle.setSubtitle(article.getSubtitle());

		if (article.getBody() != null)
			existingArticle.setBody(article.getBody());

		return articleRepository.save(existingArticle);
	}

	public static class ArticleNotFoundException extends IllegalArgumentException {
		public ArticleNotFoundException(String slug) {
			super("Article with " + slug + " not found");
		}

	}

}
