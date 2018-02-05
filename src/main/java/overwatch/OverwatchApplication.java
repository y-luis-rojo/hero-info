package overwatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"overwatch"})
public class OverwatchApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(OverwatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0 && args[0].equals("exitcode")) {
            throw new Exception();
        }
    }
}
