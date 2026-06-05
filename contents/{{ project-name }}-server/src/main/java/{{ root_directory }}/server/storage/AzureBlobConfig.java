package {{ group_id }}.server.storage;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureBlobConfig {

    @Value("${storage.azure.endpoint}")
    private String endpoint;

    @Value("${storage.azure.account-name}")
    private String accountName;

    @Value("${storage.azure.account-key}")
    private String accountKey;

    @Bean
    public BlobServiceClient blobServiceClient() {
        String connectionString = String.format(
                "DefaultEndpointsProtocol=http;AccountName=%s;AccountKey=%s;BlobEndpoint=%s",
                accountName, accountKey, endpoint);
        return new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
    }
}
