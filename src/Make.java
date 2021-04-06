import org.abstractica.edma.generator.EdmaGenerator;

public class Make {
    public static void main(String[] args) {
        String projectDir = "C:\\Users\\William\\Desktop\\Skole\\DB\\Handins\\Assignment3";
        EdmaGenerator generator = new EdmaGenerator("Assignment3", projectDir + "/edmasrc", projectDir + "/src", "src");
        generator.make();
    }
}
