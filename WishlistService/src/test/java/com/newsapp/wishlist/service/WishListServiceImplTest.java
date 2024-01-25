//package com.newsapp.wishlist.service;
//
//import com.newsapp.wishlist.exception.NewsArticleAlreadyExists;
//import com.newsapp.wishlist.exception.NewsArticleNotFound;
//import com.newsapp.wishlist.model.WishList;
//import com.newsapp.wishlist.repository.WishlistRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//class WishListServiceImplTest {
//
//    @Mock
//    private WishlistRepository wishlistRepository;
//
//    @InjectMocks
//    private WishListServiceImpl wishListService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void saveNews_Success() {
//        WishList wishList = new WishList();
//        when(wishlistRepository.findById(any())).thenReturn(Optional.empty());
//        when(wishlistRepository.save(any(WishList.class))).thenReturn(wishList);
//
//        assertDoesNotThrow(() -> {
//            WishList savedWishList = wishListService.saveNews(wishList);
//            assertNotNull(savedWishList);
//        });
//    }
//
//    @Test
//    void saveNews_AlreadyExistsException() {
//        WishList existingWishList = new WishList();
//        when(wishlistRepository.findById(any())).thenReturn(Optional.of(existingWishList));
//
//        NewsArticleAlreadyExists exception = assertThrows(NewsArticleAlreadyExists.class, () -> {
//            wishListService.saveNews(existingWishList);
//        });
//
//        assertEquals("News Article Already Exists!!", exception.getMessage());
//    }
//
//    @Test
//    void getNewsById_Success() {
//        int id = 1;
//        WishList wishList = new WishList(/* construct your WishList object */);
//        when(wishlistRepository.findById(id)).thenReturn(Optional.of(wishList));
//
//        assertDoesNotThrow(() -> {
//            WishList foundWishList = wishListService.getNewsById(id);
//            assertNotNull(foundWishList);
//        });
//    }
//
//    @Test
//    void getNewsById_NotFoundException() {
//        int nonExistingId = 2;
//        when(wishlistRepository.findById(nonExistingId)).thenReturn(Optional.empty());
//
//        NewsArticleNotFound exception = assertThrows(NewsArticleNotFound.class, () -> {
//            wishListService.getNewsById(nonExistingId);
//        });
//
//        assertEquals("News Article Not Found!!", exception.getMessage());
//    }
//
//    @Test
//    void getAllNews_Success() {
//        List<WishList> wishLists = Collections.singletonList(new WishList(/* construct your WishList object */));
//        when(wishlistRepository.findAll()).thenReturn(wishLists);
//
//        List<WishList> result = wishListService.getAllNews();
//        assertNotNull(result);
//        assertEquals(1, result.size());
//    }
//
//    @Test
//    void deleteFavNews_Success() {
//        int id = 1;
//        when(wishlistRepository.findById(id)).thenReturn(Optional.of(new WishList(/* construct your WishList object */)));
//
//        assertDoesNotThrow(() -> {
//            String result = wishListService.deleteFavNews(id);
//            assertEquals("News Has been Deleted from Wishlist", result);
//        });
//    }
//
//    @Test
//    void deleteFavNews_NotFoundException() {
//        int nonExistingId = 2;
//        when(wishlistRepository.findById(nonExistingId)).thenReturn(Optional.empty());
//
//        NewsArticleNotFound exception = assertThrows(NewsArticleNotFound.class, () -> {
//            wishListService.deleteFavNews(nonExistingId);
//        });
//
//        assertEquals("News Article Not Found!!", exception.getMessage());
//    }
//}
