while :
do

	now=$(date +"%T")

	wget -N http://eciresults.nic.in -O /media/30F41381F413488C/elections2014/$now
	
 	sleep 1m
done
