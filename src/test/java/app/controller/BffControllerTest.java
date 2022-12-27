package app.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BffController.class)
public class BffControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllFairs() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fairs"))
                .andExpect(status().isOk());
    }


    @Test
    public void getAllFairsByWeekday() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fairs/{weekday}", "Domingo"))
                .andExpect(status().isOk());
    }

}
