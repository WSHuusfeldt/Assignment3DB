package src.generated;

import java.util.ArrayList;
import java.util.Collection;
import org.abstractica.edma.metamodel.IMetaEnvironment;
import org.abstractica.edma.metamodel.impl.MetaEnvironment;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder.Field;
import org.abstractica.edma.runtime.implementations.mem.modelstore.speed.newindex.IndexUtil;
import org.abstractica.edma.runtime.intf.IRuntimeFactory;
import org.abstractica.edma.valuedomains.impl.Constraint;

/**
 * 
 */
public class Assignment3
{
    public static final IMetaEnvironment environment = generateEnvironment();



    /**
     * generate the environment
     * @return  
     */
    public static IMetaEnvironment generateEnvironment()
    {
        ValueDomainBuilder vdb = new ValueDomainBuilder();
        
        //Integer value domain: Id
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Id", null, 1, 1000, edma_constraints, false);
        }
        
        //String value domain: Name
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("Name", null, 1, null, null, edma_constraints, false);
        }
        
        //Integer value domain: Age
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Age", null, 1, 99, edma_constraints, false);
        }
        
        //Integer value domain: Pay
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Pay", null, 1, null, edma_constraints, false);
        }
        
        //Struct value domain: Worker
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("id", "Id", false));
            fields.add(vdb.newStructField("name", "Name", false));
            fields.add(vdb.newStructField("age", "Age", false));
            vdb.newStructDomain("Worker", null, fields, edma_constraints, false);
        }
        
        //Struct value domain: Job
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("name", "Name", false));
            fields.add(vdb.newStructField("pay", "Pay", false));
            vdb.newStructDomain("Job", null, fields, edma_constraints, false);
        }
        
        //List value domain: Jobs
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newListDomain("Jobs", null, "Job", null, null, edma_constraints, false);
        }
        
        //Struct value domain: Overall
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("worker", "Worker", false));
            fields.add(vdb.newStructField("jobs", "Jobs", false));
            vdb.newStructDomain("Overall", null, fields, edma_constraints, false);
        }
        MetaEnvironment edma_environment = new MetaEnvironment("Assignment3");
        vdb.buildWithEnvironment(edma_environment);
        //Hack to make serializeable work...
        IndexUtil.setValueDomainDefinitions(edma_environment.getValueDomainDefinitions());
        return edma_environment;
    }

    /**
     * Constructor
     * @param factory  The runtime factory
     */
    public Assignment3(IRuntimeFactory factory)
    {
        
    }
}
