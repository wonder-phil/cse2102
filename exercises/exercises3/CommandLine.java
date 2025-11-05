public class CommandLine {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided.");
        } else {
            System.out.println("Arguments provided:");
            for (String arg : args) {
                System.out.println(arg);
            }
        }
    }
}

