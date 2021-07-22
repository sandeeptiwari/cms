package in.sandeep.cms.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "news",  schema = "public")
public class News {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String title;

    private String content;

    @ManyToOne
    private User author;

    @OneToMany
    private Set<User> mandatoryReviewers;

    @ElementCollection
    private Set<Review> reviewers;

    @OneToMany
    private Set<Category> categories;

    @ElementCollection
    private Set<Tag> tags;

    public Review review(String userId, String status) {
        final Review review = new Review(userId, status);
        this.reviewers.add(review);
        return review;
    }

    public Boolean revised() {
        return mandatoryReviewers.stream().allMatch(reviewer ->
                reviewers.stream().anyMatch(review ->
                        reviewer.id.equals(review.userId) &&
                                "approved".equals(review.status)
                )
        );
    }
}
