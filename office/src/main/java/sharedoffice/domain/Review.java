package sharedoffice.domain;

import sharedoffice.domain.ReviewCreated;
import sharedoffice.domain.ReviewModified;
import sharedoffice.domain.ReviewDeleted;
import sharedoffice.OfficeApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Review_table")
@Data

public class Review  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long reviewId;
    
    
    
    
    
    private String officeId;
    
    
    
    
    
    private String content;

    @PostPersist
    public void onPostPersist(){


        ReviewCreated reviewCreated = new ReviewCreated(this);
        reviewCreated.publishAfterCommit();



        ReviewModified reviewModified = new ReviewModified(this);
        reviewModified.publishAfterCommit();



        ReviewDeleted reviewDeleted = new ReviewDeleted(this);
        reviewDeleted.publishAfterCommit();

    }

    public static ReviewRepository repository(){
        ReviewRepository reviewRepository = OfficeApplication.applicationContext.getBean(ReviewRepository.class);
        return reviewRepository;
    }






}
