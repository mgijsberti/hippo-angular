package org.onehippo.example.beans;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;

@Node(jcrType="hippoangular:textdocument")
public class TextDocument extends BaseDocument{
    
    public String getTitle() {
        return getProperty("hippoangular:title");
    }

    public String getSummary() {
        return getProperty("hippoangular:summary");
    }
    
    public HippoHtml getHtml(){
        return getHippoHtml("hippoangular:body");    
    }

}
