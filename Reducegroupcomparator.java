import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class Reducegroupcomparator extends WritableComparator{

	protected Reducegroupcomparator() {
		super(ReduceWritable.class,true);
	}
	@SuppressWarnings("rawtypes")
	public int compare(WritableComparable s,WritableComparable s1)
	{
		ReduceWritable s2=(ReduceWritable)s;
		ReduceWritable s3=(ReduceWritable)s1;
		int cmp=compare(s2.getfirst(),s3.getfirst());
		return cmp;
	}
	

}
