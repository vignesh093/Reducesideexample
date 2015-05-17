import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class Reducemapper1 extends Mapper<LongWritable,Text,ReduceWritable,Text>
{
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String s23=value.toString();
		String[] s14=s23.split(",");
		context.write(new ReduceWritable(Integer.parseInt(s14[0]),0),new Text(s14[1]));
	}

}
