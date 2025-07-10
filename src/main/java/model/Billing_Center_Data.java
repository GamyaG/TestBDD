package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poiji.annotation.ExcelCellName;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties

public class Billing_Center_Data {
    @ExcelCellName("Name")
    @JsonProperty("Name")
    private String Name;

}
