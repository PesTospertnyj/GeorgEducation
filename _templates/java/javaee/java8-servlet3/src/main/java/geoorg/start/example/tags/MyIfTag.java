package geoorg.start.example.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * Created by gaw on 7/3/2018.
 */
public class MyIfTag implements Tag {
    private PageContext pageContext;
    private Tag parent;

    private boolean test;

    @Override
    public void setPageContext(final PageContext pc) {
        this.pageContext = pc;
    }

    @Override
    public void setParent(final Tag t) {
        this.parent = t;
    }

    @Override
    public Tag getParent() {
        return parent;
    }

    @Override
    public int doStartTag() throws JspException {
        if (test) {
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public void release() {

    }

    public boolean isTest() {
        return test;
    }

    public void setTest(final boolean test) {
        this.test = test;
    }
}
