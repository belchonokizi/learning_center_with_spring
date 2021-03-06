//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.14 at 12:23:33 PM SAMT 
//


package com.ilzirabalobanova.epam.payments;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ilzirabalobanova.spring.ws.payments package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ilzirabalobanova.spring.ws.payments
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPaymentByStudentIdRequest }
     * 
     */
    public GetPaymentByStudentIdRequest createGetPaymentByStudentIdRequest() {
        return new GetPaymentByStudentIdRequest();
    }

    /**
     * Create an instance of {@link GetPaymentByStudentIdResponse }
     * 
     */
    public GetPaymentByStudentIdResponse createGetPaymentByStudentIdResponse() {
        return new GetPaymentByStudentIdResponse();
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link SetPaymentResponse }
     * 
     */
    public SetPaymentResponse createSetPaymentResponse() {
        return new SetPaymentResponse();
    }

    /**
     * Create an instance of {@link SetPaymentRequest }
     * 
     */
    public SetPaymentRequest createSetPaymentRequest() {
        return new SetPaymentRequest();
    }

}
