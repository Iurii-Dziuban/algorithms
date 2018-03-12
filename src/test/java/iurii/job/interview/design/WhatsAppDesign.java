package iurii.job.interview.design;

/**
 *  System design: messaging service like whats app/ facebook messenger / weChat / ICQ / Jabber
 *  https://www.youtube.com/watch?v=5m0L0k8ZtEs
 *  Super broad question. (High Scalability Blog: http://highscalability.com)
 *  - How well you ask questions in the beginning
 *  - How you tackle the problem
 *
 *  Simple features:
 *  - mobile chat with two people (broader: group chat), media text (broader: images, voice, video)
 *  - Sent/Delivered/Read check marks
 *  - Push notification (more like streaming than messaging)
 *
 *  Additional:
 *  - using cache (history, logs)
 *  - different scaling
 *  - group chat
 *  - db replication/sharding
 *  - client side back up
 *  - monetize it (advertisement, stickers, emoji, usage limit, premium staff)
 *
 *  Derived architecture:
 *  Two clients connect to the server (load balancing should be put in between client and server)
 *  - Asynchronous. Scaling horizontally - additional servers. It should not matter to which server clients are connected
 *  - Server should have queues to store messages to be delivered by client. Queues are ephemeral - could be released if empty
 *  - When second client is online, messages are delivered to second client and deleted on server or stored in logs (security?)
 *  - Messages can be delivered in wrong order because different servers can have race conditions to deliver messages to client
 *
 *  - When server ACK(messageId) to first client that message is stored on it. Sent check mark.
 *  - When server delivered to second client - second connection to first client is opened to send ACK(messageId)
 *  for Delivered check
 *  - When second client opens the app - different server can be used to deliver Read ACK(messageId) to first client
 *
 *  - Push notification delivered than user is online (not time critical). Fire and forget by nature.
 *  Deliver and have ACK that client received it. With google use google platform for android (For Iphone different one)
 */
public interface WhatsAppDesign {
}
