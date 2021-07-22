package in.sandeep.cms.vo;

import in.sandeep.cms.models.Role;
import lombok.Data;

@Data
public class UserRequest {
    String identity;

    String name;

    Role role;
}
