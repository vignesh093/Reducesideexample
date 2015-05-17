import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;


public class ReduceWritable implements WritableComparable<ReduceWritable> {

	public IntWritable first;
	public IntWritable second;
	public ReduceWritable()
	{
	}
	public ReduceWritable(Integer first,Integer second)
	{
		this.first=new IntWritable(first);
		this.second=new IntWritable(second);
	}
	public ReduceWritable(ReduceWritable o)
	{
		first=o.first;
		second=o.second;
	}
	public ReduceWritable(IntWritable first,IntWritable second)
	{
		this.first=first;
		this.second=second;
	}
	public void set(IntWritable first,IntWritable second)
	{
		this.first=first;
		this.second=second;
	}
	public void set(Integer first,Integer second)
	{
		this.first=new IntWritable(first);
		this.second=new IntWritable(second);
	}
	public IntWritable getfirst()
	{
		return this.first;
	}
	public IntWritable getsecond()
	{
		return this.second;
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		first.readFields(in);
		second.readFields(in);
	}
	@Override
	public void write(DataOutput out) throws IOException {
		first.write(out);
		second.write(out);		
	}

	
	@Override
	public int compareTo(ReduceWritable s)
	{
		int cmp=first.compareTo(s.getfirst());
		if(cmp==0)
		{
			cmp=second.compareTo(s.getsecond());
		}
		return cmp;
	}
	public String toString()
	{
		return first+ " " +second;
	}
}
