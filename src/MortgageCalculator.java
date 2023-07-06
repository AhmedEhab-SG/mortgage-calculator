public class MortgageCalculator {

    private final static byte MONTHLY_OVER_YEAR = 12;
    private final static byte PRECENT = 100;

    private int principal;
    private float AnnulInterestReate;
    private byte period;

    public MortgageCalculator(int principal, float AnnulInterestReate, byte period) {
        this.principal = principal;
        this.AnnulInterestReate = AnnulInterestReate;
        this.period = period;
    }

    public double calcualteMortgage() {

        float monthlyIntrest = getMonthlyIntrest();
        short numberOfPayment = getNumberOfPayment();

        double mortgage = principal * (monthlyIntrest * Math.pow(1 + monthlyIntrest, numberOfPayment)
                / (Math.pow(1 + monthlyIntrest, numberOfPayment) - 1));
        return mortgage;
    }

    public double remainingLoan(short numberOfPaymentMade) {

        float monthlyIntrest = getMonthlyIntrest();
        float numberOfPayment = getNumberOfPayment();

        double balance = principal
                * (Math.pow(1 + monthlyIntrest, numberOfPayment)
                        - Math.pow(1 + monthlyIntrest, numberOfPaymentMade))
                / (Math.pow(1 + monthlyIntrest, numberOfPayment) - 1);
        return balance;
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayment()];
        for (short month = 1; month <= balances.length; month++) {
            double balance = remainingLoan(month);
            balances[month - 1] = balance;
        }
        return balances;
    }

    private short getNumberOfPayment() {
        short numberOfPayment = (short) (period * MortgageCalculator.MONTHLY_OVER_YEAR);
        return numberOfPayment;
    }

    private float getMonthlyIntrest() {
        float monthlyIntrest = AnnulInterestReate / PRECENT / MortgageCalculator.MONTHLY_OVER_YEAR;
        return monthlyIntrest;
    }

}
