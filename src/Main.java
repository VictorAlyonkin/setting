import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder log = new StringBuilder();

        File dirSrc = new File("C://Games/src");
        if (dirSrc.mkdir()) {
            log.append("Создан каталог src\n");

            File dirMain = new File("C://Games/src/main");
            if (dirMain.mkdir()) {
                log.append("Создан каталог main\n");

                File fileMain = new File("C://Games/src/main", "Main.java");
                if (fileMain.createNewFile())
                    log.append("Создан файл Main.java в каталоге C://Games/src/main\n");

                File fileUtils = new File("C://Games/src/main", "Utils.java");
                if (fileUtils.createNewFile())
                    log.append("Создан файл Utils.java в каталоге C://Games/src/main\n");
            }

            File dirTest = new File("C://Games/src/test");
            if (dirTest.mkdir())
                log.append("Создан каталог test\n");
        } else {
            //но мы сюда никогда не попадем, так как если файл уже существует, то будет NullPointerException
            //можно добавлять перед if условие на dirSrc.exists(), если не существует, то записать не создан файл
            //по-хорошему, везде такое прописать нужно, но много кода будет лишнего
            //как вариант - может через exists проверять существование файла, если есть - удалять
            //или обернуть в try catch и в catch не выводить ошибку и записывать в лог неуспех
            log.append("Не создан файл temp в каталоге C://Games/temp\n");
        }

        File dirRes = new File("C://Games/res");
        if (dirRes.mkdir()) {
            log.append("Создан каталог src\n");

            File dirDrawables = new File("C://Games/res/drawables");
            if (dirDrawables.mkdir())
                log.append("Создан каталог drawables\n");

            File dirVectors = new File("C://Games/res/vectors");
            if (dirVectors.mkdir())
                log.append("Создан каталог vectors\n");

            File dirIcons = new File("C://Games/res/icons");
            if (dirIcons.mkdir())
                log.append("Создан каталог icons\n");
        }

        File dirSaveGame = new File("C://Games/savegames");
        if (dirSaveGame.mkdir()) {
            log.append("Создан каталог savegames\n");
        }

        File dirTemp = new File("C://Games/temp");

        if (dirTemp.mkdir()) {
            log.append("Создан каталог temp\n");
            File fileTemp = new File("C://Games/temp", "temp.txt");
            if (fileTemp.createNewFile())
                log.append("Создан файл temp в каталоге C://Games/temp\n");

            try (FileWriter writer = new FileWriter(fileTemp)) {
                writer.write(log.toString());
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
