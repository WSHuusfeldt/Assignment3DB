package src.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;
import src.generated.Assignment3;
import src.generated.valuedomains.external.EDMA_ExternalConstraints;
import src.generated.valuedomains.impl.PayImpl;

/**
 * The representation of a value from the value domain: Pay
 */
public abstract class Pay implements Comparable<Pay>
{
    protected static final IMetaValueDomain edma_domain = Assignment3.environment.getValueDomainDefinitions().getValueDomain(3);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Pay from the terminal
     */
    public static Pay fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new PayImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Pay from the string representation
     */
    public static Pay fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new PayImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Pay read from the stream
     */
    public static Pay fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new PayImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Pay read from the stream
     */
    public static Pay fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new PayImpl(res);
    }

    /**
     * Call this method to create a new Pay value. 
     * @param value  The value of the Pay to be created.
     * @return       The newly created Pay value
     */
    public static Pay create(Integer value) throws InvalidValueException
    {
        PayImpl.edma_validate(value);
        return new PayImpl(PayImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid Pay
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid Pay
     */
    public static boolean isValidPay(Integer value)
    {
        try
        {
            PayImpl.edma_validate(value);
        }
        catch(InvalidValueException e)
        {
            return false;
        }
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Integer value that is stored in this Pay
     * @return  The Integer value stored in this Pay
     */
    public abstract Integer value();
}
