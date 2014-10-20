package org.dtelaroli.cms.backend;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.view.DefaultPathResolver;

@Specializes
public class VelocityPathResolver extends DefaultPathResolver {

	/**
	 * @deprecated CDI eyes-only
	 */
	protected VelocityPathResolver() {
	}

	@Inject
	protected VelocityPathResolver(FormatResolver resolver) {
		super(resolver);
	}

	@Override
	protected String getPrefix() {
		return "/WEB-INF/velocity/";
	}

	@Override
	protected String getExtension() {
		return "vm";
	}
}
