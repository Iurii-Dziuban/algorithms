package iurii.job.interview.generic.memorymodel;

/**
 * In general JMM consists of the Heap and PermGen (removed in java 8 - only heap, but metaspace is introduced in heap).
 *
 * Heap is managed by JVM, PermGen is constant-size and not managed by JVM.
 *
 * Call stack, java classes, String pool are stored in PermGen space.
 * Thread pool were able
 *
 * Heap consists of two parts: Young generation and Old generation.
 * Long live objects are in the Old generation.
 * Young generations consists of two parts: Eden and Survivor space.
 * Newly created objects are in Eden, after surviving minorGC (only on Young generation) they move together to Survivor space.
 * After surviving many minorGC they are moved to Old generation.
 *
 * Major GC scans all living objects: Young and Old Generation space and can take a lot of time
 *
 * GC process
 * 1) Mark objects for deletion
 * 2) normal delete
 * 3) delete with compacting space (with moving to Survivor space) for better performance to create new objects
 *
 * Types of GC:
 * 1) Serial GC - simplest GC. with one thread does mark-sweep-compact. Have both minorGC and majorGC.
 * 2) Parallel GC - uses N threads for the young generation and one for old. Also called throughput GC because of spawning multiple threads.
 * 3) Parallel Old GC - uses N threads as well for the Old generation (not only for Young generation)
 * 4) CMS GC (concurrent mark sweep) - also referred as parallel low pause collector as for young generation it is same as parallel, but on Old generation it tries to progress with the application threads. So no long pauses should occur.
 * 5) G1GC - garbage first collector - is available from java 7, in java 8 as a standard and should replace CMS.
 * Parallel, concurrent and incrementally compacting low pause. Does not have separation between young and old generation.
 * Slits heap into equal region for each of its threads and first collects region with least live data
 *
 * More info
 * https://www.journaldev.com/2856/java-jvm-memory-model-memory-management-in-java
 */
public interface MemoryModel {

}
