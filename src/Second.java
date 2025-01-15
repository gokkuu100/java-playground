public class Second {
    public static int nbYear(int p0, double percent, int aug, int p) {

        int years = 0;
        double currentPopulation = p0;

        while (currentPopulation < p) {
            currentPopulation += (currentPopulation * (percent / 100)) + aug;
            years++;
        }
        return years;
    }

    public static void main(String[] args) {
        int p0 = 1500;
        double percent = 5;
        int aug = 100;
        int p = 5000;

        int years = nbYear(p0, percent, aug, p);
        System.out.println("Years needed: " + years);
    }

}




