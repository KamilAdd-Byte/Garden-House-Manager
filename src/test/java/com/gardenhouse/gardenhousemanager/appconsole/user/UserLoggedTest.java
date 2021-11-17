package com.gardenhouse.gardenhousemanager.appconsole.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserLoggedTest {

    @Test
    @DisplayName("should get login for new create UserLogged")
    void shouldGetLoginForNewUserLogged() {
        //given
        UserLogged user = createUser();
        //then
        assertNotNull(user);
        assertThat(user.getLogin()).isEqualTo("KamilLogin");
    }

    @Test
    @DisplayName("should get name for UserLogged is username")
    void shouldGetNameForUserLoggedIsNameUser() {
        //given
        UserLogged user = createUser();
        //then
        assertThat(user.getName()).as("Check name for inheritance").isEqualTo("Kamil");
    }


    @Test
    @DisplayName("should method loggedDisplay in UserLogged get return user login")
    void shouldMethodLoggedDisplayInUserLoggedReturnUserLogin() {
        //given
        UserLogged user = createUser();
        String loggedDisplay = user.loggedDisplay();
        //then
        assertThat(loggedDisplay).isEqualTo("Konto: " + user.getLogin());

    }

    private UserLogged createUser() {
        UserLogged user = new UserLogged();
        user.setName("Kamil");
        user.setLogin("KamilLogin");
        user.setPassword("KamilPassword");
        return user;
    }
}
