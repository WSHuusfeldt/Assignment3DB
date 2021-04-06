package src.generated.valuedomains.impl;

import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import src.generated.valuedomains.Job;
import src.generated.valuedomains.Job.JobBuilderName;
import src.generated.valuedomains.Job.JobBuilderPay;
import src.generated.valuedomains.Name;
import src.generated.valuedomains.Pay;
import src.generated.valuedomains.impl.NameImpl;
import src.generated.valuedomains.impl.PayImpl;

/**
 * 
 */
public class JobBuilderImpl implements JobBuilderName, JobBuilderPay
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public JobBuilderImpl()
    {
        edma_value = new Object[2];
    }

    /**
     * sets the name field.
     * @param name  The value to assign to the name field
     * @return      Builder interface for setting the pay field
     */
    public JobBuilderPay name(Name name)
    {
        if(name == null) throw new NullPointerException("The field name in Job may not be null");
        edma_value[0] = ((IValueInstance) name).edma_getValue();
        return this;
    }

    /**
     * sets the name field.
     * @param name  The value to assign to the name field
     * @return      Builder interface for setting the pay field
     */
    public JobBuilderPay name(String name) throws InvalidValueException
    {
        if(name != null) NameImpl.edma_validate(name);
        if(name == null) throw new NullPointerException();
        edma_value[0] = NameImpl.edma_create(name);
        return this;
    }

    /**
     * sets the pay field.
     * @param pay  The value to assign to the pay field
     * @return     The created Job value
     */
    public Job pay(Pay pay)
    {
        if(pay == null) throw new NullPointerException("The field pay in Job may not be null");
        edma_value[1] = ((IValueInstance) pay).edma_getValue();
        return new JobImpl(JobImpl.edma_create(edma_value));
    }

    /**
     * sets the pay field.
     * @param pay  The value to assign to the pay field
     * @return     The created Job value
     */
    public Job pay(Integer pay) throws InvalidValueException
    {
        if(pay != null) PayImpl.edma_validate(pay);
        if(pay == null) throw new NullPointerException();
        edma_value[1] = PayImpl.edma_create(pay);
        return new JobImpl(JobImpl.edma_create(edma_value));
    }
}
