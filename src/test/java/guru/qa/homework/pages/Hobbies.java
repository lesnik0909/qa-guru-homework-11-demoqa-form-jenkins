package guru.qa.homework.pages;

public enum Hobbies {

  SPORTS("[for='hobbies-checkbox-1']"),
  READING("[for='hobbies-checkbox-2']"),
  MUSIC("[for='hobbies-checkbox-3']");

  private String selector;

  Hobbies(String selector) {
    this.selector = selector;
  }

  public String getSelector() {
    return selector;
  }

}
