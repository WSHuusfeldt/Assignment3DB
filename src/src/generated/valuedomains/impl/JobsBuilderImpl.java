package src.generated.valuedomains.impl;

import java.util.ArrayList;
import org.abstractica.edma.valuedomains.IValueInstance;
import src.generated.valuedomains.Job;
import src.generated.valuedomains.Jobs;
import src.generated.valuedomains.Jobs.JobsBuilder;

/**
 * 
 */
public class JobsBuilderImpl implements JobsBuilder
{
    private ArrayList<Object> valueList;



    /**
     * Constructor
     */
    public JobsBuilderImpl()
    {
        valueList = new ArrayList<Object>();
    }

    /**
     * Adds an element to the list
     * @param job  The element to be added to the list
     * @return     An interface to the builder for chaining method calls
     */
    public JobsBuilder add(Job job)
    {
        if(job == null) throw new NullPointerException();
        valueList.add(((IValueInstance) job).edma_getValue());
        return this;
    }

    /**
     * Builds the list with the added elements
     * @return  The builded list
     */
    public Jobs end()
    {
        Object[] res = new Object[valueList.size()];
        int pos = 0;
        for(Object o : valueList)
        {
            res[pos++] = o;
        }
        return new JobsImpl(JobsImpl.edma_create(res));
    }
}
