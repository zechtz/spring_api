package com.watabelabs.api.repository;

import com.watabelabs.api.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** SubredditRepository */
@Repository
public interface SubredditRepository extends JpaRepository<Subreddit, Long> {
}
