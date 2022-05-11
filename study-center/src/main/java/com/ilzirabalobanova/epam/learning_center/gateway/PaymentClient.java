package com.ilzirabalobanova.epam.learning_center.gateway;

import com.ilzirabalobanova.epam.payments.ObjectFactory;
import com.ilzirabalobanova.epam.payments.SetPaymentRequest;
import com.ilzirabalobanova.epam.payments.SetPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

@RequiredArgsConstructor
public class PaymentClient extends WebServiceGatewaySupport {
    private ObjectFactory objectFactory;
    @Autowired
    public void setObjectFactory(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    public SetPaymentResponse setPayment(BigInteger studentId, BigInteger programId, Long paymentAmount) {
        SetPaymentRequest request = objectFactory.createSetPaymentRequest();
        request.setStudentId(studentId);
        request.setProgramId(programId);
        request.setPaymentAmount(paymentAmount);
        return (SetPaymentResponse) getWebServiceTemplate()
                .marshalSendAndReceive(getDefaultUri(), request);

    }
}
