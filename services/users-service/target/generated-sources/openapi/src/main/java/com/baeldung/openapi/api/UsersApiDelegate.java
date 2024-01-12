package com.baeldung.openapi.api;

import com.baeldung.openapi.model.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link UsersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-12T04:00:55.260999500+02:00[Africa/Johannesburg]")
public interface UsersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /users : Add a new user
     *
     * @param user  (required)
     * @return User added successfully (status code 201)
     *         or Bad request (status code 400)
     * @see UsersApi#addUser
     */
    default ResponseEntity<Void> addUser(User user) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /users/{userId} : Delete user by ID
     * Deletes a user from the system. Note that this is not reversible!
     *
     * @param userId ID of the user (required)
     * @return User deleted successfully (status code 204)
     *         or User not found (status code 404)
     * @see UsersApi#deleteUser
     */
    default ResponseEntity<Void> deleteUser(Integer userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /users/{userId} : Get user details by ID
     * Returns detailed information about a specific user.
     *
     * @param userId ID of the user (required)
     * @return Successful response (status code 200)
     * @see UsersApi#getUserById
     */
    default ResponseEntity<Void> getUserById(Integer userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /users : Get a list of users
     *
     * @return Successful response (status code 200)
     * @see UsersApi#getUsers
     */
    default ResponseEntity<Void> getUsers() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /users/{userId} : Update user details by ID
     * Updates an existing user with new data.
     *
     * @param userId ID of the user (required)
     * @param user  (required)
     * @return User updated successfully (status code 200)
     *         or Bad request (status code 400)
     * @see UsersApi#updateUser
     */
    default ResponseEntity<Void> updateUser(Integer userId,
        User user) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
