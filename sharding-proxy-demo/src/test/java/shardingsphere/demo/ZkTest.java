package shardingsphere.demo;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.List;

/**
 * ZkTest
 *
 * @author naah
 * @date 2018-05-08 下午2:37
 * @desc
 */
@FixMethodOrder(MethodSorters.JVM)//默认顺序执行
public class ZkTest {
    private static final String connectionString = "10.250.250.116:2181";
    private static final int sessionTimeout = 2000;
    private ZooKeeper zkClient = null;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    zkClient.getChildren("/", true);//递归监听
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Test
    public void testGetClidren() throws KeeperException, InterruptedException {
        byte[] data = zkClient.getData("/sharding-proxy-demo/orchestration_ds/config/proxy/rule", true, new Stat());
        String yml = new String(data);
        System.out.println(yml);
//        Thread.sleep(Integer.MAX_VALUE);//线程阻塞测试watch，监听器只生效一次
    }


    @Test
    public void testSetChild() throws KeeperException, InterruptedException {
        byte[] data = zkClient.getData("/sharding-proxy-demo/orchestration_ds/config/proxy/rule", true, new Stat());
        String yml = new String(data);
        yml = yml.replaceAll("algorithmExpression: ds0","algorithmExpression: ds\\$\\{order_id % 2}");
        Stat stat = zkClient.setData("/sharding-proxy-demo/orchestration_ds/config/proxy/rule", yml.getBytes(), -1);
        System.out.println(stat);

    }



}
