package filesorter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Configure {

  private static final String LOAD_TARGET = "conf.xml";

  private final Properties properties;

  private Configure() {
    this(LOAD_TARGET);
  }

  private Configure(String loadTarget) {
    properties = new Properties();
    try {
      properties.loadFromXML(Configure.class.getClassLoader().getResourceAsStream(loadTarget));
    } catch (InvalidPropertiesFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Configure instance() {
    return new Configure();
  }

  public Path getBaseDir() {
    return Paths.get(properties.getProperty("baseDir"));
  }
}
