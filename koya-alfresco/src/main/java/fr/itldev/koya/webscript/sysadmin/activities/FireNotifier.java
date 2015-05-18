package fr.itldev.koya.webscript.sysadmin.activities;

import java.io.IOException;
import java.util.Map;

import org.alfresco.repo.activities.feed.FeedNotifier;
import org.springframework.extensions.webscripts.AbstractWebScript;
import org.springframework.extensions.webscripts.WebScriptException;
import org.springframework.extensions.webscripts.WebScriptRequest;
import org.springframework.extensions.webscripts.WebScriptResponse;

import fr.itldev.koya.webscript.KoyaWebscript;

public class FireNotifier extends AbstractWebScript {

	private FeedNotifier feedNotifier;

	public void setFeedNotifier(FeedNotifier feedNotifier) {
		this.feedNotifier = feedNotifier;
	}

	@Override
	public void execute(WebScriptRequest req, WebScriptResponse res)
			throws IOException {
		feedNotifier.execute(0);
		res.setContentType("application/json");
		res.getWriter().write("");

	}

}