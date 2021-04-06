package src.generated.valuedomains.impl;

import org.abstractica.edma.valuedomains.IValueInstance;
import src.generated.valuedomains.Jobs;
import src.generated.valuedomains.Overall;
import src.generated.valuedomains.Overall.OverallBuilderJobs;
import src.generated.valuedomains.Overall.OverallBuilderWorker;
import src.generated.valuedomains.Worker;

/**
 * 
 */
public class OverallBuilderImpl implements OverallBuilderJobs, OverallBuilderWorker
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public OverallBuilderImpl()
    {
        edma_value = new Object[2];
    }

    /**
     * sets the worker field.
     * @param worker  The value to assign to the worker field
     * @return        Builder interface for setting the jobs field
     */
    public OverallBuilderJobs worker(Worker worker)
    {
        if(worker == null) throw new NullPointerException("The field worker in Overall may not be null");
        edma_value[0] = ((IValueInstance) worker).edma_getValue();
        return this;
    }

    /**
     * sets the jobs field.
     * @param jobs  The value to assign to the jobs field
     * @return      The created Overall value
     */
    public Overall jobs(Jobs jobs)
    {
        if(jobs == null) throw new NullPointerException("The field jobs in Overall may not be null");
        edma_value[1] = ((IValueInstance) jobs).edma_getValue();
        return new OverallImpl(OverallImpl.edma_create(edma_value));
    }
}
