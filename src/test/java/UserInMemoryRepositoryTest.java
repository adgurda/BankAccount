
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserInMemoryRepositoryTest {


    @Test
    void should_save_user(){
        //given
        UserRepository userInMemoryRepository = new UserInMemoryRepository(new HashMap<Integer, User>());
        User user = new User(1, "admam", "472638746");
        //when
        User result = userInMemoryRepository.save(user);
        //then
        Assertions.assertThat(result).isEqualTo(user);
        boolean areEquals = user.equals(result);
        Assertions.assertThat(areEquals).isTrue();
    }

    @Test
    void should_return_user_by_id(){
        //given
        HashMap<Integer, User> mapa = new HashMap<Integer, User>();
        UserRepository userInMemoryRepository = new UserInMemoryRepository(mapa);
        User user = new User(1, "admam", "472638746");
        userInMemoryRepository.save(user);
        //when
        User result = userInMemoryRepository.getById(user.getId());
        //then
        Assertions.assertThat(result).isEqualTo(user);
        Assertions.assertThat(mapa.containsKey(user.getId())).isTrue();
    }


    @Test
    void should_delete_user(){
        //given
        HashMap<Integer, User> mapa = new HashMap<>();
        User user = new User(1, "adrian", "345678901");
        UserRepository userMemoryRepository = new UserInMemoryRepository(mapa);
        userMemoryRepository.delete(user);
        //when
        User result = userMemoryRepository.getById(user.getId());
        //then
        Assertions.assertThat(result).isNotEqualTo(user);
        Assertions.assertThat(mapa.containsKey(user.getId())).isFalse();
    }

}