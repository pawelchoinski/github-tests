package org.pwl.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public String login;
    public int id;
}
