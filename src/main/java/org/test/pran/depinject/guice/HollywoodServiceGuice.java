package org.test.pran.depinject.guice;

import org.test.pran.depinject.Agent;
import org.test.pran.depinject.AgentFinder;
import org.test.pran.depinject.HollywoodService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class HollywoodServiceGuice {
    private AgentFinder finder = null;

    @Inject public HollywoodServiceGuice(AgentFinder finder){
        this.finder = finder;
    }
    public List<Agent> getFriendlyAgents(){
        List<Agent> agents = this.finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents, "Java Developers");
        return friendlyAgents;
    }
    public List<Agent> filterAgents(List<Agent> agents, String agentType){
        List<Agent> filteredAgent = new ArrayList<Agent>();
        for(Agent agent: agents){
            if(agent.getType().equals(agentType))
                filteredAgent.add(agent);
        }
        return filteredAgent;
    }

}
