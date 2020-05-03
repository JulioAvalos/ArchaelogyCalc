package com.arch.calculator.bootstrap;

import com.arch.calculator.domain.Material;
import com.arch.calculator.domain.dto.Response;
import com.arch.calculator.services.MaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class MaterialLoader implements CommandLineRunner {

    @Autowired
    MaterialClient client;

    @Autowired
    MaterialService service;

    @Override
    public void run(String... args) throws Exception {
        List<Long> ids = new ArrayList<>();

        ids.add(49460L);
        ids.add(49514L);
        ids.add(49456L);
        ids.add(49510L);
        ids.add(49464L);
        ids.add(49450L);
        ids.add(49454L);
        ids.add(49462L);
        ids.add(49496L);
        ids.add(49506L);
        ids.add(49512L);
        ids.add(49498L);
        ids.add(49500L);
        ids.add(49452L);
        ids.add(49502L);
        ids.add(49504L);
        ids.add(49490L);
        ids.add(49494L);
        ids.add(49486L);
        ids.add(49488L);
        ids.add(49492L);
        ids.add(49508L);
        ids.add(49472L);
        ids.add(49474L);
        ids.add(49446L);
        ids.add(49468L);
        ids.add(49476L);
        ids.add(49478L);
        ids.add(49480L);
        ids.add(49482L);
        ids.add(49448L);
        ids.add(49484L);
        ids.add(49470L);
        ids.add(49458L);
        ids.add(49466L);

//        List<Response> responseList = new ArrayList<>();

        for (Long item : ids) {
            Response dto = client.getMaterialById(item);
            if (dto.getItem() != null) {
                Material material = Material.builder()
                        .ge_id(dto.getItem().getId())
                        .name(dto.getItem().getName())
                        .url_image(dto.getItem().getIcon())
                        .price(dto.getItem().getCurrent().getPrice())
                        .build();
                service.add(material);
            }
        }

    }

}
