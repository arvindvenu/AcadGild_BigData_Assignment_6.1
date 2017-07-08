echo "Executing Command: hadoop fs -ls /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/output"
hadoop fs -ls /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/output
echo "#####################################################################################"
echo

echo "Executing Command: hadoop fs -cat /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/output/part-*"
hadoop fs -cat /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/output/part-*
echo
echo "#####################################################################################"
echo


hadoop fs -get /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/output /home/arvind/hadoop/acadgild/assignments/assignment_$1/task$2/hadoop_output

mkdir -p /home/arvind/hadoop/acadgild/assignments/assignment_$1/task$2/assignment_executables

cp * /home/arvind/hadoop/acadgild/assignments/assignment_$1/task$2/assignment_executables

