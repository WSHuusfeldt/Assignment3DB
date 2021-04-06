package src.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;
import src.generated.Assignment3;
import src.generated.valuedomains.Jobs;
import src.generated.valuedomains.Worker;
import src.generated.valuedomains.external.EDMA_ExternalConstraints;
import src.generated.valuedomains.impl.OverallBuilderImpl;
import src.generated.valuedomains.impl.OverallImpl;

/**
 * The representation of a value from the value domain: Overall
 */
public abstract class Overall implements Comparable<Overall>
{
    protected static final IMetaValueDomain edma_domain = Assignment3.environment.getValueDomainDefinitions().getValueDomain(7);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Overall from the terminal
     */
    public static Overall fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new OverallImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Overall from the string representation
     */
    public static Overall fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new OverallImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Overall read from the stream
     */
    public static Overall fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new OverallImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Overall read from the stream
     */
    public static Overall fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new OverallImpl(res);
    }

    /**
     * Starts creation of a new Overall
     * @return  Builder interface to set the worker field
     */
    public static OverallBuilderWorker create()
    {
        return new OverallBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field worker
     * @return  The value of the field worker
     */
    public abstract Worker worker();

    /**
     * returns the value of the field jobs
     * @return  The value of the field jobs
     */
    public abstract Jobs jobs();


    /**
     * Builder interface for setting the worker field of Overall
     */
    public interface OverallBuilderWorker
    {

        /**
         * sets the worker field.
         * @param worker  The value to assign to the worker field
         * @return        Builder interface for setting the jobs field
         */
        public OverallBuilderJobs worker(Worker worker);

    }



    /**
     * Builder interface for setting the jobs field of Overall
     */
    public interface OverallBuilderJobs
    {

        /**
         * sets the jobs field.
         * @param jobs  The value to assign to the jobs field
         * @return      The created Overall value
         */
        public Overall jobs(Jobs jobs);

    }

}
