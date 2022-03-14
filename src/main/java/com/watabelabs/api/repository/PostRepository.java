package com.watabelabs.api.repository;

import com.watabelabs.api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** PostRepository */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
