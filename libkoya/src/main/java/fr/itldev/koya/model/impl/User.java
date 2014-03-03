/**
 * Koya is an alfresco module that provides a corporate orientated dataroom.
 *
 * Copyright (C) Itl Developpement 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see `<http://www.gnu.org/licenses/>`.
 */

package fr.itldev.koya.model.impl;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.web.client.RestTemplate;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class User {

    @JsonProperty("userName")
    private String login;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String name;
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    private String password;

    private Capabilities capabilities;
    private String ticketAlfresco;
    private Preferences preferences;

    private RestTemplate restTemplate;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }
    //---

    public String getTicketAlfresco() {
        return ticketAlfresco;
    }

    public void setTicketAlfresco(String ticketAlfresco) {
        this.ticketAlfresco = ticketAlfresco;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean isAdmin() {
        return capabilities.getIsAdmin();
    }

    public static class Capabilities {

        private Boolean isMutable;
        private Boolean isGuest;
        private Boolean isAdmin;

        public Boolean getIsMutable() {
            return isMutable;
        }

        public void setIsMutable(Boolean isMutable) {
            this.isMutable = isMutable;
        }

        public Boolean getIsGuest() {
            return isGuest;
        }

        public void setIsGuest(Boolean isGuest) {
            this.isGuest = isGuest;
        }

        public Boolean getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(Boolean isAdmin) {
            this.isAdmin = isAdmin;
        }

    }
}