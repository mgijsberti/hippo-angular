package org.onehippo.example.beans;

import java.util.Calendar;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSetBean;

@Node(jcrType="hippoangular:newsdocument")
public class NewsDocument extends BaseDocument{

    public String getTitle() {
        return getProperty("hippoangular:title");
    }
    
    public String getSummary() {
        return getProperty("hippoangular:summary");
    }
    
    public Calendar getDate() {
        return getProperty("hippoangular:date");
    }

    public HippoHtml getHtml(){
        return getHippoHtml("hippoangular:body");    
    }

    /**
     * Get the imageset of the newspage
     *
     * @return the imageset of the newspage
     */
    public HippoGalleryImageSetBean getImage() {
        return getLinkedBean("hippoangular:image", HippoGalleryImageSetBean.class);
    }


}
