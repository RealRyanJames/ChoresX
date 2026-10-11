package DB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DBConnector {

    public static void ConnectDBClient(String dataDB) {

        ServerApi api =
                ServerApi.builder().version(ServerApiVersion.V1).build();
        MongoClientSettings set = MongoClientSettings.builder()
                .applyConnectionString(
                new ConnectionString("mongodb://localhost:27017")).serverApi(api).build();

        try(MongoClient c = MongoClients.create(set)) {
            try {
                Document doc = new Document("Completed Todos", dataDB);
                MongoDatabase db = c.getDatabase("Todos");
                db.createCollection("Todo");
                MongoCollection<Document> coll = db.getCollection("Todo");
                coll.insertOne(doc);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            finally {
                c.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
