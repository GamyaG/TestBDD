package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poiji.annotation.ExcelCellName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class User {

    @ExcelCellName("Environment")
    @JsonProperty("Environment")
    private String environment;
    @ExcelCellName("User Role")
    @JsonProperty("User Role")
    private String userrole;
    @ExcelCellName("User Id")
    @JsonProperty("User Id")
    private String userId;
    @ExcelCellName("Password")
    @JsonProperty("Password")
    private String password;

    public User() {
    }
    public User(String userrole) {
        this.userrole = userrole;
    }
}
