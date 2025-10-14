public class ObserverDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer cnn = new NewsChannel("CNN");
        Observer bbc = new NewsChannel("BBC");

        agency.attach(cnn);
        agency.attach(bbc);

        agency.breakingNews("New technology breakthrough!");
        agency.breakingNews("Elections coming soon...");

        agency.detach(cnn);

        agency.breakingNews("Sports team wins championship!");
    }
}
