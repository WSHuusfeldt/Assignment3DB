package src.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;
import src.generated.Assignment3;
import src.generated.valuedomains.Age;
import src.generated.valuedomains.Id;
import src.generated.valuedomains.Name;
import src.generated.valuedomains.external.EDMA_ExternalConstraints;
import src.generated.valuedomains.impl.WorkerBuilderImpl;
import src.generated.valuedomains.impl.WorkerImpl;

/**
 * The representation of a value from the value domain: Worker
 */
public abstract class Worker implements Comparable<Worker>
{
    protected static final IMetaValueDomain edma_domain = Assignment3.environment.getValueDomainDefinitions().getValueDomain(4);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Worker from the terminal
     */
    public static Worker fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new WorkerImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Worker from the string representation
     */
    public static Worker fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new WorkerImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Worker read from the stream
     */
    public static Worker fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new WorkerImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Worker read from the stream
     */
    public static Worker fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new WorkerImpl(res);
    }

    /**
     * Starts creation of a new Worker
     * @return  Builder interface to set the id field
     */
    public static WorkerBuilderId create()
    {
        return new WorkerBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field id
     * @return  The value of the field id
     */
    public abstract Id id();

    /**
     * returns the value of the field name
     * @return  The value of the field name
     */
    public abstract Name name();

    /**
     * returns the value of the field age
     * @return  The value of the field age
     */
    public abstract Age age();


    /**
     * Builder interface for setting the id field of Worker
     */
    public interface WorkerBuilderId
    {

        /**
         * sets the id field.
         * @param id  The value to assign to the id field
         * @return    Builder interface for setting the name field
         */
        public WorkerBuilderName id(Id id);

        /**
         * sets the id field.
         * @param id  The value to assign to the id field
         * @return    Builder interface for setting the name field
         */
        public WorkerBuilderName id(Integer id) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the name field of Worker
     */
    public interface WorkerBuilderName
    {

        /**
         * sets the name field.
         * @param name  The value to assign to the name field
         * @return      Builder interface for setting the age field
         */
        public WorkerBuilderAge name(Name name);

        /**
         * sets the name field.
         * @param name  The value to assign to the name field
         * @return      Builder interface for setting the age field
         */
        public WorkerBuilderAge name(String name) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the age field of Worker
     */
    public interface WorkerBuilderAge
    {

        /**
         * sets the age field.
         * @param age  The value to assign to the age field
         * @return     The created Worker value
         */
        public Worker age(Age age);

        /**
         * sets the age field.
         * @param age  The value to assign to the age field
         * @return     The created Worker value
         */
        public Worker age(Integer age) throws InvalidValueException;

    }

}
