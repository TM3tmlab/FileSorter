package filesorter;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
  private static Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) throws IOException {
    log.info("処理開始します");

    Configure conf = Configure.instance();
    log.info("Configured basedir is {}", conf.getBaseDir());
    Path path = conf.getBaseDir();
    log.info("Sort from {}", path);

    Files.walkFileTree(path, Collections.emptySet(), 1, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // log.info(file.toString());
        return super.visitFile(file, attrs);
      }
    });

    log.info("正常終了します");
  }

}
