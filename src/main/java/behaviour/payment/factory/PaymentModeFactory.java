package behaviour.payment.factory;

import behaviour.payment.paymenttype.PaymentType;

public interface PaymentModeFactory {

    PaymentType getPaymentType(String paymentType);
}
