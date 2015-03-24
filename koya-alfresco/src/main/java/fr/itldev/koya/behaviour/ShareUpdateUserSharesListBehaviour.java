package fr.itldev.koya.behaviour;

import org.alfresco.repo.policy.Behaviour;
import org.alfresco.repo.policy.JavaBehaviour;
import org.alfresco.repo.policy.PolicyComponent;
import org.alfresco.service.cmr.repository.NodeRef;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.itldev.koya.alfservice.UserService;
import fr.itldev.koya.model.KoyaModel;
import fr.itldev.koya.model.impl.User;
import fr.itldev.koya.policies.SharePolicies;

public class ShareUpdateUserSharesListBehaviour implements
		SharePolicies.AfterSharePolicy, SharePolicies.AfterUnsharePolicy {

	protected static Log logger = LogFactory
			.getLog(ShareUpdateUserSharesListBehaviour.class);

	private UserService userService;
	private PolicyComponent policyComponent;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setPolicyComponent(PolicyComponent policyComponent) {
		this.policyComponent = policyComponent;
	}

	public void init() {
		this.policyComponent.bindClassBehaviour(
				SharePolicies.AfterSharePolicy.QNAME, KoyaModel.TYPE_DOSSIER,
				new JavaBehaviour(this, "afterShareItem",
						Behaviour.NotificationFrequency.TRANSACTION_COMMIT));

		this.policyComponent.bindClassBehaviour(
				SharePolicies.AfterUnsharePolicy.QNAME, KoyaModel.TYPE_DOSSIER,
				new JavaBehaviour(this, "afterUnshareItem",
						Behaviour.NotificationFrequency.TRANSACTION_COMMIT));
	}

	@Override
	public void afterShareItem(NodeRef nodeRef, String userMail, User inviter,
			Boolean sharedByImporter) {
		userService.addSharedNode(userMail, nodeRef);
	}

	@Override
	public void afterUnshareItem(NodeRef nodeRef, String userMail, User inviter) {
		userService.removeSharedNode(userMail, nodeRef);
	}

}
