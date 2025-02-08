public class Engine {
  private int cc;

  public Engine(int cc) {
    this.cc = cc;
  }

  public int getCC() {
    return this.cc;
  }

  public String start() {
    return "Vrroomm!!"; 
  }

  public String rev() {
    return "Vrroomm!! Vrroomm!!"; 
  }
}