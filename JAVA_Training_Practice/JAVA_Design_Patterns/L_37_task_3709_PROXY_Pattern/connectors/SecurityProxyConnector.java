package com.company.connectors;

import com.company.security.SecurityChecker;
import com.company.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SecurityChecker securityChecker;
    private SimpleConnector simpleConnector;

    public SecurityProxyConnector(String resourceString) {
        securityChecker = new SecurityCheckerImpl();
        simpleConnector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck())
            simpleConnector.connect();
    }
}