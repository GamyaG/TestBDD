package utils.AKVOperations;
import com.azure.core.util.polling.SyncPoller;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.DeletedSecret;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static utils.AKVOperations.Read_AKV_Url.keyvaulturl;

public class AzurekeyvaultHelper {
    private static final Logger log= LoggerFactory.getLogger(AzurekeyvaultHelper.class);
    private AzurekeyvaultHelper(){

    }
    public static SecretClient secretBuilder() {
        String keyVaultUri = keyvaulturl;
        log.info(keyVaultUri);
        log.info(keyVaultUri);
        SecretClient secretclient = new SecretClientBuilder()
                .vaultUrl(keyVaultUri)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
        return secretclient;
    }

    public static void setSecret(String secretName,String secretValue) {
        secretBuilder().setSecret(new KeyVaultSecret(secretName, secretValue));
    }

    public static String getSecret(String secretName) {
        KeyVaultSecret retrievedSecret = secretBuilder().getSecret(secretName);
        return retrievedSecret.getValue();
    }
    public static void deleteSecret(String keyVaultName,String secretName) {
        SyncPoller<DeletedSecret, Void> deletionPoller = secretBuilder()
                .beginDeleteSecret(secretName);
        deletionPoller.waitForCompletion();
    }

}
