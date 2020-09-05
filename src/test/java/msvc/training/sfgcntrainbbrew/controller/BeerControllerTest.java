package msvc.training.sfgcntrainbbrew.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import msvc.training.sfgcntrainbbrew.model.Beer;
import msvc.training.sfgcntrainbbrew.service.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    Beer beer;

    @BeforeEach
    public void setUp(){
        beer = Beer.builder()
                .beerName("Heineken")
                .beerStyle("PILSNER")
                .upc(23667891L)
                .build();
    }


    @Test
    void testGetBeerById() throws Exception {

        given(beerService.getBeerById(any(UUID.class))).willReturn(beer);

        mockMvc.perform(get("/api/v1/beerService/" +
                UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testSaveBeer() throws Exception {
        //given
        Beer beerDto = beer;
        beerDto.setId(null);
        Beer newBeer = Beer.builder().id(UUID.randomUUID()).beerName("Amstel").build();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(any())).willReturn(newBeer);

        mockMvc.perform(post("/api/v1/beerService/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateBeerById() throws Exception {
        //given
        Beer beerDto = beer;
        beerDto.setId(null);
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        //when
        mockMvc.perform(put("/api/v1/beerService/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isNoContent());

        then(beerService).should().updateBeer(any(), any());
    }

}