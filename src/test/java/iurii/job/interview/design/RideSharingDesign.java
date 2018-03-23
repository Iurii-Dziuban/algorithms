package iurii.job.interview.design;

/**
 * Ride sharing service like Uber or Lyft
 * https://www.youtube.com/watch?v=J3DY3Te3A_A
 * Overview:
 * - Payment management
 * - Customer feedback gathering
 * Core features
 * - Finding and matching customers to drivers
 * - Mapping and routing ETA (estimated time of arrival)
 *
 * Bottom Up Approach - Storage - All trips - stores trips in multiple data centers and store to closest geo-located
 * If offline one data center, store to another. Availability is important. Eventual consistency.
 *
 * Low latency calls are needed. Uber - sql and non sql. Cassandra / MySQL
 * Store archive in Data Warehouse (Hadoop) to run more expensive queries. Business analytics
 *
 * Caching layer - in-memory database, to use for static data like maps, user data, but drivers positions are dynamic.
 *
 * Logging - which driver at which position, did what. As real time as possible.
 * From endpoints : customers or drivers: small messages about positions.
 * Cluster of Kafka servers is used to store the messages, ensure they are not lost and can be stream processed in real time
 * Kafka can use Hadoop to store/persist data.
 *
 * SOA - service oriented architecture
 * Provisioning services running - get software to newly running servers or containers. Ex. Terraform/Puppet/Docker - shielded containers,
 * that feels like separate host, but in fact many docker containers are running on the same linux machine
 *
 * Mesos/Kubernetes - container orchestration tool:
 * manages/coordinates collaboration between services. Manages life cycles of the services during runtime
 *
 * In order to connect client to particular service - network routing problem as efficient as possible
 * and routing mechanism should know the state of the services. Because such routing is difficult -
 * many services are designed stateless, so that it will not matter to which service client will be connected
 *
 * Testing:
 * - Unit test
 * - Distributed system with services linked and chained - resilience testing, in case part of system is not working.
 * Tool Hailstorm - goes to some services and puts them offline on some of group of hosts (shadow fleets),
 * that are on production but does not serve the customers. Log and observe, how system works.
 *
 * Graph problem (routing) city map to graph:
 * - route from driver to you
 * - route to destination
 * Shortest way from one node to another: speed allowance - weighted edges (can be precomputed)
 * ETA in real time (traffic information). Relying on historical data : past similar situations, fallback approach:
 * NP - complete (Dejkstra or A*) to calculate ETA with that - split city into smaller parts that are independent (not easy)
 * as possible and small graphs can be computed quickly.
 */
public interface RideSharingDesign {
}
