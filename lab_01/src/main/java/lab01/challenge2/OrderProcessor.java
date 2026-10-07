package lab01.challenge2;

import java.util.List;

public class OrderProcessor {
    private final OrderValidator validator;
    private final OrderRepository repository;
    private final Notifier notifier;

    public OrderProcessor(OrderValidator validator, OrderRepository repository, Notifier notifier) {
        this.validator = validator;
        this.repository = repository;
        this.notifier = notifier;
    }

    public void process(String email, List<Double> prices, DiscountPolicy discountPolicy, PaymentMethod paymentMethod) {
        validator.validate(email, prices);

        double total = 0;
        for (double price : prices) {
            total += price;
        }
        total = discountPolicy.applyDiscount(total);

        paymentMethod.pay(total);

        repository.save(email + ";" + total);

        notifier.send(email, "Order of " + total + " RON placed");
    }

    public static void run() {
        OrderValidator validator = new OrderValidator();
        OrderRepository fileDb = new FileDatabase();
        Notifier emailSender = new EmailSender();

        OrderProcessor processor = new OrderProcessor(validator, fileDb, emailSender);

        System.out.println("Comanda facuta de student cu card:");
        processor.process(
                "ana@student.utcluj.ro",
                List.of(100.0, 50.0),
                new StudentDiscount(),
                new CardPayment()
        );

        System.out.println("Comanda facuta de angajat prin transfer:");
        processor.process(
                "david@firma.ro",
                List.of(200.0, 100.0),
                new EmployeeDiscount(),
                new BankTransferPayment()
        );
    }
}