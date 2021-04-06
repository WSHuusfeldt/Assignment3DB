package src.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;
import src.generated.Assignment3;
import src.generated.valuedomains.Name;
import src.generated.valuedomains.Pay;
import src.generated.valuedomains.external.EDMA_ExternalConstraints;
import src.generated.valuedomains.impl.JobBuilderImpl;
import src.generated.valuedomains.impl.JobImpl;

/**
 * The representation of a value from the value domain: Job
 */
public abstract class Job implements Comparable<Job>
{
    protected static final IMetaValueDomain edma_domain = Assignment3.environment.getValueDomainDefinitions().getValueDomain(5);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Job from the terminal
     */
    public static Job fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new JobImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Job from the string representation
     */
    public static Job fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new JobImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Job read from the stream
     */
    public static Job fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new JobImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Job read from the stream
     */
    public static Job fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new JobImpl(res);
    }

    /**
     * Starts creation of a new Job
     * @return  Builder interface to set the name field
     */
    public static JobBuilderName create()
    {
        return new JobBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field name
     * @return  The value of the field name
     */
    public abstract Name name();

    /**
     * returns the value of the field pay
     * @return  The value of the field pay
     */
    public abstract Pay pay();


    /**
     * Builder interface for setting the name field of Job
     */
    public interface JobBuilderName
    {

        /**
         * sets the name field.
         * @param name  The value to assign to the name field
         * @return      Builder interface for setting the pay field
         */
        public JobBuilderPay name(Name name);

        /**
         * sets the name field.
         * @param name  The value to assign to the name field
         * @return      Builder interface for setting the pay field
         */
        public JobBuilderPay name(String name) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the pay field of Job
     */
    public interface JobBuilderPay
    {

        /**
         * sets the pay field.
         * @param pay  The value to assign to the pay field
         * @return     The created Job value
         */
        public Job pay(Pay pay);

        /**
         * sets the pay field.
         * @param pay  The value to assign to the pay field
         * @return     The created Job value
         */
        public Job pay(Integer pay) throws InvalidValueException;

    }

}
