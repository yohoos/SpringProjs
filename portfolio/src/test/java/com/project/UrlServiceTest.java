package com.project;

import com.project.models.Url;
import com.project.services.UrlService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UrlServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @Qualifier("urlService")
    private UrlService urlService;

    @Test
    public void checkHome() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString("Login")));
    }

    @Test
    public void checkUrlService() throws Exception {
        Iterable<Url> urls = urlService.findAll();
        List<Url> listUrls = new ArrayList<>();
        urls.forEach(url -> listUrls.add(url));
        Assert.assertTrue(listUrls.size() > 1);
    }
}
