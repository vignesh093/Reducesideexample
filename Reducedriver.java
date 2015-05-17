
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class Reducedriver {
	public static void main(String args[]) throws Exception
	{
		if(args.length!=3)
			{
			System.err.println("Usage: Worddrivernewapi <input path1> <inputpath2> <output path>");
			System.exit(-1);
			}
		Configuration conf=new Configuration();
		Job job=new Job(conf,"Reducesideexample");
		
		job.setJarByClass(Reducedriver.class);
		job.setJobName("Reducedriver");
		Path path1=new Path(args[0]);
		Path path2=new Path(args[1]);
		MultipleInputs.addInputPath(job,path1,TextInputFormat.class,Reducemapper1.class);
		MultipleInputs.addInputPath(job,path2,TextInputFormat.class,Reducemapper2.class);
		FileOutputFormat.setOutputPath(job,new Path(args[2]));

		//job.setMapperClass(Reducemapper1.class);
		job.setPartitionerClass(Reducepartitioner.class);
		//job.setSortComparatorClass(Reducesortcomparator.class);
		job.setGroupingComparatorClass(Reducegroupcomparator.class);
		job.setReducerClass(Reducereducer.class);
		//job.setNumReduceTasks(0);
		job.setMapOutputKeyClass(ReduceWritable.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		 job.setOutputFormatClass(TextOutputFormat.class);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}

}
