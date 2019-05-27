while :
do

	now=$(date +"%T")

	wget -N https://results.eci.gov.in/pc/en/partywise/index.htm -O /home/priyanka/research/latitude/research/2019/events/elections2019/eci/$now
	
 	sleep 1m
done
