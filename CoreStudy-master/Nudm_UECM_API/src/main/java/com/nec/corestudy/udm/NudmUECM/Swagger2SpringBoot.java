package com.nec.corestudy.udm.NudmUECM;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nec.corestudy.udm.NudmUECM.common.api.UdrInfo;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.nec.corestudy.udm.NudmUECM", "com.nec.corestudy.udm.NudmUECM.api" })
public class Swagger2SpringBoot implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Swagger2SpringBoot.class);

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run() {
                int gs_timer = 0;
                try {
                    gs_timer = Integer.parseInt(System.getenv("NEC_5GS_CONT_GS_TIMER"));
                    if (0 > gs_timer) {
                        gs_timer = 5000;
                        log.debug("gs_timer default set");
                    }
                    log.debug("gs_timer set Success : " + gs_timer);
                } catch (NumberFormatException e) {
                    log.error("Error NumberFormatException");
                    gs_timer = 5000;
                    log.error("gs_timer default set");
                }
                try {
                    log.debug("Thread.sleep start");
                    Thread.sleep(gs_timer);
                    log.debug("Thread.sleep end");
                } catch (InterruptedException e) {
                    log.error("Error InterruptedException");
                }
            }
        });
        new SpringApplication(Swagger2SpringBoot.class).run(args);
        // UdrInfo create
        log.info("### UdrInfo.setUdrInfo Start ###");
        UdrInfo.setUdrInfo();
        log.info("### UdrInfo.setUdrInfo End ###");
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
