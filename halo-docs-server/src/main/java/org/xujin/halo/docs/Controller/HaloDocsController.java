package org.xujin.halo.docs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.xujin.halo.docs.DocsResource;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class HaloDocsController {

    private final RouteLocator routeLocator;

    @Autowired
    private DiscoveryClient client;


    public HaloDocsController(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @GetMapping("/docsMeteData")
    public List<DocsResource> addUser() {
        List<DocsResource> resources = new ArrayList<DocsResource>();
        List<Route> routes = routeLocator.getRoutes();
        //在这里遍历的时候，可以排除掉敏感微服务的路由
        routes.forEach(route -> resources.add(docsResource(route.getId(),
                route.getFullPath().replace("**", "docs"))));
        for (DocsResource dosc: resources) {
            List<String> ipList=new ArrayList<>();
            List<ServiceInstance> instances = client.getInstances(dosc.getName());
            for (int i = 0; i < instances.size(); i++) {
                ipList.add(instances.get(i).getHost()+":"+instances.get(i).getPort());
            }
            dosc.setInstanceInfoList(ipList);
        }
        return resources;

    }
    private DocsResource docsResource(String name, String location) {
        DocsResource swaggerResource = new DocsResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        return swaggerResource;
    }


}
