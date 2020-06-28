package assessment.Int.problems;

import java.util.Set;
import java.util.stream.Collectors;

class PopularNFeatures2 {
	public static void main(String[] arr) {
		int numFeatures;
		int topFeatures;
		List<String> possibleFeatures;
		int numFeatureRequests;
		List<String> featureRequests;

		topFeatures = 2;
		possibleFeatures = new ArrayList<String>(Arrays.asList("storage", "battery", "hover","alexa","waterproof","solar"));
		numFeatures = possibleFeatures.size();
		featureRequests = new ArrayList<String>(Arrays.asList("I wish my Kindle had even more storage",
				"I wish the battery life on my Kindle lasted 2 years", "I read in the bath and would enjoy a waterproof Kindle",
				"I want to take my Kindle into the hover. Waterproof please waterproof!", "It would be neat if my Kindle would hover on my desk when not in use",
				"How cool would it be if my Kindle charged in the sun via solar power?"	));
		numFeatureRequests = featureRequests.size();
		System.out.println("- topFeatures=" + topFeatures);
		System.out.println("- possibleFeatures=" + possibleFeatures);
		System.out.println("- numFeatures=" + numFeatures);
		System.out.println("- featureRequests=" + featureRequests);
		System.out.println("- numFeatureRequests=" + numFeatureRequests);
		System.out.println("result ="
				+ popularNFeatures(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests));

		topFeatures = 2;
		possibleFeatures = new ArrayList<String>(Arrays.asList("anacell", "cetracular", "betacellular"));
		numFeatures = possibleFeatures.size();
		featureRequests = new ArrayList<String>(Arrays.asList(
				"I love anacell Best services; Best services provided by anacell", "betacellular has great services",
				"deltacellular provides much better services than betacellular", "cetracular is worse than anacell",
				"Betacellular is better than deltacellular."));
		numFeatureRequests = featureRequests.size();
		System.out.println("- topFeatures=" + topFeatures);
		System.out.println("- possibleFeatures=" + possibleFeatures);
		System.out.println("- numFeatures=" + numFeatures);
		System.out.println("- featureRequests=" + featureRequests);
		System.out.println("- numFeatureRequests=" + numFeatureRequests);
		System.out.println("result ="
				+ popularNFeatures(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests));

		topFeatures = 2;
		possibleFeatures = new ArrayList<String>(
				Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell"));
		numFeatures = possibleFeatures.size();
		featureRequests = new ArrayList<String>(Arrays.asList(
				"I love anacell Best services; Best services provided by anacell", "betacellular has great services",
				"deltacellular provides much better services than betacellular", "cetracular is worse than anacell",
				"Betacellular is better than deltacellular."));
		numFeatureRequests = featureRequests.size();
		System.out.println("- topFeatures=" + topFeatures);
		System.out.println("- possibleFeatures=" + possibleFeatures);
		System.out.println("- numFeatures=" + numFeatures);
		System.out.println("- featureRequests=" + featureRequests);
		System.out.println("- numFeatureRequests=" + numFeatureRequests);
		System.out.println("result ="
				+ popularNFeatures(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests));

		topFeatures = 2;
		possibleFeatures = new ArrayList<String>(
				Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell"));
		numFeatures = possibleFeatures.size();
		featureRequests = new ArrayList<String>(Arrays.asList(
				"I love !!!anacell^-- Best services; Best services provided by ---anacell",
				"betacellular has great services", "!!!!deltacellular provides much better services than betacellular",
				"cetracular is worse than ---anacell", "Betacellular is better than deltacellular."));
		numFeatureRequests = featureRequests.size();
		System.out.println("- topFeatures=" + topFeatures);
		System.out.println("- possibleFeatures=" + possibleFeatures);
		System.out.println("- numFeatures=" + numFeatures);
		System.out.println("- featureRequests=" + featureRequests);
		System.out.println("- numFeatureRequests=" + numFeatureRequests);
		System.out.println("result ="
				+ popularNFeatures(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests));
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static ArrayList<String> popularNFeatures(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
		ArrayList<String> res = new ArrayList<>();
		Set<String> features = new HashSet<String>(possibleFeatures);
		Map<String, Word> wordsMap = new HashMap<String, Word>();
		int i2 = 0;
		for (String texto : featureRequests.stream().map(e -> e.toLowerCase().replaceAll("[^ a-z]", ""))
				.collect(Collectors.toList())) {
			List<String> lsWords = Arrays.asList(texto.replaceAll(" ", " ").split(" "));
			System.out.println(lsWords);
			for (String word : lsWords) {
				if (features.contains(word)) {
					Word w;

					if (wordsMap.containsKey(word))
						w = wordsMap.get(word);
					else
						w = new Word(word, 0);
					w.count++;
					w.featuresToReturn.add(i2);
					wordsMap.put(word, w);
				}
			}
			i2++;
		}
		
		PriorityQueue<Word> pq = new PriorityQueue<>((Word w1, Word w2)-> {
				if (w1.count != w2.count)
					return Integer.compare(w2.count, w1.count);
				else if (w1.featuresToReturn.size() != w2.featuresToReturn.size())
					return Integer.compare(w2.featuresToReturn.size(), w1.featuresToReturn.size());
				else
					return w1.word.compareTo(w2.word);
			});


//		PriorityQueue<Word> pq = new PriorityQueue<>(new Comparator<Word>() {
//
//			@Override
//			public int compare(Word w1, Word w2) {
//				if (w1.count != w2.count)
//					return Integer.compare(w2.count, w1.count);
//				else if (w1.featuresToReturn.size() != w2.featuresToReturn.size())
//					return Integer.compare(w2.featuresToReturn.size(), w1.featuresToReturn.size());
//				else
//					return w1.word.compareTo(w2.word);
//			}
//		});

		pq.addAll(wordsMap.values());

		while (!pq.isEmpty() && res.size() < topFeatures) {
			Word poll = pq.poll();
			res.add(poll.word);
		}

		return res;

	}

	// METHOD SIGNATURE ENDS
	private static class Word {
		String word;
		Integer count;
		Set<Integer> featuresToReturn;

		public Word(String word, Integer count) {
			this.word = word;
			this.count = count;
			this.featuresToReturn = new HashSet<>();
		}
	}
}