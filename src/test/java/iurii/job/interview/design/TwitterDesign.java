package iurii.job.interview.design;

/**
 * Message service like tweeter:
 * https://www.youtube.com/watch?v=KmAyPUv9gOY
 *
 * Very broad question, design will cover next core features:
 * - Sending a tweet (tweeting)
 * - Having Timeline (User = Having own tweets, tweets you re-tweeted; Home = tweets from people, you follow
 * - Following
 *
 * Naive solution: Relational database - user and tweet table (one user to many tweets relationship)
 * Limitation: big sql query to give all tweets from the users I follow
 * - it is hard to do, cause tweet table will grow (indexing table and sharding can be help for a while)
 *
 * Better solution: characteristics - a lot of tweets, but not many writes. So heavy read system.
 * Care about speed but care more about availability and less about consistency.(Eventual consistency)
 *
 * PUT/POST http tweet - load balancing - geo location (close to your region) - put into in-memory database -
 * pre-compute in-memory other home time-lines to Redis cluster. And each timeline replicated 3 times.
 * Machines with Redis need to have a lot of RAM to be able to store time-lines.
 *
 * Optimization is to store time-lines only for users that were active last some days.
 * For inactive user computation will take a bit longer to compute it.
 *
 * Replicas eventually will be the same.
 * If a lot of followers (100) tweet will land 3 times more(300).
 * Performance problem / weakness - if there is someone famous - a lot of followers of celebrity.
 *
 * Mixed approach can be used: sql and nosql. If there is a celebrity pre-compute them on read.
 *
 * Trade offs : fast reads (availability), eventual consistency, space (mainly text - not an issue)
 *
 * Loadbalancer can find quickly machines where redis machins have needed timelines
 *
 * Additional:
 * - Search is independent system (notifications - push notification)
 * - Monetization - advertisement
 *
 *
 */
public interface TwitterDesign {
}
