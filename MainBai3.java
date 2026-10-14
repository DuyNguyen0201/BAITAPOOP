import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

interface PaymentMethod {
    String getType();

    String getName();

    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public String getType() {
        return "không dùng tiền mặt";
    }

    @Override
    public String getName() {
        return "thẻ tín dụng";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + formatAmount(amount) + " bằng " + getName() + ".");
    }

    private String formatAmount(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols);
        return df.format(amount);
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public String getType() {
        return "không dùng tiền mặt";
    }

    @Override
    public String getName() {
        return "PayPal";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + formatAmount(amount) + " qua " + getName() + ".");
    }

    private String formatAmount(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols);
        return df.format(amount);
    }
}

class CashPayment implements PaymentMethod {
    @Override
    public String getType() {
        return "trực tiếp";
    }

    @Override
    public String getName() {
        return "tiền mặt";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + formatAmount(amount) + " bằng " + getName() + ".");
    }

    private String formatAmount(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols);
        return df.format(amount);
    }
}

class MoMoPayment implements PaymentMethod {
    @Override
    public String getType() {
        return "không dùng tiền mặt";
    }

    @Override
    public String getName() {
        return "MoMo";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + formatAmount(amount) + " qua " + getName() + ".");
    }

    private String formatAmount(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols);
        return df.format(amount);
    }
}

class Order {
    private String customerName;
    private double amount;
    private PaymentMethod paymentMethod;

    public Order(String customerName, double amount, PaymentMethod paymentMethod) {
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void checkout() {
        System.out.println("Khách hàng: " + customerName);
        paymentMethod.pay(amount);
        System.out.println();
    }
}

public class MainBai3 {
    public static void main(String[] args) {
        Order order1 = new Order("An", 200000, new CreditCardPayment());
        order1.checkout();

        Order order2 = new Order("Bình", 150000, new PayPalPayment());
        order2.checkout();

        Order order3 = new Order("Chi", 100000, new CashPayment());
        order3.checkout();

        Order order4 = new Order("Dũng", 300000, new MoMoPayment());
        order4.checkout();
    }
}