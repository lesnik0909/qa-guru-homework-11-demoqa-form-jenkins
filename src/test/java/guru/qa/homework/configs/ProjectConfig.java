package guru.qa.homework.configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:project.properties"})
public interface ProjectConfig extends Config {

  String login();

  String password();

  String selenoidUrl();

}
