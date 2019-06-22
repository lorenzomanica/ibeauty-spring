package br.pro.lmit.pds.ibeauty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {
        "br.pro.lmit.pds.ibeauty",
        "br.pro.lmit.pds.ibeauty.controller",
        "br.pro.lmit.pds.ibeauty.repository",
        "br.pro.lmit.pds.ibeauty.entity"
})
public class IbeautyApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbeautyApplication.class, args);
    }
}
