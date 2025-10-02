public class HybridBus {

    public static void main(String[] args) {
        Engine engine = new Engine();

        System.out.println("Start both engines");
        engine.startDieselMotor();
        engine.startElectricMotor();
    }
}