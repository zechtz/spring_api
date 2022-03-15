package com.watabelabs.api.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tokens")
public class VerificationToken {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  private String token;

  @OneToOne(fetch = LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  private Instant expiryDate;
}
