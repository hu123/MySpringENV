package filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProxyFilter implements Filter
{
    
    private List<? extends Filter> filters = new ArrayList<Filter>();
    
    public ProxyFilter()
    {
        
    }
    
    public ProxyFilter(List<? extends Filter> filters)
    {
        this.filters = new ArrayList<Filter>( filters );
    }
    
    
    public List<? extends Filter> getFilters()
    {
        return filters;
    }
    
    public void setFilters(List<? extends Filter> filters)
    {
        this.filters = filters;
    }
    
    @Override
    
    public void init(FilterConfig filterConfig) throws ServletException
    {
    
        System.out.println("额,这难道又是一个代理对象????" + filterConfig.getClass().getName());
        
        for(Filter filter : filters)
        {
            filter.init( filterConfig );
        }
        
        System.out.println( "proxyFilter初始化" + getFilters().size() );
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        new VirtualFilterChain( chain, filters ).doFilter( request, response );
        
        
        
        System.out.println( "proxyFilter的doFilter" );
    }
    
    @Override
    public void destroy()
    {
        
        for(int i = filters.size(); i-- > 0; )
        {
            Filter filter = filters.get( i );
            filter.destroy();
        }
        
        System.out.println( "proxyFilter毁灭" );
    }
    
    
    private static final class VirtualFilterChain implements FilterChain
    {
        private final FilterChain originalChain;
        private final List<? extends Filter> additionalFilters;
        private int currentPosition = 0;
        
        public VirtualFilterChain(FilterChain originalChain, List<? extends Filter> additionalFilters)
        {
            this.originalChain = originalChain;
            this.additionalFilters = additionalFilters;
        }
        
        
        @Override
        public void doFilter(final ServletRequest request,final  ServletResponse response) throws IOException, ServletException
        {
            if(currentPosition == additionalFilters.size())
            {
                originalChain.doFilter( request, response );
            }
            else
            {
                currentPosition++ ;
    
                Filter nextFilter = additionalFilters.get( currentPosition - 1 );
                nextFilter.doFilter( request, response, this );
    
            }
        }
        
    }
    
}
