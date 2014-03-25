package org.test.pran.depinject.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.test.pran.depinject.Agent;
import org.test.pran.depinject.HollywoodService;

import java.util.List;

/**
 * Created by pramodh on 3/12/14.
 */
public class HollywoodServiceClient {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AgentFinderModule());
        HollywoodServiceGuice hollywoodService = injector.getInstance(HollywoodServiceGuice.class);
        List<Agent> agents = hollywoodService.getFriendlyAgents();
    }
}
