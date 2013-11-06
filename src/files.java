
import java.io.File;

public class files {

    static int active = 0;
    private static File table;
    private static File info;

    public files() {
    }

    public files(File table) {
        files.table = table;

    }

    public static File getTable() {
        return table;
    }

    public static void setTable(File table) {
        files.table = table;
    }

    public static File getInfo() {
        return info;
    }

    public static void setInfo(File aInfo) {
        info = aInfo;
    }
}
