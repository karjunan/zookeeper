package com.example.zookeeperdemos.monitor;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class Monitor {

    public static ZooKeeper zooKeeper;
    public static void main(String[] args) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper("localhost:2181", 15000, (watcher) -> {

            try {
                List<String> childern = zooKeeper.getChildren("/",true, null);
                for (String v  : childern) {
                    System.out.println(v +" ");
                }
                System.out.println(" ");
            } catch (KeeperException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread.sleep(100_100_100);
    }
}
