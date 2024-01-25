package com.newsapp.wishlist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsapp.wishlist.model.WishList;
import com.newsapp.wishlist.service.WishListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class WishListControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WishListService wishListService;

    @InjectMocks
    private WishListController wishListController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(wishListController).build();
    }

    @Test
    void saveNews_Success() throws Exception {
        WishList wishList = new WishList();
        when(wishListService.saveNews(any(WishList.class))).thenReturn(wishList);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v4/addFavNews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(wishList)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getFavNewsById_Success() throws Exception {
        int id = 1;
        WishList wishList = new WishList(/* construct your WishList object */);
        when(wishListService.getNewsById(id)).thenReturn(wishList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v4/getFavNewsById/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllFavNews_Success() throws Exception {
        List<WishList> wishLists = Collections.singletonList(new WishList());
        when(wishListService.getAllNews()).thenReturn(wishLists);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v4/GetAllFavNews"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteNewsById_Success() throws Exception {
        int id = 1;
        when(wishListService.deleteFavNews(id)).thenReturn("News Has been Deleted from Wishlist");

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v4/deleteNews/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
