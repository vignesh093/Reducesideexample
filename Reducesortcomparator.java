import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class Reducesortcomparator extends WritableComparator{

	protected Reducesortcomparator() {
		super(ReduceWritable.class,true);
	}
	@SuppressWarnings("rawtypes")
	public int compare(WritableComparable s,WritableComparable s1)
	{
		ReduceWritable s2=(ReduceWritable)s;
		ReduceWritable s3=(ReduceWritable)s1;
		int cmp=s2.getfirst().compareTo(s3.getfirst());
		if(cmp==0)
		{
			cmp=s2.getsecond().compareTo(s3.getsecond());
		}
		return cmp;
	}
	

}
