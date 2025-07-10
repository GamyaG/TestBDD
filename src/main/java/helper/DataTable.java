package helper;

import java.util.ArrayList;
import java.util.List;

public class DataTable {
    private List<String[]> data = new ArrayList<>();

    public void addRow(String[] row) {
        data.add(row);
    }

    public List<String[]> getData() {
        return data;
    }
}
