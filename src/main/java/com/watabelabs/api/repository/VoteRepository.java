package com.watabelabs.api.repository;

import com.watabelabs.api.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** VoteRepository */
@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
