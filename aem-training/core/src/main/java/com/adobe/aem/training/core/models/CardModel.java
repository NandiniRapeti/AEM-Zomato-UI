package com.adobe.aem.training.core.models;
 
import java.util.Optional;
 
import javax.annotation.PostConstruct;
import javax.inject.Inject;
 
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
 
import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;
 
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CardModel {
     public static final String MODEL_TITLE = "CARD";
    public static final String CF_PATH = "/content/dam/aem-training/card";
 
    @Inject
    @Self
    private Resource resource;
 
    @Inject
    private ResourceResolver resourceResolver;
 
    private Optional<ContentFragment> contentFragment;
 
    @PostConstruct
    public void init() {
        Resource fragmentResource = resourceResolver.getResource(CF_PATH);
        contentFragment = Optional.ofNullable(fragmentResource.adaptTo(ContentFragment.class));
    }
 
    public String getBankName() {
        return contentFragment.map(cf -> cf.getElement("bankName")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }
 
    public String getCardType() {
        return contentFragment.map(cf -> cf.getElement("cardtype")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }
 
    public String getCardNumber() {
        return contentFragment.map(cf -> cf.getElement("cardNumber")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }
 
    public String getValidFrom() {
        return contentFragment.map(cf -> cf.getElement("VALID")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }
 
    public String getValidThru() {
        return contentFragment.map(cf -> cf.getElement("validThru")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }
 
    public String getAccountHolder() {
        return contentFragment.map(cf -> cf.getElement("accountHolder")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }
 
    public String getDebit() {
        return contentFragment.map(cf -> cf.getElement("Debit")).map(ContentElement::getContent)
                .orElse(StringUtils.EMPTY);
    }
}