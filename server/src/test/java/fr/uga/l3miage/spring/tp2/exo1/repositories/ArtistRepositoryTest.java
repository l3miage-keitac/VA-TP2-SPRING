package fr.uga.l3miage.spring.tp2.exo1.repositories;

import fr.uga.l3miage.exo1.enums.GenreMusical;
import fr.uga.l3miage.spring.tp2.exo1.models.ArtistEntity;
import fr.uga.l3miage.spring.tp2.exo1.repositories.ArtistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
public class ArtistRepositoryTest {
    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void testRequestCountByGenreMusicalEquals(){
        ArtistEntity artist1 = ArtistEntity
                .builder()
                .name("artist 1")
                .biography("biographie 1")
                .genreMusical(GenreMusical.RAP)
                .build();

        ArtistEntity artist2 = ArtistEntity
                .builder()
                .name("artist 2")
                .biography("biographie 2")
                .genreMusical(GenreMusical.RAP)
                .build();

        artistRepository.save(artist1);
        artistRepository.save(artist2);

        //when
        int artistEntitiesResponses = artistRepository.countByGenreMusicalEquals(GenreMusical.RAP);

        //then
        assertThat(artistEntitiesResponses).isEqualTo(2);
       // assertThat(artistEntitiesResponses.stream().findFirst().get().getMail()).isEqualTo("test@gmail.com");

    }
}
