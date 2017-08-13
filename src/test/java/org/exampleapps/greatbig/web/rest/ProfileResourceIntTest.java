package org.exampleapps.greatbig.web.rest;

import org.exampleapps.greatbig.GreatBigExampleApplicationApp;

import org.exampleapps.greatbig.service.ProfileService;
import org.exampleapps.greatbig.web.rest.errors.ExceptionTranslator;
import org.exampleapps.greatbig.service.dto.ProfileDTO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ProfileResource REST controller.
 *
 * @see ProfileResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GreatBigExampleApplicationApp.class)
public class ProfileResourceIntTest {

    private static final String DEFAULT_USERNAME = "AAAAAAAAAA";
    private static final String UPDATED_USERNAME = "BBBBBBBBBB";

    private static final String DEFAULT_BIO = "AAAAAAAAAA";
    private static final String UPDATED_BIO = "BBBBBBBBBB";

    private static final String DEFAULT_IMAGE = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE = "BBBBBBBBBB";

    private static final Boolean DEFAULT_FOLLOWING = false;
    private static final Boolean UPDATED_FOLLOWING = true;

    private static final String NONEXISTENT_USERNAME = "XXXXXXXXXXX";

    @Autowired
    private ProfileService profileService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restProfileMockMvc;

    private ProfileDTO profile;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ProfileResource profileResource = new ProfileResource(profileService);
        this.restProfileMockMvc = MockMvcBuilders.standaloneSetup(profileResource)
                .setCustomArgumentResolvers(pageableArgumentResolver).setControllerAdvice(exceptionTranslator)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create a profile for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ProfileDTO createEntity(EntityManager em) {
        ProfileDTO profile = new ProfileDTO();
        profile.setUsername(DEFAULT_USERNAME);
        profile.setBio(DEFAULT_BIO);
        profile.setImage(DEFAULT_IMAGE);
        profile.setFollowing(DEFAULT_FOLLOWING);

        return profile;
    }

    @Before
    public void initTest() {
        profile = createEntity(em);
    }

    // This test requires almost complete reproduction of the app code.
    //
    // @Test
    // @Transactional
    // public void getProfile() throws Exception {
    //     User user = UserResourceIntTest.createEntity(em);
    //     user.setUsername(DEFAULT_USERNAME);
    //     user.setImage(DEFAULT_IMAGE);

    //     Author author = new Author()
    //         .bio(DEFAULT_BIO)
    //         .user(user);
    //     if(DEFAULT_FOLLOWING) {
    //         Optional<User> currentUser = userRepository.findOneByLogin(SecurityUtils.getCurrentUserLogin());
    //         Author currentUserAuthor = new Author().user(currentUser);
    //         author.addFollower(currentUserAuthor);
    //     }

    //     // Get the profile
    //     restProfileMockMvc.perform(get("/api/profiles/{username}", profile.getUsername())).andExpect(status().isOk())
    //             .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
    //             .andExpect(jsonPath("$.username").value(SecurityUtils.getCurrentUserLogin()))
    //             .andExpect(jsonPath("$.bio").value(DEFAULT_BIO.toString()))
    //             .andExpect(jsonPath("$.image").value(DEFAULT_IMAGE.toString()))
    //             .andExpect(jsonPath("$.following").value(DEFAULT_FOLLOWING.booleanValue()));
    // }

    // @Test
    // @Transactional
    // public void getNonExistingProfile() throws Exception {
    //     // Get the profile
    //     restProfileMockMvc.perform(get("/api/profiles/{username}", NONEXISTENT_USERNAME)).andExpect(status().isNotFound());
    // }

    // @Test
    // @Transactional
    // public void followUser() throws Exception {

    //     // Follow user
    //     restProfileMockMvc.perform(post("/api/profiles/{username}/follow", profile.getUsername())).andExpect(status().isOk())
    //             .andExpect(jsonPath("$.following").value(true));
    // }

    // @Test
    // @Transactional
    // public void unfollowUser() throws Exception {

    //     // Unfollow user
    //     restProfileMockMvc.perform(post("/api/profiles/{username}/unfollow", profile.getUsername())).andExpect(status().isOk())
    //             .andExpect(jsonPath("$.following").value(false));
    // }

    @Test
    @Transactional
    public void followNonExistingUser() throws Exception {
        // int databaseSizeBeforeUpdate = profileRepository.findAll().size();

        // restProfileMockMvc.perform(post("/api/profiles/{username}/follow", profile.getUsername())).andExpect(status().isOk());

        // Validate the change to the database
        // List<Profile> profileList = profileRepository.findAll();
        // assertThat(profileList).hasSize(databaseSizeBeforeUpdate + 1);
    }
}
