package org.onehippo.example.componentsinfo;

import org.hippoecm.hst.core.parameters.Parameter;

public interface GreetingsInfo {

    @Parameter(name = "description", displayName = "The description of the application", defaultValue="Greetings Application")
    String getDescription();

    @Parameter(name = "url", displayName = "The url of the application", defaultValue="")
    String getUrl();


}
