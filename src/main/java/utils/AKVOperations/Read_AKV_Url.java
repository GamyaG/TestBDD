package utils.AKVOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class Read_AKV_Url {
    private static final Logger log= LoggerFactory.getLogger(Read_AKV_Url.class);
    public static final String keyvaulturl= get("AKV");
    public Read_AKV_Url(){

    }
    public static String get(String AKV) {
        String keyvault = null;
        Properties properties = new Properties();

        try ( FileInputStream file = new FileInputStream(Paths.get("").toAbsolutePath()+ File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator +"properties"+ File.separator +"config.properties")){

            properties.load(file);
            keyvault = properties.getProperty(AKV).toLowerCase().trim();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return keyvault;
    }


}
