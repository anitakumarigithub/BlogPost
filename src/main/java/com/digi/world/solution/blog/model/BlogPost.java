package com.digi.world.solution.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog_post_details")
public class BlogPost {
	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", slug=" + slug + ", blogCategory=" + blogCategory
				+ ", description=" + description + ", metaTitle=" + metaTitle + ", images=" + images + ", metaKeyword="
				+ metaKeyword + ", metaDescription=" + metaDescription + "]";
	}

	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String title;
	@Column
	private String slug;
	@Column
	private String blogCategory;
	@Column
	private String description;
	@Column
	private String metaTitle;
	@Column
	private String images;
	@Column
	private String metaKeyword;
	@Column
	private String metaDescription;

	// Constructors
	public BlogPost() {
	}

	public BlogPost(Long id, String title, String slug, String blogCategory, String description, String metaTitle,
			String images, String metaKeyword, String metaDescription) {
		this.id = id;
		this.title = title;
		this.slug = slug;
		this.blogCategory = blogCategory;
		this.description = description;
		this.metaTitle = metaTitle;
		this.images = images;
		this.metaKeyword = metaKeyword;
		this.metaDescription = metaDescription;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getBlogCategory() {
		return blogCategory;
	}

	public void setBlogCategory(String blogCategory) {
		this.blogCategory = blogCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
}
