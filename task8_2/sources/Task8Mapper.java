package mapreduce.task8_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author arvind
 * This class provides the mapper implementation for Assignment 6.1 task 8_2
 */
public class Task8Mapper extends Mapper<Text, IntWritable, IntWritable, Text>{
	
	/**
	 * The output from the previous task is a SequenceFileInputFormat. There the output key 
	 * type was text (company name) and the output value type was IntWritable (number of units sold). 
	 * That state is stored directly in the sequence file.  
	 * So the input key type in this job is Text (company name) and the input value type is IntWritable 
	 *   
	 * We want to sort the data based on the total units sold. Hence the 
	 * output key is total units sold and the value is the company name. So, output 
	 * key type is IntWritable and output value type is Text
	 * 
	 */
	public void map(Text companyName, IntWritable totalUnitsSold, Context context) 
			throws IOException, InterruptedException {
		context.write(totalUnitsSold, companyName);
		
	} 
}
