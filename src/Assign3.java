import org.json.JSONArray;
import org.json.JSONObject;
import src.generated.valuedomains.*;
import src.generated.valuedomains.impl.JobsBuilderImpl;
import src.generated.valuedomains.impl.JobsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Assign3 {
    public static void main(String[] args) {
        try {
            String content = Files.readString(Paths.get("C:\\Users\\William\\Desktop\\Skole\\DB\\Handins\\Assignment3\\src\\Data\\data.json"));
            JSONObject jsonData = new JSONObject(content);

            //Task 1 start
            jsonData.getJSONObject("worker").getString("name");

            Id id = Id.create(jsonData.getJSONObject("worker").getInt("id"));
            Name workerName = Name.create(jsonData.getJSONObject("worker").getString("name"));
            Age age = Age.create(jsonData.getJSONObject("worker").getInt("age"));

            JSONArray arr = jsonData.getJSONArray("jobs");

            JobsBuilderImpl jobsBuilder = new JobsBuilderImpl();
            Jobs jobs = new JobsImpl(null);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject jobj = arr.getJSONObject(i);
                Name jobName = Name.create(jobj.getString("name"));
                Pay pay = Pay.create(jobj.getInt("pay"));

                Job job = Job.create().name(jobName).pay(pay);
                jobs = jobsBuilder.add(job).end();
            }

            Worker worker = Worker.create().id(id).name(workerName).age(age);

            Overall overall = Overall.create().worker(worker).jobs(jobs);

            System.out.println(overallToString(overall));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String jobsToString(Jobs jobs) {
        String str = "";
        for(Job a : jobs) {
            str +=  "\n{" +
                    "\n\"name\": " + a.name() + "," +
                    "\n\"pay\": " + a.pay() +
                    "\n},";
        }
        return str;
    }
    private static String overallToString(Overall o) {
        return "{\n\"worker\": " +
                "\n{" +
                "\n\"id\": " + o.worker().id() + "," +
                "\n\"name\": " + o.worker().name() + "," +
                "\n\"age\": " + o.worker().age() +
                "\n}," +
                "\n\"jobs\": [" +
                jobsToString(o.jobs()) +
                "\n]" +
                "\n}";

    }
}
