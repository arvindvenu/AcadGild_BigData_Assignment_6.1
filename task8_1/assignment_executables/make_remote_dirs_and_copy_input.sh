echo "Executing Command: ls -l /home/arvind/hadoop/acadgild/assignments/assignment_$1/task$2/input"
ls -l /home/arvind/hadoop/acadgild/assignments/assignment_$1/task$2/input
echo "#####################################################################################"
echo

echo "Executing Command: ls -l /home/arvind/hadoop/acadgild/assignments/assignment_$1/task$2/jar"
ls -l /home/arvind/hadoop/acadgild/assignments/assignment_$1/task$2/jar
echo "#####################################################################################"
echo

echo "Executing Command: hadoop fs -rm -r /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/input"
hadoop fs -rm -r /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/input
echo "#####################################################################################"
echo

echo "Executing Command: hadoop fs -rm -r /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/output"
hadoop fs -rm -r /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/output
echo "#####################################################################################"
echo

echo "Executing Command: hadoop fs -mkdir -p /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2"
hadoop fs -mkdir -p /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2
echo "#####################################################################################"
echo

echo "Executing Command: hadoop fs -put /home/arvind/hadoop/acadgild/assignments/assignment_$1/task$2/input /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/input"
hadoop fs -put /home/arvind/hadoop/acadgild/assignments/assignment_$1/task$2/input /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/input
echo "#####################################################################################"
echo

echo "Executing Command: hadoop fs -ls /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/input"
hadoop fs -ls /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/input
echo "#####################################################################################"
echo

echo "Executing Command: hadoop fs -cat /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/input/*"
hadoop fs -cat /user/arvind/hadoop/hadoopdata/acadgild/assignment_$1/task$2/input/*
echo
echo "#####################################################################################"
echo
