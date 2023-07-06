
public class App {
    

    public static void main(String[] args) {
        int principal;
        float AnnulInterestReate;
        byte period;

        principal = (int) Concole.readNumber("Principal ($1K - $1KK)", 1000, 1_000_000);

        AnnulInterestReate = (float) Concole.readNumber("Annual Interest Rate (1 - 30):", 1, 30);

        period = (byte) Concole.readNumber("Period (1 Year - 30 Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, AnnulInterestReate, period);

        var report = new MortgageReport(calculator);

        report.printingCurretnMortgage();
        report.printingRemainingMortgage();

    }

}