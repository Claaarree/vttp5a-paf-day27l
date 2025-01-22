package vttp5a_paf.day27l.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import vttp5a_paf.day27l.repository.CommentsRepository;

@Component
public class JsonFileReader {

    @Autowired
    private CommentsRepository commentsRepository;
    
    public void readJsonFile(String jsonFilePath) throws FileNotFoundException {
        File jsonFile = new File(jsonFilePath);
        JsonArray commentsArray = Json.createReader(new FileInputStream(jsonFile))
                .readArray();

        for (int i = 0 ; i < commentsArray.size(); i++) {
            JsonObject commentObject = commentsArray.getJsonObject(i);
            String id = commentObject.getString("c_id");
            Document commentDoc = Document.parse(commentObject.toString());
            commentDoc.remove("c_id");
            commentDoc.put("_id", id);
            commentsRepository.insertComments(commentDoc);
        }
    }
}
