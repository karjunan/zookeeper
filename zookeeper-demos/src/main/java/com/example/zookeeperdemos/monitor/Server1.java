package com.example.zookeeperdemos.monitor;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.UUID;
import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

@SpringBootApplication
public class Server1 {

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
//		SpringApplication.run(ZookeeperDemosApplication.class, args);

		String id = UUID.randomUUID().toString();
		System.out.println("ID");
		ZooKeeper zooKeeper = new ZooKeeper("localhost:2181",15000,null);
		var createResponse = zooKeeper.create("/server-"+id,id.getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, null);
		System.out.println(createResponse);
		Thread.sleep(100_000_000);
	}

}
