package fr.skytech.application.context;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.DefaultRedirectStrategy;

public class QueryStringPropagateRedirectStrategy extends
		DefaultRedirectStrategy {

	@Override
	public void sendRedirect(final HttpServletRequest request,
			final HttpServletResponse response, final String url)
			throws IOException {
		final String urlWithOriginalQueryString = url + "?error=login.error";
		super.sendRedirect(request, response, urlWithOriginalQueryString);
	}
}