public class Engine extends DieselMotor implements ElectricMotor {

    @Override
    public void startElectricMotor() {
        System.out.println("start ElectricMotor");
    }

}