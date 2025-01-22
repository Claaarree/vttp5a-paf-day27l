package vttp5a_paf.day27l.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.client.model.Indexes;

@Repository
public class CommentsRepository {

    @Autowired
    private MongoTemplate template;

    public static final String C_COMMENTS = "comments";
    public static final String F_C_TEXT = "c_text";

    public void dropCommentsCollection() {
        template.dropCollection(C_COMMENTS);
    }
    
    public void insertComments(Document commentDoc) {
        template.insert(commentDoc, C_COMMENTS);
    }

    public void createTextIndex(){
        template.getCollection(C_COMMENTS).createIndex(Indexes.text(F_C_TEXT));
    }
    
}
