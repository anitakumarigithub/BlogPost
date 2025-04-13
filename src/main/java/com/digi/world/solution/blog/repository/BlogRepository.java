package com.digi.world.solution.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digi.world.solution.blog.model.BlogPost;
@Repository
public interface BlogRepository extends JpaRepository<BlogPost, Long> {

}
