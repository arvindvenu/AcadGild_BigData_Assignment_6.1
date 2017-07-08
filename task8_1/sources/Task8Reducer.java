package mapreduce.task8_1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author arvind
 * This class provides the reducer implementation for Assignment 6.1 task 8_2
 */
public class Task8Reducer 
							extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	/**
	 * The mapper outputs companyName as key and value as 1
	 * Now the reducer will take a particular companyName 
	 * and the list of values associated with it. It will sum up these values and
	 * output companyName as key and the total as the value thereby giving the total 
	 * units sold for each company
	 */
	@Override
	protected void reduce(Text companyName, Iterable<IntWritable> listOfUnitsSold,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) 
					throws IOException, InterruptedException {
		int totalUnitsSoldForACompany = 0;
		for(IntWritable unitsSold : listOfUnitsSold) {
			totalUnitsSoldForACompany += unitsSold.get();
		}
		context.write(companyName, new IntWritable(totalUnitsSoldForACompany));
	}
	
}
