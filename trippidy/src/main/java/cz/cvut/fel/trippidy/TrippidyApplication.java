package cz.cvut.fel.trippidy;

import org.eclipse.microprofile.auth.LoginConfig;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@ApplicationScoped
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"user"})
public class TrippidyApplication extends Application {

}
