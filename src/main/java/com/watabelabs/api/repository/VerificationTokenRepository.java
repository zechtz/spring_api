package com.watabelabs.api.repository;

import com.watabelabs.api.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** VerificationTokenRepository */
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
