package vttp5a_paf.day27l;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp5a_paf.day27l.repository.CommentsRepository;
import vttp5a_paf.day27l.repository.TaskRepository;
import vttp5a_paf.day27l.utils.JsonFileReader;

@SpringBootApplication
public class Day27lApplication implements CommandLineRunner{

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private CommentsRepository commentsRepository;

	@Autowired
	private JsonFileReader jsonFileReader;

	public static void main(String[] args) {
		SpringApplication.run(Day27lApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// taskRepository.insertTask();
		// taskRepository.insertTask2();
		// taskRepository.searchComments("enjoyable", "fun times");

		// AM code above
		// PM extra task code below

		// usage: java -jar target/day27l-0.0.1-SNAPSHOT.jar --load="C:\Users\Clare Lau\Desktop\VTTP\Persistance and Analytics Fundamentals\bgg\comment.json"
		if (args.length > 0){
			commentsRepository.dropCommentsCollection();

			String commentsFilePath = args[0].substring(7);
			System.out.println(commentsFilePath);
			jsonFileReader.readJsonFile(commentsFilePath);
			commentsRepository.createTextIndex();
		} else {
			System.out.println("Please specify file path for comment.json");
			System.exit(1);
		}

	}

}
