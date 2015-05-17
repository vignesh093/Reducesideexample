import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class Reducereducer extends Reducer<ReduceWritable,Text,Text,Text>
{
	public void reduce(ReduceWritable key,Iterable<Text> value,Context context) throws IOException,InterruptedException
	{
		Text temp1,temp2;
		Iterator<Text> myit=value.iterator();
		temp1=myit.next();
		while(myit.hasNext())
		{
			temp2=myit.next();
			context.write(temp1,temp2);
		}
	}

}
