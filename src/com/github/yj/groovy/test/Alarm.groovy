package com.github.yj.groovy.test

import com.alibaba.appengine.monitor.domain.AlarmDataDO
import com.google.common.base.Predicate
import com.google.common.collect.Collections2
import com.sun.istack.internal.Nullable

/**
 * Created by yijun.yj on 2015/8/16.
 */
class Alarm {

    def String alarmJson(String type, List<AlarmDataDO> alarmList) {

        def list = alarmList;
        def result
        if(type == "docker")
            result = list.findAll {it.type == "docker"}
        else if(type == "non-docker")
            result = list.findAll {it.type == "non-docker"}
        else
            result = list

        return result.toString()

    }

    public static void main(String[] args){
        Alarm a = new Alarm()
        List<AlarmDataDO> alarmList = new LinkedList<>()

        AlarmDataDO d = new AlarmDataDO()
        d.type = "docker"
        d.alarmType = "dnsMonitor"
        d.timestamp = new Date()
        alarmList.add(d)

        sleep(1000)
        d = new AlarmDataDO()
        d.type = "docker"
        d.alarmType = "dnsMonitor"
        d.timestamp = new Date()
        alarmList.add(d)

        sleep(1000)
        d = new AlarmDataDO()
        d.type = "docker"
        d.alarmType = "dnsMonitor"
        d.timestamp = new Date()
        alarmList.add(d)

        sleep(1000)
        d = new AlarmDataDO()
        d.type = "non-docker"
        d.alarmType = "dnsMonitor"
        d.timestamp = new Date()
        alarmList.add(d)

        sleep(1000)
        d = new AlarmDataDO()
        d.type = "non-docker"
        d.alarmType = "dnsMonitor"
        d.timestamp = new Date()
        alarmList.add(d)

        println a.alarmJson("non-docker", alarmList)
    }
}
