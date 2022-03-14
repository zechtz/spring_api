package com.watabelabs.api.model;

import com.watabelabs.api.exceptions.SpringApiException;
import java.util.Arrays;

/** VoteType */
public enum VoteType {
  UPVOTE(1), DOWNVOTE(-1),;

  private int direction;

  VoteType(int direction) {}

  public static VoteType lookup(Integer direction) {
    return Arrays.stream(VoteType.values()).filter(value -> value.getDirection().equals(direction))
        .findAny().orElseThrow(() -> new SpringApiException("Vote Not Found"));
  }

  public Integer getDirection() {
    return direction;
  }
}
