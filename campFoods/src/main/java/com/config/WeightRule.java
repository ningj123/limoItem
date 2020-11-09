package com.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.alibaba.nacos.common.utils.StringUtils;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName WeightRule
 * @Author shadow
 * @Date 2020/11/9 15:33
 * @Description TODO
 **/
public class WeightRule extends AbstractLoadBalancerRule {
    //注入当前服务的信息对象
    @Resource
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    //注入服务管理对象
    @Resource
    private NacosServiceManager nacosServiceManager;

    @Override
    public Server choose(Object key) {
        //获取当前服务的名字
        BaseLoadBalancer balancer = (BaseLoadBalancer) this.getLoadBalancer();
        String name = balancer.getName();
        //获取当前服务的集群
        String clusterName = nacosDiscoveryProperties.getClusterName();
        //获取注册对象
        NamingService ns = nacosServiceManager.getNamingService(nacosDiscoveryProperties.getNacosProperties());
        //获取所有实例对象
        Instance instance = null;
        try {
            List<Instance> instances = ns.selectInstances(name, true);
            List<Instance> collect = instances.stream().filter(ins ->{
                return StringUtils.isEmpty(clusterName)&& StringUtils.isEmpty(name)&&clusterName.equals(name);
            }).collect(Collectors.toList());
            collect=collect==null||collect.size()<=0?instances:collect;
            instance = MyWeight.getWeight(collect);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return new NacosServer(instance);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
    static class MyWeight extends Balancer{
        public static Instance getWeight(List<Instance> hosts) {
            return Balancer.getHostByRandomWeight(hosts);
        }
    }
}
