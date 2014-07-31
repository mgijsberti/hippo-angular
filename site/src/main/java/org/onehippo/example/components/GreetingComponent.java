package org.onehippo.example.components;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.onehippo.example.componentsinfo.GreetingsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ParametersInfo(type = GreetingsInfo.class)
public class GreetingComponent extends BaseComponent {
    public static final Logger log = LoggerFactory.getLogger(GreetingComponent.class);

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) throws HstComponentException {

        GreetingsInfo greetingsInfo = getComponentParametersInfo(request);

        String description = greetingsInfo.getDescription();
        if(StringUtils.isEmpty(description)){
            log.warn("Description is empty");
            request.setAttribute("description",StringUtils.EMPTY);
        } else {
            request.setAttribute("description",description);
        }


        String url = greetingsInfo.getUrl();
        if(StringUtils.isEmpty(url)){
            log.warn("No url configured, no service bound to application");
            request.setAttribute("url",StringUtils.EMPTY);
        } else {
            request.setAttribute("url", url);
        }

    }
}
