package fr.itldev.koya.behaviour;

import fr.itldev.koya.alfservice.KoyaAclService;
import fr.itldev.koya.exception.KoyaServiceException;
import fr.itldev.koya.model.KoyaModel;
import java.util.logging.Level;
import org.alfresco.repo.node.NodeServicePolicies;
import org.alfresco.repo.policy.Behaviour;
import org.alfresco.repo.policy.JavaBehaviour;
import org.alfresco.repo.policy.PolicyComponent;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.apache.log4j.Logger;

/**
 * Apply default ACL on objects of type Space or Dossier on node creation
 *
 */
public class DefaultAclOnCreateBehaviour implements NodeServicePolicies.OnCreateNodePolicy {

    private final Logger logger = Logger.getLogger(this.getClass());
    private Behaviour onCreateNode;
    private PolicyComponent policyComponent;
    private KoyaAclService koyaAclService;

    public void setPolicyComponent(PolicyComponent policyComponent) {
        this.policyComponent = policyComponent;
    }

    public void setKoyaAclService(KoyaAclService koyaAclService) {
        this.koyaAclService = koyaAclService;
    }

    public void init() {
        // Create behaviours
        this.onCreateNode = new JavaBehaviour(this, "onCreateNode", Behaviour.NotificationFrequency.TRANSACTION_COMMIT);
        this.policyComponent.bindClassBehaviour(NodeServicePolicies.OnCreateNodePolicy.QNAME, KoyaModel.TYPE_DOSSIER,
                this.onCreateNode);

        this.policyComponent.bindClassBehaviour(NodeServicePolicies.OnCreateNodePolicy.QNAME, KoyaModel.TYPE_SPACE,
                this.onCreateNode);

    }

    @Override
    public void onCreateNode(ChildAssociationRef childAssocRef) {
        try {
            koyaAclService.setSpaceDossierDefaultAccess(childAssocRef.getChildRef());
        } catch (KoyaServiceException ex) {
            logger.error(ex.toString());
        }
    }
}
