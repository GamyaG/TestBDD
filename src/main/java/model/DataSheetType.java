package model;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum DataSheetType {
     USERS("Users");
     String sheetName;
}
