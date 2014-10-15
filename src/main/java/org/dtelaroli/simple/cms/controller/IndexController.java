package org.dtelaroli.simple.cms.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

import javax.inject.Inject;

/**
 * Created by denilson on 14/10/14.
 */
@Controller
public class IndexController {

    private final Result result;

    /**
     * @deprecated
     */
    protected IndexController() {
        this(null);
    }

    @Inject
    public IndexController(Result result) {
        this.result = result;
    }

    public void index() {

    }
}
