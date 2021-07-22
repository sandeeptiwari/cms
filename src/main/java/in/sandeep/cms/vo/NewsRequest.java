package in.sandeep.cms.vo;

import in.sandeep.cms.models.Category;
import in.sandeep.cms.models.Tag;
import lombok.Data;

import java.util.Set;

@Data
public class NewsRequest {

    String title;

    String content;

    Set<Category> categories;

    Set<Tag> tags;

}
