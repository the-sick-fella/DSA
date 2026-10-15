class Tweet {
    int id;
    int time;

    public Tweet(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

class Twitter {
    Map<Integer, List<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followMap;
    int counter;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        counter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        Tweet tweet = new Tweet(tweetId, counter);
        tweetMap.get(userId).add(tweet);
        counter++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> a.time - b.time);

        if (tweetMap.containsKey(userId)) {
            List<Tweet> tweets = tweetMap.get(userId);
            for (int i = 1; i <= 10; i++) {
                if (tweets.size() - i < 0)
                    break;
                heap.offer(tweets.get(tweets.size() - i));
                if (heap.size() > 10)
                    heap.poll();
            }
        }

        if (followMap.containsKey(userId)) {
            Set<Integer> following = followMap.get(userId);
            for (int user : following) {
                if (!tweetMap.containsKey(user))
                    continue;
                List<Tweet> tweets = tweetMap.get(user);
                for (int i = 1; i <= 10; i++) {
                    if (tweets.size() - i < 0)
                        break;
                    heap.offer(tweets.get(tweets.size() - i));
                    if (heap.size() > 10)
                        heap.poll();
                }
            }
        }

        while (!heap.isEmpty()) {
            ans.add(heap.poll().id);
        }
        Collections.reverse(ans);
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId))
            return;
        Set<Integer> set = followMap.get(followerId);
        set.remove(Integer.valueOf(followeeId));
        if(set.size() == 0) followMap.remove(followerId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */