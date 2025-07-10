package utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.testng.annotations.Test;

@NoArgsConstructor
@Getter
@Setter
@Test
public
class Saves {
    public int id;

    public int runID;

    public String projectName;

    public String environment;

    public String featureName;

    public String sceenarioName;

    public String executedDateTime;

    public String result;

    public String machineName;

    public String executedBy;

    public String executionType;

    public String tags;

    public String failureReason;

    public String category;

    public String sprintName;

    public String duration;
    public String releaseLink;
}
