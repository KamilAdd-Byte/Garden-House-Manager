package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BasilTest {

   @Test
   @DisplayName("should have one description on basil herb")
    void getDescription() {
        //given
        Basil basil = new Basil();
        basil.setLight(Light.MEDIUM);
        Light light = basil.getLight();
        String description = basil.getDescription();
        //then
        assertNotNull(description);
        assertThat(description).endsWith("wilgotna. ");
        assertThat(light).isEqualTo(Light.MEDIUM);
    }

    @Test
    void setLight() {
    }

    @Test
    void getName() {
    }
}
