import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printingRemainingMortgage() {
        System.out.println();
        System.out.println("PAYMENT SCHADULE");
        System.out.println("-----------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(result(balance));
    }

    public void printingCurretnMortgage() {
        double mortgage = calculator.calcualteMortgage();
        String result = result(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-----------");
        System.out.println("Monthly Payments: " + result);
    }

    private String result(double value) {
        String result = currency.format(value);
        return result;
    }

}
