

package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

public class DelegatingFilterProxy extends GenericFilterBean
{
    
    private String contextAttribute;
    
    private WebApplicationContext webApplicationContext;
    
    private String targetBeanName;
    
    private boolean targetFilterLifecycle = false;
    
    private volatile Filter delegate;
    
    private final Object delegateMonitor = new Object();
    
    
    
    public DelegatingFilterProxy() {
    
        System.out.println("我现在没有给赋值名字啊0:" + targetBeanName);
    }
    
    public DelegatingFilterProxy(Filter delegate) {
    
        System.out.println("我现在没有给赋值名字啊1`:" + targetBeanName);

        Assert.notNull(delegate, "delegate Filter object must not be null");
        this.delegate = delegate;
    }
    
    public DelegatingFilterProxy(String targetBeanName) {
        
        this(targetBeanName, null);
        System.out.println("我现在没有给赋值名字啊1:" + targetBeanName);
    
    }
    
    public DelegatingFilterProxy(String targetBeanName, WebApplicationContext wac) {
        System.out.println("我现在没有给赋值名字啊2:" + targetBeanName);
    
    
        Assert.hasText(targetBeanName, "target Filter bean name must not be null or empty");
        this.setTargetBeanName(targetBeanName);
        this.webApplicationContext = wac;
        if (wac != null) {
            this.setEnvironment(wac.getEnvironment());
        }
    }
    
    public void setContextAttribute(String contextAttribute) {
        this.contextAttribute = contextAttribute;
    }
    
    public String getContextAttribute() {
        return this.contextAttribute;
    }
    
    public void setTargetBeanName(String targetBeanName) {
        this.targetBeanName = targetBeanName;
    }
    
    protected String getTargetBeanName() {
        return this.targetBeanName;
    }
    
    public void setTargetFilterLifecycle(boolean targetFilterLifecycle) {
        this.targetFilterLifecycle = targetFilterLifecycle;
    }
    
    protected boolean isTargetFilterLifecycle() {
        return this.targetFilterLifecycle;
    }
    
    
    @Override
    protected void initFilterBean() throws ServletException {
        synchronized (this.delegateMonitor) {
            if (this.delegate == null) {
                // If no target bean name specified, use filter name.
                if (this.targetBeanName == null) {
                    this.targetBeanName = getFilterName();
                }
                // Fetch Spring root application context and initialize the delegate early,
                // if possible. If the root application context will be started after this
                // filter proxy, we'll have to resort to lazy initialization.
                WebApplicationContext wac = findWebApplicationContext();
                if (wac != null) {
                    this.delegate = initDelegate(wac);
                }
            }
        }
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        // Lazily initialize the delegate if necessary.
        Filter delegateToUse = this.delegate;
        if (delegateToUse == null) {
            synchronized (this.delegateMonitor) {
                if (this.delegate == null) {
                    WebApplicationContext wac = findWebApplicationContext();
                    if (wac == null) {
                        throw new IllegalStateException("No WebApplicationContext found: no ContextLoaderListener registered?");
                    }
                    this.delegate = initDelegate(wac);
                }
                delegateToUse = this.delegate;
            }
        }
        
        // Let the delegate perform the actual doFilter operation.
        invokeDelegate(delegateToUse, request, response, filterChain);
    }
    
    @Override
    public void destroy() {
        Filter delegateToUse = this.delegate;
        if (delegateToUse != null) {
            destroyDelegate(delegateToUse);
        }
    }
    
    
    protected WebApplicationContext findWebApplicationContext() {
        if (this.webApplicationContext != null) {
            // the user has injected a context at construction time -> use it
            if (this.webApplicationContext instanceof ConfigurableApplicationContext) {
                if (!((ConfigurableApplicationContext)this.webApplicationContext).isActive()) {
                    // the context has not yet been refreshed -> do so before returning it
                    ((ConfigurableApplicationContext)this.webApplicationContext).refresh();
                }
            }
            return this.webApplicationContext;
        }
        String attrName = getContextAttribute();
        if (attrName != null) {
            return WebApplicationContextUtils.getWebApplicationContext(getServletContext(), attrName);
        }
        else {
            return WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        }
    }
    
    protected Filter initDelegate(WebApplicationContext wac) throws ServletException {
        Filter delegate = wac.getBean(getTargetBeanName(), Filter.class);
        if (isTargetFilterLifecycle()) {
            delegate.init(getFilterConfig());
        }
        return delegate;
    }
    
    protected void invokeDelegate(
            Filter delegate, ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        delegate.doFilter(request, response, filterChain);
    }
    
    protected void destroyDelegate(Filter delegate) {
        if (isTargetFilterLifecycle()) {
            delegate.destroy();
        }
    }
    
}
