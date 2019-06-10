import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.StallWarning;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Capture {
    public static void main(String[] args) throws TwitterException {

    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true);
    cb.setOAuthConsumerKey("");
    cb.setOAuthConsumerSecret("");
    cb.setOAuthAccessToken("");
    cb.setOAuthAccessTokenSecret("");
    cb.setHttpProxyHost("");
    cb.setHttpProxyPort();

    TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
    StatusListener listener = new StatusListener() { 

        public void onStatus(Status status) {
            //System.out.println(status.getRetweetCount() + "@"+ status.getInReplyToStatusId() + "@" + status.getInReplyToScreenName() + "@" +status.getPlace().getCountry() +"@" + status.getGeoLocation() + "@" + status.getFavoriteCount() + "@" + status.getCreatedAt() + "@" +status.getUser().getId() + "@" + status.getUser().getScreenName() + " __ " + status.getText());
            System.out.println(status.getRetweetCount() + "@"+ status.getInReplyToStatusId() +"@" + status.getInReplyToScreenName() + "@" + status.getGeoLocation() + "@" + status.getFavoriteCount() + "@" + status.getCreatedAt() + "@" +status.getUser().getId() + "@" + status.getUser().getScreenName() + " __ " + status.getText());
        }

        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
            System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
        }

        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
            System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
        }

        public void onScrubGeo(long userId, long upToStatusId) {
            System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
        }

	public void onStallWarning(StallWarning warning) {
	    System.out.println("Got stall warning: code " + warning.getCode() + " warning message  " + warning.getMessage());
	}

        public void onException(Exception ex) {
            ex.printStackTrace();
        }
    };

      FilterQuery fq = new FilterQuery();
      String keywords[] = {"Rahul", "Gandhi", "NaMo", "namo", "modi", "kejriwal", "arvind", "Modi", "Kejriwal", "Arvind", "Sonia", "Vishvas", "RaGa", "raga", "AK", "AAP", "BJP", "Congress", "cong", "aap", "bjp", "Sushma", "#Elections2014", "Priyanka", "sonia", "Amethi", "Verdict2014", "Mayawati", "Mamata"};
      long userids[] = {2183816041L,1910442534L,1806436518L,1642669674L,1642473805L,1617123242L,141633175L,1601307042L,1562806872L,1557459452L,1516758181L,1513504760L,1447949844L,1423007816L,1418662837L,1405220132L,1380986642L,1346439824L,1324334436L,1317076194L,1288175774L,1269695654L,1266608791L,307389069L,1263706735L,1251083774L,1154869812L,1153045459L,1148030178L,1141637624L,1131709837L,1119384594L,1072993274L,901132112L,861656581L,849477276L,846977912L,773726504L,764334150L,755718001L,711694309L,2299699574L,634426266L,628615518L,627355202L,551757469L,546639726L,512246934L,481222224L,481145204L,477479229L,471741741L,459849561L,444568008L,441636351L,418926544L,405427035L,385909720L,381949397L,373410448L,373280952L,371730289L,363797725L,358136545L,350128848L,347035710L,337065278L,332188446L,331136088L,328941811L,296612629L,295251095L,290452792L,287156977L,283410655L,275466164L,243852862L,243023355L,242253020L,241782346L,230856076L,219617448L,213739836L,207809313L,172057857L,167751947L,166665752L,165506153L,165085226L,160509668L,143409075L,141470251L,140047339L,138822469L,134546153L,131188226L,130104041L,123231276L,123209588L,112974530L,100435990L,97913631L,85657578L,83663427L,77732185L,76134964L,75989138L,75816710L,74105075L,72511763L,62101279L,60937837L,59983585L,58243368L,57948579L,56985219L,50943008L,49375859L,47055387L,44582818L,30417501L,29442361L,28082599L,27467714L,25123615L,24705126L,20427494L,19760270L,19438384L,18839785L,18358294L,13508182L,1667122507L,786958314L};

      fq.track(keywords);
      fq.follow(userids);

      twitterStream.addListener(listener);
      twitterStream.filter(fq);      
    }
}
