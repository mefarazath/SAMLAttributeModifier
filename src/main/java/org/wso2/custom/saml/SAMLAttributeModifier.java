package org.wso2.custom.saml;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.opensaml.saml2.core.Assertion;
import org.wso2.carbon.identity.application.authentication.framework.model.AuthenticatedUser;
import org.wso2.carbon.identity.application.common.model.ClaimMapping;
import org.wso2.carbon.identity.base.IdentityException;
import org.wso2.carbon.identity.sso.saml.builders.assertion.DefaultSAMLAssertionBuilder;
import org.wso2.carbon.identity.sso.saml.dto.SAMLSSOAuthnReqDTO;

import java.util.Map;

/**
 * This class convert attributes in the SAML response to lower case.
 */
public class SAMLAttributeModifier extends DefaultSAMLAssertionBuilder {

    private static final Log log = LogFactory.getLog(SAMLAttributeModifier.class);

    @Override
    public Assertion buildAssertion(SAMLSSOAuthnReqDTO authReqDTO, DateTime notOnOrAfter, String sessionId) throws
            IdentityException {

        // Get authenticated user
        AuthenticatedUser authenticatedUser = authReqDTO.getUser();

        if (authenticatedUser != null && authenticatedUser.getUserAttributes() != null && !authenticatedUser
                .getUserAttributes().isEmpty()) {

            for (Map.Entry<ClaimMapping, String> claimEntry : authenticatedUser.getUserAttributes().entrySet()) {
                if (!StringUtils.isBlank(claimEntry.getValue())) {
                    // Convert attribute values to lower case
                    claimEntry.setValue(claimEntry.getValue().toLowerCase());
                }
            }
        }

        return super.buildAssertion(authReqDTO, notOnOrAfter, sessionId);
    }

}
