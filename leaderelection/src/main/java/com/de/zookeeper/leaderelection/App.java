package com.de.zookeeper.leaderelection;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        Leaderelection leaderElection = new Leaderelection();
        leaderElection.connectToZookeeper();
        leaderElection.volunteerForLeadership();
        leaderElection.reelectionLeader();
        leaderElection.run();
        leaderElection.close();
        System.out.println("Disconnected from zooKeeper, exiting application!");
    }
}
