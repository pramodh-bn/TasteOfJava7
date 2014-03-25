package org.test.pran.depinject.guice;

import com.google.inject.AbstractModule;
import org.test.pran.depinject.AgentFinder;
import org.test.pran.depinject.SpreadsheetAgentFinder;
import org.test.pran.depinject.WebserviceAgentFinder;

public class AgentFinderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AgentFinder.class).to(SpreadsheetAgentFinder.class);
        //bind(AgentFinder.class).to(WebserviceAgentFinder.class);
    }
}
