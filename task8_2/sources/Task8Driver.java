package mapreduce.task8_2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;



/**
 * @author arvind
 * This class is the driver (main class) for Assignment 6.1 task 8_2. This is the 
 * first point of entry into the map reduce program. In this assignment, we take as
 * input a file containing television sales data. In an earlier assignment, the total 
 * units sold for each company was calculated. In task Assignment 6.1 task 8_1, the output file 
 * from that assignment was converted into a sequence file. This sequence file will be used as 
 * input to this job   
 */
public class Task8Driver {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		// initialize the configuration
		Configuration conf = new Configuration();
		
		// create a job object from the configuration and give it any name you want 
		Job job = new Job(conf, "Assignment_6.1 -> Task_8_2 -> "
				+ "Sort_Number_Of_Units_Sold");
		
		// java.lang.Class object of the driver class
		job.setJarByClass(Task8Driver.class);

		// map function outputs key-value pairs. 
		// What is the type of the key in the output 
		// We want to sort based on the total units sold
		// The reduce phase does sorting based on the key
		// Hence the key type output by the mapper will be IntWritable 
		job.setMapOutputKeyClass(IntWritable.class);
		// map function outputs key-value pairs. 
		// What is the type of the value in the output
		// In this case the value output by the mapper 
		// will be the company name. So the type is Text
		job.setMapOutputValueClass(Text.class);
		
		// reduce function outputs key-value pairs. 
		// What is the type of the key in the output. 
		// In this case output is number of units sold per company. 
		// Key will be company name, So the type is Text
		job.setOutputKeyClass(Text.class);
		// reduce function outputs key-value pairs. 
		// What is the type of the value in the output. 
		// In this case output is number of units sold by the company 
		// So value type is IntWritable 
		job.setOutputValueClass(IntWritable.class);
		
		// Mapper class which has implemenation for the map phase
		job.setMapperClass(Task8Mapper.class);
		
		// Reducer class which has implemenation for the reducer phase
		job.setReducerClass(Task8Reducer.class);
		
		// Input is a sequence file output by task 8_1. So input format class is SequenceFileInputFormat
		job.setInputFormatClass(SequenceFileInputFormat.class);
		
		/* 
		 * Output file is a simple text file. So, output format is TextOutputFormat
		 */
		job.setOutputFormatClass(TextOutputFormat.class);

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
