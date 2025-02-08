public class Runner {
  public static void main(String[] args){
     Engine engine = new Engine(1800);
     Gearbox gearbox = new Gearbox("manual", 4);

     System.out.println(engine.start());

     Car car = new Car("Ford", "Escort", engine, gearbox);
     System.out.println(car.start());
     car.changeGear(2);
     System.out.println(car.getCurrentGear());
  }
}