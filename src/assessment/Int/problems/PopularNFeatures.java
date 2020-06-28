package assessment.Int.problems;

import java.util.*;

class PopularNFeatures
{
	public static void main(String[] arr) {
		int numFeatures;
        int topFeatures; 
        List<String> possibleFeatures;  
		int numFeatureRequests;
		List<String> featureRequests;
		
        topFeatures =2 ; 
        possibleFeatures = new ArrayList<String>(Arrays.asList("anacell", "cetracular", "betacellular"));  
        numFeatures = possibleFeatures.size();
		featureRequests =new ArrayList<String>(Arrays.asList("I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular." ));
		numFeatureRequests= featureRequests.size();
		System.out.println("- topFeatures"+topFeatures);
		System.out.println("- possibleFeatures"+possibleFeatures);
		System.out.println("- numFeatures"+numFeatures);
		System.out.println("- featureRequests"+featureRequests);
		System.out.println("- numFeatureRequests"+numFeatureRequests);
		System.out.println("result ="+popularNFeatures( numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests)) ;
	}
	
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static ArrayList<String> popularNFeatures(int numFeatures, 
	                                         int topFeatures, 
                                             List<String> possibleFeatures, 
											 int numFeatureRequests, 
											 List<String> featureRequests)
    {
       ArrayList<String> res = new ArrayList<>();
       Set<String> features = new HashSet<String>(possibleFeatures);
       Map<String, Word> wordsMap = new HashMap<String, Word>();
        for (int i = 0; i < numFeatureRequests; i++) {
           String featureRequest = featureRequests.get(i).replaceAll("[\\!?,;.]", "").toLowerCase();
           String[] words = featureRequest.split(" ");

           for (int j = 0; j < words.length; j++) {
               String word = words[j];
               if (features.contains(word)) {
                   Word w;

                   if (wordsMap.containsKey(word))
                       w = wordsMap.get(word);
                   else
                       w = new Word(word, 0);
                   w.count++;
                   w.featuresToReturn.add(i);
                   wordsMap.put(word, w);
               }
           }
       }
       PriorityQueue<Word> pq = new PriorityQueue<>(new Comparator<Word>() {

           @Override
           public int compare(Word w1, Word w2) {
               if (w1.count != w2.count)
                   return Integer.compare(w2.count, w1.count);
               else if (w1.featuresToReturn.size() != w2.featuresToReturn.size())
                   return Integer.compare(w2.featuresToReturn.size(), w1.featuresToReturn.size());
               else
                   return w1.word.compareTo(w2.word);
           }
       });

       pq.addAll(wordsMap.values());
       
       while(!pq.isEmpty() && res.size() <= numFeatureRequests ) {
			Word poll = pq.poll();
			res.add(poll.word);
		}
       return res;
    }
    // METHOD SIGNATURE ENDS
    private static class Word{
        String word;
        int count;
        Set<Integer> featuresToReturn;
        
        public Word(String word,int count){
            this.word=word;
            this.count = count;
            this.featuresToReturn = new HashSet<>();
        }
    }
}