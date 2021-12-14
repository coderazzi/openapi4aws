package net.coderazzi.openapi4aws.arguments;

import net.coderazzi.openapi4aws.O4A_Exception;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Authorizer {

    private final static Map<Object, Object> AUTHORIZER_FLOWS = Collections.emptyMap();
    private final static String AUTHORIZATION_TYPE = "oauth2";
    private final static String AUTHORIZER_TYPE = "jwt";

    private final Authorizer defaultAuthorizer;
    private final Map<Object, Object> flows = AUTHORIZER_FLOWS;
    private String identitySource;
    private String issuer;
    private List<String> audiences;
    private String authorizationType;
    private String authorizerType;

    public Authorizer(Authorizer defaultAuthorizer) {
        this.defaultAuthorizer = defaultAuthorizer;
    }

    public String getIdentitySource() {
        return identitySource == null && defaultAuthorizer != null ? defaultAuthorizer.getIdentitySource() : identitySource;
    }

    public void setIdentitySource(String identitySource) {
        checkUnspecified(this.identitySource);
        this.identitySource = identitySource;
    }

    public String getIssuer() {
        return issuer == null && defaultAuthorizer != null ? defaultAuthorizer.getIssuer() : issuer;
    }

    public void setIssuer(String issuer) {
        checkUnspecified(this.issuer);
        this.issuer = issuer;
    }

    public List<String> getAudiences() {
        return audiences == null && defaultAuthorizer != null ? defaultAuthorizer.getAudiences() : audiences;
    }

    public void setAudiences(List<String> audiences) {
        checkUnspecified(this.audiences);
        this.audiences = audiences;
    }

    public Map<Object, Object> getFlows() {
        return flows;
    }

    public String getAuthorizationType() {
        return AUTHORIZATION_TYPE;
    }

    public void setAuthorizationType(String authorizationType) {
        checkUnspecified(this.authorizationType);
        if (AUTHORIZATION_TYPE.equals(authorizationType)) {
            throw new O4A_Exception(authorizationType + " : not a valid authorization type");
        }
        this.authorizationType = authorizationType;
    }

    public String getAuthorizerType() {
        return AUTHORIZER_TYPE;
    }

    public void setAuthorizerType(String authorizerType) {
        checkUnspecified(this.authorizerType);
        if (AUTHORIZER_TYPE.equals(authorizationType)) {
            throw new O4A_Exception(authorizationType + " : not a valid authorizer type");
        }
        this.authorizerType = authorizerType;
    }

    private void checkUnspecified(Object x) {
        if (x != null) throw O4A_Exception.duplicatedArgument();
    }
}