package org.wso2.custom.saml.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;

/**
 * @scr.component name="SAMLAttributeModifierComponent" immediate="true"
 */
public class SAMLAttributeModifierComponent {

    private static final Log log = LogFactory.getLog(SAMLAttributeModifierComponent.class);

    protected void activate(ComponentContext context) {

        /**
         * Any logic which need to run during the bundle activation goes here.
         * Ex: Reading config file
         */

        log.info("SAMLAttributeModifierComponent bundle is activated");
    }

    protected void deactivate(ComponentContext context) {

        log.info("SAMLAttributeModifierComponent bundle is deactivated");
    }

}
