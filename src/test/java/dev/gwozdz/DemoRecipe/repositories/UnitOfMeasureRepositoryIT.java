package dev.gwozdz.DemoRecipe.repositories;

import dev.gwozdz.DemoRecipe.model.UnitOfMeasure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    void findByDescriptionShouldFindValues() {
        //given
        //when
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("gram");
        //then
        assertThat(uomOptional.get().getDescription(), equalTo("gram"));
    }

    @Test
    void findByDescriptionShouldReturnEmptyWhenLookingForEmptyValue() {
        //given
        //when
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("");
        //then
        assertThat(uomOptional.isEmpty(), is(true));
    }

    @Test
    void findByDescriptionShouldReturnEmptyWhenLookingForNonExistingValue() {
        //given
        //when
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("gramy");
        //then
        assertThat(uomOptional.isEmpty(), is(true));
    }
}