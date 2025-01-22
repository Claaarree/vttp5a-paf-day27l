package vttp5a_paf.day27l;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp5a_paf.day27l.repository.TaskRepository;

@SpringBootApplication
public class Day27lApplication implements CommandLineRunner{

	@Autowired
	private TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(Day27lApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// taskRepository.insertTask();
		// taskRepository.insertTask2();

		taskRepository.searchComments("enjoyable", "fun times");
	}

}
