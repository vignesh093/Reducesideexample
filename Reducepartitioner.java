
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


public class Reducepartitioner extends Partitioner<ReduceWritable,Text>{

	@Override
	public int getPartition(ReduceWritable s, Text s1, int numPartitions) {
		
		return Math.abs(s.getfirst().get() * 127) % numPartitions;	
	}
	

}
