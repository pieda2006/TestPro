package com.nec.corestudy.amf.NamfCommunication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.nec.corestudy.amf.NamfCommunication", "com.nec.corestudy.amf.NamfCommunication.api" })
public class Swagger2SpringBoot implements CommandLineRunner {

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
                try{
                    gs_timer = Integer.parseInt(System.getenv("NEC_5GS_CONT_GS_TIMER"));
                    if(0 > gs_timer){
                        gs_timer = 5000;
                    }
                }catch(NumberFormatException e){
                    gs_timer = 5000;
                }
                try{
                    Thread.sleep(gs_timer);
                }catch (InterruptedException e){
                }
            }
        });
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
