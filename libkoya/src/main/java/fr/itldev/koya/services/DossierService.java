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
package fr.itldev.koya.services;

import fr.itldev.koya.model.impl.Dossier;
import fr.itldev.koya.model.impl.Space;
import fr.itldev.koya.model.impl.User;
import fr.itldev.koya.services.exceptions.AlfrescoServiceException;
import java.util.List;
import org.springframework.core.io.Resource;

public interface DossierService extends AlfrescoService {

    /**
     * Creates a new Dossier
     *
     * @param user
     * @param dossier
     * @param parentSpace
     * @return
     * @throws AlfrescoServiceException
     */
    Dossier create(User user, Dossier dossier, Space parentSpace) throws AlfrescoServiceException;

    /**
     * Creates a new Dossier with content in a zip file
     *
     * @param user
     * @param dossier
     * @param parentSpace
     * @param zipFile
     * @return
     * @throws AlfrescoServiceException
     */
    Dossier create(User user, Dossier dossier, Space parentSpace, Resource zipFile) throws AlfrescoServiceException;

    /**
     *
     * @param user
     * @param dossier
     * @return
     * @throws AlfrescoServiceException
     */
    Dossier edit(User user, Dossier dossier) throws AlfrescoServiceException;

    /**
     * List all Space Dossiers
     *
     * @param user
     * @param space
     * @param filter
     * @return
     * @throws AlfrescoServiceException
     */
    List<Dossier> list(User user, Space space, String... filter) throws AlfrescoServiceException;

    /**
     * List all users in charge of specified Dossier.
     *
     * @param user
     * @param dossier
     * @return
     * @throws AlfrescoServiceException
     */
    List<User> listResponsibles(User user, Dossier dossier) throws AlfrescoServiceException;

    /**
     * List all users members of specified Dossier.
     *
     * @param user
     * @param dossier
     * @return
     * @throws AlfrescoServiceException
     */
    List<User> listMembers(User user, Dossier dossier) throws AlfrescoServiceException;

    /**
     * Adds a user in charge of specified Dossier.
     *
     * @param user
     * @param dossier
     * @param responsible
     * @throws AlfrescoServiceException
     */
    void addResponsible(User user, Dossier dossier, User responsible) throws AlfrescoServiceException;

    /**
     * Adds a user member of specified Dossier.
     *
     * @param user
     * @param dossier
     * @param responsible
     * @throws AlfrescoServiceException
     */
    void addMember(User user, Dossier dossier, User responsible) throws AlfrescoServiceException;

    /**
     * Add a list of users in charge of specified Dossier.
     *
     * @param user
     * @param dossier
     * @param responsibles
     * @throws AlfrescoServiceException
     */
    void addResponsible(User user, Dossier dossier, List<User> responsibles) throws AlfrescoServiceException;

    /**
     * Removes any collaborator role set on dossier.
     *
     * @param user
     * @param dossier
     * @param collaborator
     * @throws AlfrescoServiceException
     */
    void removeKoyaCollaboratorRole(User user, Dossier dossier, User collaborator) throws AlfrescoServiceException;

    /**
     * Remove user member or responsible of specified Dossier.
     *
     * @param user
     * @param dossier
     * @param memberOrResp
     * @throws AlfrescoServiceException
     */
    void delMemberOrResponsible(User user, Dossier dossier, User memberOrResp) throws AlfrescoServiceException;

}
