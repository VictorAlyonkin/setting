import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder log = new StringBuilder();

        createDir("C://Games/src", log);
        createDir("C://Games/src/main", log);
        createFile("C://Games/src/main","Main.java", log);
        createFile("C://Games/src/main","Utils.java", log);
        createDir("C://Games/src/test", log);
        createDir("C://Games/res", log);
        createDir("C://Games/res/drawables", log);
        createDir("C://Games/res/vectors", log);
        createDir("C://Games/res/icons", log);
        createDir("C://Games/savegames", log);
        createDir("C://Games/temp", log);
        saveFileLog("C://Games/temp","temp.txt", log);
    }

    public static void createDir(String dir, StringBuilder log){
        File dirSrc = new File(dir);
        if (dirSrc.mkdir())
            log.append("Создан каталог " + dirSrc.getName() + ". Путь " + dir + "\n");
        else
            log.append("Не создан каталог " + dirSrc.getName() + ". Путь " + dir + "\n");
    }

    public static void createFile(String dir, String fileName, StringBuilder log) throws IOException {
        File dirSrc = new File(dir, fileName);
        if (dirSrc.createNewFile())
            log.append("Создан файл " + dirSrc.getName() + " в " + dir + "\n");
        else
            log.append("Не создан файл " + dirSrc.getName() + " в " + dir + "\n");
    }

    public static void saveFileLog (String dir, String fileName, StringBuilder log) throws IOException {
        createFile(dir, fileName, log);
        File fileTemp = new File(dir, fileName);
        try (FileWriter writer = new FileWriter(fileTemp)) {
            writer.write(log.toString());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
