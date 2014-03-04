/**
 * Koya is an alfresco module that provides a corporate orientated dataroom.
 *
 * Copyright (C) Itl Developpement 2014
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see `<http://www.gnu.org/licenses/>`.
 */
package fr.itldev.koya.webscript.global;

import fr.itldev.koya.alfservice.KoyaNodeService;
import fr.itldev.koya.model.json.ItlAlfrescoServiceWrapper;
import fr.itldev.koya.webscript.KoyaWebscript;
import java.util.Map;
import org.alfresco.service.cmr.security.AuthenticationService;

/**
 * Get Users favourites
 *
 */
public class GetFavourites extends KoyaWebscript {

    private KoyaNodeService koyaNodeService;
    private AuthenticationService authenticationService;

    public void setKoyaNodeService(KoyaNodeService koyaNodeService) {
        this.koyaNodeService = koyaNodeService;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public ItlAlfrescoServiceWrapper koyaExecute(
            ItlAlfrescoServiceWrapper wrapper, Map<String, String> urlParams,
            Map<String, Object> jsonPostMap) throws Exception {
        wrapper.addItems(koyaNodeService.getFavourites(authenticationService.getCurrentUserName()));
        return wrapper;
    }

}
