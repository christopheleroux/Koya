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
package fr.itldev.koya.webscript.user;

import fr.itldev.koya.alfservice.UserService;
import fr.itldev.koya.exception.KoyaServiceException;
import fr.itldev.koya.model.impl.User;
import fr.itldev.koya.model.json.ItlAlfrescoServiceWrapper;
import fr.itldev.koya.services.exceptions.KoyaErrorCodes;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.extensions.webscripts.AbstractWebScript;
import org.springframework.extensions.webscripts.WebScriptRequest;
import org.springframework.extensions.webscripts.WebScriptResponse;

/**
 * Modify user details
 */
public class ModifyDetails extends AbstractWebScript {

    private Logger logger = Logger.getLogger(this.getClass());

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @param req
     * @param res
     * @throws IOException
     */
    @Override
    public void execute(WebScriptRequest req, WebScriptResponse res) throws IOException {
        ItlAlfrescoServiceWrapper wrapper = new ItlAlfrescoServiceWrapper();

        try {

            ObjectMapper mapper = new ObjectMapper();
            User u = mapper.readValue(req.getContent().getReader(), User.class);
            userService.modifyUser(u);

            wrapper.setStatusOK();
        } catch (KoyaServiceException ex) {
            wrapper.setStatusFail(ex.toString());
            wrapper.setErrorCode(ex.getErrorCode());
        } catch (IOException ex) {
            wrapper.setStatusFail(ex.toString());
            wrapper.setErrorCode(KoyaErrorCodes.UNHANDLED);
        }

        res.setContentType("application/json");

        res.getWriter().write(wrapper.getAsJSON());
        logger.trace(wrapper.getAsJSON());
    }

}