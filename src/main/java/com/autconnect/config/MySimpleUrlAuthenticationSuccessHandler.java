package com.autconnect.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	protected Log logger = LogFactory.getLog(this.getClass());
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);
	}
	protected void handle(HttpServletRequest request, 
		      HttpServletResponse response, Authentication authentication)
		      throws IOException {
		  
		        String targetUrl = determineTargetUrl(authentication);
		 
		        if (response.isCommitted()) {
		            logger.debug(
		              "Response has already been committed. Unable to redirect to "
		              + targetUrl);
		            return;
		        }
		 
		        redirectStrategy.sendRedirect(request, response, targetUrl);
		    }
	
	protected String determineTargetUrl(final Authentication authentication) {
        boolean isSupervisor = false;
        boolean isTherapist = false;
        boolean isParent = false;
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        for (final GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_SUPERVISOR")) {
                isSupervisor = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_THERAPIST")) {
                isTherapist = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_PARENT")) {
                isParent = true;
                break;
            }
        }

        if (isSupervisor) {
            return "/supervisor";
        } else if (isTherapist) {
            return "/therapist";
        } else if (isParent) {
            return "/parent";
        }
        else {
            throw new IllegalStateException();
        }
    }

    /**
     * Removes temporary authentication-related data which may have been stored in the session
     * during the authentication process.
     */
    protected final void clearAuthenticationAttributes(final HttpServletRequest request) {
        final HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
