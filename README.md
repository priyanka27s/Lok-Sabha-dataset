# Lok-Sabha-dataset
A dataset of tweets, tv coverage and election commission of india results website scrape during the election result declaration day for Lok Sabha elections. Current dataset for 2019 and 2014 Lok Sabha election result day.

The src subdirectory contains the code for capturing source code. It uses Twitter4J library. The keywords and user accounts that have been collected are embedded in the source code Capture.java

Within the data/tweets subdirectory each directory contains multipart zip files. On a unix/linux system first do

For 2014 elections:

cat tweet2014* > tweet2014full.zip

unzip tweet2014full.zip

For 2019 elections:

cat bf8* >bf8full.zip (for before8pm subdirectory)

unzip bf8full.zip

The above two did not collect the Tweet ID so the format of each line is 

RetweetCount + "@"+ TweetID it is in Reply to +"@" + User Screen Name it is in Reply to + "@" + Geo Location + "@" + FavoriteCount + "@" + Timestamp + "@" + Author User ID + "@" + Author Screen Name + " __ " + Tweet Text

cat af8* >af8full.zip (for after8pm subdirectory)

unzip af8full.zip

This after8pm collection also collected the Tweet ID so the format of each line is 

RetweetCount + "@"+ TweetID it is in Reply to +"@" + User Screen Name it is in Reply to + "@" + Geo Location + "@" + FavoriteCount + "@" + Timestamp + "@" + Author User ID + "@" + Author Screen Name + "@" + Tweet ID + " __ " + Tweet Text

