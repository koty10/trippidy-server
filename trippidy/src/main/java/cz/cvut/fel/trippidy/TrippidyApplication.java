package cz.cvut.fel.trippidy;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
@ApplicationScoped
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"user"})
public class TrippidyApplication extends Application {

}