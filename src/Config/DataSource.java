package Config;

import java.io.File;

public class DataSource {
    private final File dataSource;

    public DataSource(String path) {
        this.dataSource = new File(path);
    }

    public File getDataSource() {
        return dataSource;
    }
}
