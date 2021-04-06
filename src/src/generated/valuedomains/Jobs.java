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
import src.generated.valuedomains.impl.JobsBuilderImpl;
import src.generated.valuedomains.impl.JobsImpl;

/**
 * The representation of a value from the value domain: Jobs
 */
public abstract class Jobs implements Comparable<Jobs>, Iterable<Job>
{
    protected static final IMetaValueDomain edma_domain = Assignment3.environment.getValueDomainDefinitions().getValueDomain(6);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Jobs from the terminal
     */
    public static Jobs fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new JobsImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Jobs from the string representation
     */
    public static Jobs fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new JobsImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Jobs read from the stream
     */
    public static Jobs fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new JobsImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Jobs read from the stream
     */
    public static Jobs fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new JobsImpl(res);
    }

    /**
     * Starts creation of a new Jobs
     * @return  Builder interface to build the list
     */
    public static JobsBuilder begin()
    {
        return new JobsBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * Returns the size of this list
     * @return  the size of this list
     */
    public abstract int size();

    /**
     * Returns the element on a given index in this list
     * @param index  The index of the element to be returned
     * @return       the element on the given index in this list
     */
    public abstract Job get(int index);


    /**
     * Interface to create a list
     */
    public interface JobsBuilder
    {

        /**
         * Adds an element to the list
         * @param job  The element to be added to the list
         * @return     An interface to the builder for chaining method calls
         */
        public JobsBuilder add(Job job);

        /**
         * Builds the list with the added elements
         * @return  The builded list
         */
        public Jobs end();

    }

}
