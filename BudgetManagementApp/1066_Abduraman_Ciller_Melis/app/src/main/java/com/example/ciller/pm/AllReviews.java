package com.example.ciller.pm;

/**
 * Created by Ciller on 1/14/2018.
 */

public class AllReviews {
    String reviewId;
    String reviewEmail;
    int reviewExperience;
    int reviewImpact;
    String reviewRecom;
  //  int reviewHour;
    String reviewFeedback;

    public AllReviews(String reviewId, String reviewEmail, int reviewExperience, int reviewImpact, String reviewRecom, String reviewFeedback) {
        this.reviewId = reviewId;
        this.reviewEmail = reviewEmail;
        this.reviewExperience = reviewExperience;
        this.reviewImpact = reviewImpact;
        this.reviewRecom = reviewRecom;
      //  this.reviewHour = reviewHour;
        this.reviewFeedback = reviewFeedback;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewEmail() {
        return reviewEmail;
    }

    public void setReviewEmail(String reviewEmail) {
        this.reviewEmail = reviewEmail;
    }

    public int getReviewExperience() {
        return reviewExperience;
    }

    public void setReviewExperience(int reviewExperience) {
        this.reviewExperience = reviewExperience;
    }

    public int getReviewImpact() {
        return reviewImpact;
    }

    public void setReviewImpact(int reviewImpact) {
        this.reviewImpact = reviewImpact;
    }

    public String getReviewRecom() {
        return reviewRecom;
    }

    public void setReviewRecom(String reviewRecom) {
        this.reviewRecom = reviewRecom;
    }

    public String getReviewFeedback() {
        return reviewFeedback;
    }

    public void setReviewFeedback(String reviewFeedback) {
        this.reviewFeedback = reviewFeedback;
    }
}


