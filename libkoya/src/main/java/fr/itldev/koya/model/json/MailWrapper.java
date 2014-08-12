package fr.itldev.koya.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * This object wraps an email to send.
 *
 *
 */
public class MailWrapper {

    private List<String> to = new ArrayList<>();
    private String from;
    private String subject;
    private String content;
    //template
    private String templateNodeRef;
    private String templateName;
    private Map<String, Serializable> templateParams = new HashMap<>();

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTemplateNodeRef() {
        return templateNodeRef;
    }

    public void setTemplateNodeRef(String templateNodeRef) {
        this.templateNodeRef = templateNodeRef;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Map<String, Serializable> getTemplateParams() {
        return templateParams;
    }

    public void setTemplateParams(Map<String, Serializable> templateParams) {
        this.templateParams = templateParams;
    }

    @Override
    public String toString() {
        String str = "";

        str += "from = " + from + ",";

        str += "to = [";
        String sep = "";
        for (String dest : to) {
            str += sep + dest;
            sep = ";";
        }
        str += "],";

        str += "subject = " + subject + ",";

        str += "content = " + content + ";";

        return str;
    }

    public void addDest(String mailAdress) {
        to.add(mailAdress);
    }

}