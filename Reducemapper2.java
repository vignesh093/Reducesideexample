import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class Reducemapper2 extends Mapper<LongWritable,Text,ReduceWritable,Text>
{
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String s=value.toString();
		String[] s1=s.split(",");
		context.write(new ReduceWritable(Integer.parseInt(s1[2]),1),value);
	}

}
