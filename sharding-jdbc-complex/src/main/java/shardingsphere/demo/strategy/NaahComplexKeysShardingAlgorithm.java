package shardingsphere.demo.strategy;

import io.shardingsphere.core.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * NaahComplexKeysShardingAlgorithm
 *
 * @author naah
 * @date 2018-07-30 上午10:16
 * @desc
 */
public class NaahComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm {
    private Logger logger = LoggerFactory.getLogger(NaahComplexKeysShardingAlgorithm.class);

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {
        logger.debug(availableTargetNames.toString());
        logger.debug(shardingValues.toString());
        String[] names = availableTargetNames.toArray(new String[availableTargetNames.size()]);
        Collection<String> collect = new HashSet<>();
        for (ShardingValue shardingValue : shardingValues) {
            if(shardingValue instanceof ListShardingValue){
                Collection<Integer> values = ((ListShardingValue<Integer>) ((ListShardingValue) shardingValue)).getValues();
                for (Integer value : values) {
                    collect.add(names[value%2]);
                }
            }

        }

        logger.debug(collect.toString());
        return collect;
    }
}
