package com.example.zookeeperdemos.distributedLock;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.UUID;

public class Server1 {

    static ZooKeeper zooKeeper;
    public static void main(String[] args) {
        String UUID = java.util.UUID.randomUUID().toString();
        String root = "/locks";

        Watcher watcher = (watchedEvent) -> {
            if(watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
                getLockAndWait();
            }
        };
    }

    private static void getLockAndWait() {
    }


}
