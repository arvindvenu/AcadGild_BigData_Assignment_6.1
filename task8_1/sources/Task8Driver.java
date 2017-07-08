package mapreduce.task8_1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;



/**
 * @author arvind
 * This class is the driver (main class) for Assignment 6.1 task 8_1. This is the 
 * first point of entry into the map reduce program. In this assignment, we take as
 * input a file containing television sales data and filtering out invalid records.
 * Invalid records are those records which contain 'NA' in company name/ product name. 
 * Post that we need to find the total units sold for each company and output the result 
 * to a sequence file. This sequence file will be used as input to task 8_2
 */
public class Task8Driver {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		// initialize the configuration
		Configuration conf = new Configuration();
		
		// create a job object from the configuration and give it any name you want 
		Job job = new Job(conf, "Assignment_6.1 -> Task_8_1 -> "
				+ "Number_Of_Units_Sold_Per_company");
		
		// java.lang.Class object of the driver class
		job.setJarByClass(Task8Driver.class);

		// map function outputs key-value pairs. 
		// What is the type of the key in the output 
		job.setMapOutputKeyClass(Text.class);
		// map function outputs key-value pairs. 
		// What is the type of the value in the output
		job.setMapOutputValueClass(IntWritable.class);
		
		// reduce function outputs key-value pairs. 
		// What is the type of the key in the output. 
		// In this case output is number of units sold per company. 
		// So key type is Text 
		job.setOutputKeyClass(Text.class);
		// reduce function outputs key-value pairs. 
		// What is the type of the value in the output. 
		// In this case output is number of units sold per company. 
		// So value type is IntWritable 
		job.setOutputValueClass(IntWritable.class);
		
		// Mapper class which has implemenation for the map phase
		job.setMapperClass(Task8Mapper.class);
		
		// Reducer class which has implemenation for the reducer phase
		job.setReducerClass(Task8Reducer.class);
		
		// Input is a text file. So input format is TextInputFormat
		job.setInputFormatClass(TextInputFormat.class);
		
		/* Output is also a text file. But now we want it in a special encoded format 
		 * called SequenceFileOutputFormat
		 */
		job.setOutputFormatClass(SequenceFileOutputFormat.class);

		/*
		 * The input path to the job. The map task will
		 * read the files in this path form HDFS 
		 */
		FileInputFormat.addInputPath(job, new Path(args[0]));
		
		/*
		 * The output path from the job. The map/reduce task will
		 * write the files to this path to HDFS. In this case the 
		 * reduce task will write to output path because number of 
		 * reducer tasks is not explicitly configured to be zero  
		 */
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		
		job.waitForCompletion(true);
	}
}
