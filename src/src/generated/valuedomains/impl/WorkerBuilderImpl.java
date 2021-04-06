package src.generated.valuedomains.impl;

import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import src.generated.valuedomains.Age;
import src.generated.valuedomains.Id;
import src.generated.valuedomains.Name;
import src.generated.valuedomains.Worker;
import src.generated.valuedomains.Worker.WorkerBuilderAge;
import src.generated.valuedomains.Worker.WorkerBuilderId;
import src.generated.valuedomains.Worker.WorkerBuilderName;
import src.generated.valuedomains.impl.AgeImpl;
import src.generated.valuedomains.impl.IdImpl;
import src.generated.valuedomains.impl.NameImpl;

/**
 * 
 */
public class WorkerBuilderImpl implements WorkerBuilderAge, WorkerBuilderId, WorkerBuilderName
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public WorkerBuilderImpl()
    {
        edma_value = new Object[3];
    }

    /**
     * sets the id field.
     * @param id  The value to assign to the id field
     * @return    Builder interface for setting the name field
     */
    public WorkerBuilderName id(Id id)
    {
        if(id == null) throw new NullPointerException("The field id in Worker may not be null");
        edma_value[0] = ((IValueInstance) id).edma_getValue();
        return this;
    }

    /**
     * sets the id field.
     * @param id  The value to assign to the id field
     * @return    Builder interface for setting the name field
     */
    public WorkerBuilderName id(Integer id) throws InvalidValueException
    {
        if(id != null) IdImpl.edma_validate(id);
        if(id == null) throw new NullPointerException();
        edma_value[0] = IdImpl.edma_create(id);
        return this;
    }

    /**
     * sets the name field.
     * @param name  The value to assign to the name field
     * @return      Builder interface for setting the age field
     */
    public WorkerBuilderAge name(Name name)
    {
        if(name == null) throw new NullPointerException("The field name in Worker may not be null");
        edma_value[1] = ((IValueInstance) name).edma_getValue();
        return this;
    }

    /**
     * sets the name field.
     * @param name  The value to assign to the name field
     * @return      Builder interface for setting the age field
     */
    public WorkerBuilderAge name(String name) throws InvalidValueException
    {
        if(name != null) NameImpl.edma_validate(name);
        if(name == null) throw new NullPointerException();
        edma_value[1] = NameImpl.edma_create(name);
        return this;
    }

    /**
     * sets the age field.
     * @param age  The value to assign to the age field
     * @return     The created Worker value
     */
    public Worker age(Age age)
    {
        if(age == null) throw new NullPointerException("The field age in Worker may not be null");
        edma_value[2] = ((IValueInstance) age).edma_getValue();
        return new WorkerImpl(WorkerImpl.edma_create(edma_value));
    }

    /**
     * sets the age field.
     * @param age  The value to assign to the age field
     * @return     The created Worker value
     */
    public Worker age(Integer age) throws InvalidValueException
    {
        if(age != null) AgeImpl.edma_validate(age);
        if(age == null) throw new NullPointerException();
        edma_value[2] = AgeImpl.edma_create(age);
        return new WorkerImpl(WorkerImpl.edma_create(edma_value));
    }
}
