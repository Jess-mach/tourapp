package br.com.tourapp.dto.response;


import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder(toBuilder = true)
public record UserInfoResponse(
    UUID id,
    String email,
    String fullName,
    String profilePicture,
    LocalDateTime createdAt,
    LocalDateTime lastLogin,
    List<String> roles,
    String subscriptionPlan,
    LocalDateTime subscriptionExpiry,
    boolean hasActiveSubscription
) {

}