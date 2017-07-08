package mapreduce.task8_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author arvind
 * This class provides the reducer implementation for Assignment 6.1 task 8_2
 */
public class Task8Reducer extends Reducer<IntWritable, Text, Text, IntWritable>{
	
	/**
	 * The mapper outputs total units sold for a company as key and company name as value.
	 * Since there is only a single reducer, all key value pairs will come to the same reducer. 
	 * The key value pairs will be sorted based on the key thus achieving our objective of sorting 
	 * the input data by the total units sold. 
	 * 
	 * In the input, the company name was followed by the total number of units osld in each line. 
	 * To maintain the same, the reducer outputs the company name as the key and total units sold as the value.
	 * So, the output key type is Text and the output value type is IntWritable  
	 */
	@Override
	protected void reduce(IntWritable totalUnitsSold, Iterable<Text> companies,
			Reducer<IntWritable, Text, Text, IntWritable>.Context context) 
					throws IOException, InterruptedException {
		
		for(Text companyName : companies) {
			context.write(companyName, totalUnitsSold);
		}
		
	}
	
}
